(defn square [n] (* n n))

(defn fib-iter [a b p q cnt]
  (cond (= cnt 0) b
  (even? cnt) (recur a
                     b
                     (+ (square p) (square q))
                     (+ (* 2 p q) (square q))
                     (/ cnt 2))
  :else (recur (+ (* b q) (* a q) (* a p))
               (+ (* b p) (* a q))
               p
               q
               (- cnt 1))))

(defn fib [n]
  (fib-iter 1 0 0 1 n))

