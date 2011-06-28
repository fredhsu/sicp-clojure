(defn halve [a] (/ a 2))
(defn dbl [a] (+ a a))
(defn mult-iter [a b acc]
  (cond
    (= a 0) acc
    (even? a) (recur (halve a) (dbl b) acc)
    :else (mult-iter (- a 1)  b (+ b acc))))
(defn mult [a b]
  (mult-iter a b 0))
