(defn halve [a] (/ a 2))
(defn dbl [a] (+ a a))
(defn mult [a b]
  (cond
    (= a 0) 0
    (even? a) (recur (halve a) (dbl b))
    :else (+ b (mult (- a 1)  b ))))
