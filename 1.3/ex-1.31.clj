(defn product [term a next-term b]
  (if (> a b)
    1
    (* (term a)
       (product term (next-term a) next-term b))))
(defn factorial [n]
  (product identity 1 inc n))

(factorial 5)

(defn product-iter [term a next-term b]
  (defn iter [a result]
    (if (= a b)
      result
      (recur (next-term a) (* a result))))
  (iter a 1))

(product identity 1 inc 5)
