(defn expt [b n]
  (if (= n 0)
    1
    (* b (expt b (- n 1)))))
;O(n) steps O(n) space

(defn expt-iter [b counter product]
  (if (= counter 0)
    product
    (recur b
           (- counter 1)
           (* b product))))
;O(n) steps O(1) space

(defn expt2 [b n]
  (expt-iter b n 1))

(defn square [x]
  (* x x))

(defn fast-expt [b n]
  (cond (= n 0) 1
        (even? n) (square (fast-expt b (/ n 2)))
        :else (* b (fast-expt b (- n 1)))))
;O(log n) steps O(log n) space

