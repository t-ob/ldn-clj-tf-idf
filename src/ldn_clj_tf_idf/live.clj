(ns ldn-clj-tf-idf.live
  (:require [ldn-clj-tf-idf.samples :refer [articles]]
            [ldn-clj-tf-idf.text :as text]
            [cascalog.api :refer :all]
            [cascalog.ops :as c]))

#_(require '[cascalog.playground :refer :all])
#_(bootstrap-emacs)

(defn document-word-frequencies
  [source]
  (<- [?label ?word ?freq]
      (source ?label ?word)
      (c/count :> ?freq)))

(defn document-max-word-frequencies
  [source]
  (<- [?label ?max-freq]
      (source ?label _ ?freq)
      (c/max ?freq :> ?max-freq)))

(defn tf
  [source]
  (let [word-freqs     (document-word-frequencies source)
        max-word-freqs (document-max-word-frequencies word-freqs)]
    (<- [?label ?word ?term-frequency]
        (word-freqs ?label ?word ?freq)
        (max-word-freqs ?label ?max-freq)
        (div ?freq ?max-freq :> ?term-frequency))))

(defmapop [idf-ratio [total-docs]]
  [freq]
  (/ (Math/log (/ total-docs freq))
     (Math/log 2)))

(defn idf
  [total-docs source]
  (let [word-freqs (document-word-frequencies source)]
    (<- [?word ?inverse-document-frequency]
        (word-freqs _ ?word _)
        (c/count ?total-freq)
        (idf-ratio total-docs ?total-freq :> ?inverse-document-frequency))))

(defbufferop [top-n [n]]
  [tuples]
  (take n (sort-by last > tuples)))

(defn tf-idf [total-docs source]
  (let [tf-in  (tf source)
        idf-in (idf total-docs source)]
    (<- [?label ?sorted-word ?sorted-tf-idf]
        (tf-in ?label ?word ?term-frequency)
        (idf-in ?word ?inverse-document-frequency)
        (* ?term-frequency ?inverse-document-frequency :> ?tf-idf)
        (top-n 10 ?word ?tf-idf :> ?sorted-word ?sorted-tf-idf))))

;; Let's see what we can learn from some classic texts on Project
;; Gutenberg.
(def texts
  [["dracula" "/Users/tomobrien/Downloads/gutenberg/dracula.txt"]
   ["alice" "/Users/tomobrien/Downloads/gutenberg/alice.txt"]
   ["frankenstein" "/Users/tomobrien/Downloads/gutenberg/frankenstein.txt"]
   ["sherlock" "/Users/tomobrien/Downloads/gutenberg/sherlock.txt"]
   ["oz" "/Users/tomobrien/Downloads/gutenberg/oz.txt"]])

(defn source-text [name path]
  (<- [?label ?word]
      (identity name :> ?label)
      ((lfs-textline path) ?line)
      (text/parse-line ?line :> ?parsed-line)
      (text/split-line ?parsed-line :> ?word)))

;; Combine is a built-in Cascalog operation which takes an arbitrary
;; number of sources and combines them if it can.
#_(let [source (apply combine
                    (for [[label path] texts]
                      (source-text label path)))]
  (?- (stdout)
      (tf-idf (count texts) source)))
