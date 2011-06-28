(defn sum [term a next-term b]
  (defn iter [a result]
    (if (= a b)
      result
      (iter (next-term a) (+ (term a) result))))
  (iter a 0))
(sum identity 1 inc 5)
