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

;; As well as providing several built-in aggregators, it's possible to
;; create your own using defbufferop, defaggregateop, defparallelagg
;; and defparallelbuf. Let's calculate the top-n values per group of a
;; set of tuples whose last entry has a numeric value.
(defbufferop [top-n [n]]
  [tuples]
  (take n (sort-by last > tuples)))

#_(let [source [["a" 1]
                ["a" 7]
                ["a" 2]
                ["a" 8]
                ["b" 9]
                ["b" 9]
                ["b" 7]
                ["b" 3]
                ["c" 2]
                ["c" 3]
                ["c" 1]
                ["c" 0]]]
    (?- (stdout)
        (<- [?x ?sorted-y]
            (source ?x ?y)
            (top-n 2 ?y :> ?sorted-y))))



