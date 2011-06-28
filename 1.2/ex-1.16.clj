(defn expt-iter [b n a]
  (cond
    (= n 0) a
    (even? n) (recur (* b b) (/ n 2) a)
    :else (recur b (- n 1) (* a b))))

(defn expt [b n] 
  (expt-iter b n 1))
