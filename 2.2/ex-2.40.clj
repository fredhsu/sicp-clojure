(load-file "/Users/fhsu/dev/clojure/sicp-clojure/2.2/flatmap.clj")

(defn unique-pairs [n]
  (flatmap (fn [i]
             (map (fn [j] (list i j))
                  (range 1 i)))
           (range 1 (+ 1 n))))
