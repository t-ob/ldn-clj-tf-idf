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
;; join on specific variables.
#_(let [source-1 [["a" 1]
                  ["a" 2]
                  ["a" 3]
                  ["b" 2]
                  ["b" 4]
                  ["c" 3]]
        source-2 [["a" :foo]
                  ["b" :bar]
                  ["c" :baz]]]
    (?- (stdout)
        (<- [?x ?y ?z]
            (source-1 ?x ?y)
            (source-2 ?x ?z))))
