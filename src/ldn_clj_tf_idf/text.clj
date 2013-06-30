(ns ldn-clj-tf-idf.text
  (:require [cascalog.api :refer :all]
            [clojure.string :as str]))

(def stopwords
  #{"a" "is" "of" "i" "the" "this" "you" "off" "ok" "should" "dont" "your" "youre" "on" "to" "but" "his" "it" "all" "him" "her" "more" "let" "us" "im" "me" "cant" "he" "she" "in" "my" "as" "not" "be" "at" "if" "so" "was" "and" "had" "that" "mr" "dr" "mrs" "ms" "did"})

(defn remove-stopwords [line]
  (str/replace line
               (re-pattern (format "(%s)"
                                   (str/join "|"
                                             (map (partial format "\\b+%s\\b+")
                                                  stopwords))))
               ""))

(defn parse-line [line]
  (-> line
      (str/lower-case)
      (str/replace #"[^\p{L}\s]" "")
      (remove-stopwords)
      (str/trim)
      (not-empty)))

(defmapcatop split-line [line]
  (str/split line #"\s+"))
