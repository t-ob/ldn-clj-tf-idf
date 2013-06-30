(ns ldn-clj-tf-idf.tf-idf
  (:require [ldn-clj-tf-idf.tf-idf.samples :as samples]
            [clojure.string :as str]
            [cascalog.api :refer :all]
            [cascalog.ops :as c]))

(def stopwords
  #{"a" "is" "of" "i" "the" "this" "you" "off" "ok" "should" "dont" "your" "youre" "on" "to" "but" "his" "it" "all" "him" "her" "more" "let" "us" "im" "me" "cant" "he" "she" "in" "my" "as" "not" "be" "at" "if" "so" "was" "and" "had" "that" "mr" "dr" "mrs" "ms"})

(defn stopword? [s]
  (contains? stopwords s))

(defn word-splitter [s]
  (remove stopword?
          (str/split s #"\s+")))

(defmapcatop [split-terms [split-fn]]
  [c]
  (map vector
       (split-fn c)))

(defmapop [idf [docs]]
  [freq]
  (/ (Math/log (/ docs freq))
     (Math/log 2)))

;; First, we take each document and create a count of each individual
;; word per document.
(defn document-word-frequencies [source]
  (<- [?label ?word ?freq]
      (source ?label ?document)
      (split-terms #'word-splitter ?document :> ?word)
      (c/count ?freq)))

;; To normalise our calculations, we require the maximum word
;; frequency for each document.
(defn document-max-word-frequency [source]
  (<- [?label ?max-freq]
      (source ?label _ ?freq)
      (c/max ?freq :> ?max-freq)))

;; We can now calculate the term frequencies for each document.
(defn term-frequency [word-freqs max-word-freqs]
  (<- [?label ?word ?tf]
      (word-freqs ?label ?word ?freq)
      (max-word-freqs ?label ?max-freq)
      (div ?freq ?max-freq :> ?tf)))



;; For calculating IDF, we first need the total frequencies of all
;; words across all documents.
(defn total-frequencies [source]
  (<- [?word ?total-freq]
      (source _ ?word _)
      (c/count ?total-freq)))

(defn inverse-document-frequency [n source]
  (<- [?word ?idf]
      (source _ ?word _)
      (c/count ?total-freq)
      (idf n ?total-freq :> ?idf)))

(defn tf-idf [term-freq inv-doc-freq]
  (<- [?label ?word ?tf-idf]
      (term-freq ?label ?word ?tf)
      (inv-doc-freq ?word ?idf)
      (* ?tf ?idf :> ?tf-idf)))

(defbufferop [top-n [n]]
  [tuples]
  (take n
        (sort-by last
                 >
                 tuples)))

;; (let [source (samples/documents samples/bowie-lyrics)
;;       n (count source)
;;       word-freqs (document-word-frequencies source)
;;       max-word-freqs (document-max-word-frequency word-freqs)
;;       term-freq (term-frequency word-freqs (document-max-word-frequency word-freqs))
;;       inv-doc-freq (inverse-document-frequency n word-freqs)
;;       source (tf-idf term-freq inv-doc-freq)]
;;   (?- (stdout)
;;       (<- [?document ?b ?c]
;;           (source ?document ?word ?tf-idf)
;;           (top-n 10 ?word ?tf-idf :> ?b ?c))))

(defn remove-stopwords [line]
  (str/replace line
               (re-pattern (format "(%s)"
                                   (str/join "|"
                                             (map (partial format "\\b+%s\\b+")
                                                  stopwords))))
               ""))

(defn parse-line [line]
  (-> line
      (str/lower-case)
      (str/replace #"[^\p{L}\s]" "")
      (remove-stopwords)
      (str/trim)
      (not-empty)))

(defmapcatop split-line [line]
  (str/split line #"\s+"))

(def sample-texts
  [["dracula" "/Users/tomobrien/Downloads/gutenberg/dracula-sample.txt"]
   ["alice" "/Users/tomobrien/Downloads/gutenberg/alice-sample.txt"]
   ["frankenstein" "/Users/tomobrien/Downloads/gutenberg/frankenstein-sample.txt"]])

(defn source-text [name path]
  (<- [?label ?word]
      (identity name :> ?label)
      ((lfs-textline path) ?line)
      (parse-line ?line :> ?parsed-line)
      (split-line ?parsed-line :> ?word)))

(defn tob-document-word-frequencies [source]
  (<- [?label ?word ?freq]
      (source ?label ?word)
      (c/count ?freq)))

(def texts
  [["dracula" "/Users/tomobrien/Downloads/gutenberg/dracula.txt"]
   ["alice" "/Users/tomobrien/Downloads/gutenberg/alice.txt"]
   ["frankenstein" "/Users/tomobrien/Downloads/gutenberg/frankenstein.txt"]
   ["earnest" "/Users/tomobrien/Downloads/gutenberg/earnest.txt"]
   ["sherlock" "/Users/tomobrien/Downloads/gutenberg/sherlock.txt"]
   ["peterpan" "/Users/tomobrien/Downloads/gutenberg/peterpan.txt"]
   ["oz" "/Users/tomobrien/Downloads/gutenberg/oz.txt"]
   ["treasure" "/Users/tomobrien/Downloads/gutenberg/treasure.txt"]
   ["war" "/Users/tomobrien/Downloads/gutenberg/war.txt"]
   ["origin" "/Users/tomobrien/Downloads/gutenberg/origin.txt"]])

#_(let [data texts]
  (let [n (count data)
        in   (apply combine
                    (for [[name path] data]
                      (source-text name path)))
        word-freqs (tob-document-word-frequencies in)
        max-word-freqs (document-max-word-frequency word-freqs)
        term-freq (term-frequency word-freqs (document-max-word-frequency word-freqs))
        inv-doc-freq (inverse-document-frequency n word-freqs)
        source (tf-idf term-freq inv-doc-freq)]
    (?- (stdout)
        (<- [?label ?b ?c]
            (source ?label ?word ?tf-idf)
            (top-n 10 ?word ?tf-idf :> ?b ?c)))))



