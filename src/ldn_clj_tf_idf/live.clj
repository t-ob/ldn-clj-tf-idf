(ns ldn-clj-tf-idf.live
  (:require [ldn-clj-tf-idf.samples :refer [articles]]
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

(defn term-frequency
  [source]
  (let [word-freqs     (document-word-frequencies source)
        max-word-freqs (document-max-word-frequencies word-freqs)]
    (<- [?label ?word ?term-frequency]
        (word-freqs ?label ?word ?freq)
        (max-word-freqs ?label ?max-freq)
        (div ?freq ?max-freq :> ?term-frequency))))

;; Now let's calculate the inverse document frequency score for each
;; distinct word across all documents. The idf-score for a given word
;; in a set of documents is equal to the ratio of the total number of
;; documents to the number of documents containing the given word,
;; taken to the log base 2.
(defmapop [idf-ratio [total-docs]]
  [freq]
  (/ (Math/log (/ total-docs freq))
     (Math/log 2)))

#_(let [source [[1]
                [2]
                [3]]
        n      (count source)]
    (?- (stdout)
        (<- [?x ?idf]
            (source ?x)
            (idf-ratio n ?x :> ?idf))))

#_(let [source articles
        n      6
        word-freqs (document-word-frequencies source)]
    (?- (stdout)
        (c/fixed-sample (<- [?word ?inverse-document-frequency]
                            (word-freqs _ ?word _)
                            (c/count ?total-freq)
                            (idf-ratio n ?total-freq :> ?inverse-document-frequency))
                        10)))

