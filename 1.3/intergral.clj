(load-file "/Users/fhsu/dev/clojure/sicp/1.3/sum.clj")

(defn cube [x] (* x x x))

(defn integral [f a b dx]
  (defn add-dx [x] (+ x dx))
  (* (sum f (+ a (/ dx 2.0)) add-dx b)
     dx))
(integral cube 0 1 0.01)

