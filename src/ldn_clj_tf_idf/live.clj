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

;; It's possible to read-in multiple sources to a Cascalog query, and
;; join on specific variables. Let's calculate, for each document, the
;; ratio of each occurring word to the document's maximum word
;; frequency.
#_(let [source         articles
        word-freqs     (document-word-frequencies source)
        max-word-freqs (document-max-word-frequencies word-freqs)]
    (?- (stdout)
        (c/fixed-sample (<- [?label ?word ?term-frequency]
                            (word-freqs ?label ?word ?freq)
                            (max-word-freqs ?label ?max-freq)
                            (div ?freq ?max-freq :> ?term-frequency))
                        20)))
