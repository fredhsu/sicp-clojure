(defn sum [term a next-term b]
  (if (> a b)
    0
    (+ (term a)
       (sum term (next-term a) next-term b))))

(defn cube [x] (* x x x))

(defn simpson [f a b n]
  (let [h (/ (- b a) n)
        simpson-term (fn [k]
                       (let [y (f (+ a (* k h)))]
                         (cond 
                           (= k 0) y
                           (= k n) y
                           (even? k) (* 2 y)
                           :else (* 4 y))))]
    (* (/ h 3)
       (sum simpson-term 0 inc n))))
(simpson cube 0 1 100)
(simpson cube 0 1 1000)
