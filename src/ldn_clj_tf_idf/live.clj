(ns ldn-clj-tf-idf.live
  (:require [cascalog.api :refer :all]
            [cascalog.ops :as c]))

#_(require '[cascalog.playground :refer :all])
#_(bootstrap-emacs)

;; The documents we'll be working with will be formatted as a
;; collection of 2-tuples; the first entry being the document label,
;; and the second being a word from the document. Each word in a
;; document corresponds to a 2-tuple.
#_(let [source [["doc1" "screwed"]
                ["doc1" "down"]
                ["doc1" "hairdo"]
                ["doc2" "thinks"]
                ["doc2" "he'll"]
                ["doc2" "blow"]
                ["doc2" "our"]
                ["doc3" "is"]
                ["doc3" "a"]
                ["doc3" "saddening"]
                ["doc3" "bore"]
                ["doc3" "and"]
                ["doc4" "gnome"]
                ["doc4" "and"]
                ["doc4" "you"]]]
    (?- (stdout)
        (<- [?label ?word ?freq]
            (source ?label ?word)
            (c/count :> ?freq))))
