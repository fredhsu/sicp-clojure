(defn f-recur [n]
 (cond (< n 3) n
       :else (+ (f-recur (- n 1)) (* 2 (f-recur (- n 2))) (* 3 (f-recur (- n 3))))))

(defn f-iter [n]
 (defn iter [n1 n2 n3 count]
  (if (= count 0) 
    n1
    (recur n2 n3 (+ n3 (* 2 n2) (* 3 n1)) (- count 1))))
 (iter 0 1 2 n))
