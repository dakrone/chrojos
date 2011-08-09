(ns chrojos.train
  (:use [opennlp.nlp]
        [opennlp.tools.train]
        [clojure.java.io :only [file reader resource writer]]))

(defn train-t
  []
  (train-tokenizer (resource "tokenizer.train")))

(defn train-p
  []
  (train-pos-tagger (resource "pos-tag.train")))

(defn write-out
  [model filename]
  (write-model model (writer filename)))

(defn test-t
  "only used to test"
  []
  (let [t (make-tokenizer (train-t))]
    (doseq [line (line-seq (reader (resource "tokenizer.train")))]
      (prn (t (.replaceAll line "<SPLIT>" ""))))))

(comment

  (def tokenize (make-tokenizer (train-t)))
  (def pos-tag (make-pos-tagger (train-p)))

)
