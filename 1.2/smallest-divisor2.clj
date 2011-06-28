(defn divides? [a b]
  (= (rem b a ) 0))

(defn square [x] (* x x))

(defn next-div [n]
  (if (= n 2) 3
    (+ n 2)))

(defn find-divisor [n test-divisor]
  (cond (> (square test-divisor) n) n
        (divides? test-divisor n) test-divisor
        :else (find-divisor n (next-div test-divisor ))))
(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? [n]
  (= n (smallest-divisor n)))


