(ns ldn-clj-tf-idf.live
  (:require [cascalog.api :refer :all]
            [cascalog.ops :as c]))

#_(require '[cascalog.playground :refer :all])
#_(bootstrap-emacs)

;; Cascalog speaks in tuples; the input to this query is a sequence of
;; six 1-tuples. Cascalog comes with some built-in aggregators, the
;; most simple being count, in the cascalog.ops namespace.
#_(let [source [["Hello"]
                ["London"]
                ["Clojurians"]
                ["and"]
                ["Clojurians"]
                ["worldwide"]]]
  (?- (stdout)
      (<- [?word ?count]
          (source ?word)
          (c/count :> ?count))))
