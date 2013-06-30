(ns ldn-clj-tf-idf.live
  (:require [cascalog.api :refer :all]))

#_(require '[cascalog.playground :refer :all])
#_(bootstrap-emacs)

;; Cascalog speaks in tuples; the input to this query is a sequence of
;; three 1-tuples.
#_(let [source [["Hello"]
                ["London"]
                ["Clojurians"]]]
  (?- (stdout)
      (<- [?word]
          (source ?word))))
