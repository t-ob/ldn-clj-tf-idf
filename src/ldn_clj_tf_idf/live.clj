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

;; The output of a Cascalog query is a perfectly valid input to
;; another. articles is a query defined in samples.clj, which takes a
;; set of news articles and transforms it into our desired tuple
;; representation.

;; The fixed-sample query, defined in cascalog.ops returns a random
;; sample of a source input, in this case another query. It's very
;; handy when experimenting.
#_(?- (stdout)
      (c/fixed-sample articles
                      10))

;; Let's calculate the frequency of the most occurring word in each
;; document, using the cascalog.ops/max aggregator.
#_(let [source (document-word-frequencies articles)]
    (?- (stdout)
        (c/fixed-sample (<- [?label ?max-freq]
                            (source ?label _ ?freq)
                            (c/max ?freq :> ?max-freq))
                        10)))


