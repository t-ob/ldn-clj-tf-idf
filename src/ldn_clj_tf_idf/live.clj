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

(defbufferop [top-n [n]]
  [tuples]
  (take n (sort-by last > tuples)))

;; Let's now combine tf, idf and top-n to calculate the tf-idf scores
;; for each document.
#_(let [source     articles
        total-docs 6
        tf-in      (tf source)
        idf-in     (idf total-docs source)]
    (?- (stdout)
        (<- [?label ?sorted-word ?sorted-tf-idf]
            (tf-in ?label ?word ?term-frequency)
            (idf-in ?word ?inverse-document-frequency)
            (* ?term-frequency ?inverse-document-frequency :> ?tf-idf)
            (top-n 10 ?word ?tf-idf :> ?sorted-word ?sorted-tf-idf))))



