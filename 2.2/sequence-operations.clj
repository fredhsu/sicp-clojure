(defn square [x] (* x x))
; filter already built-in
(filter odd? (list 1 2 3 4 5))
; accumulate built-in as reduce - not exactly the same, reduce = foldl, accumulate = foldr?
(reduce + 0 (list 1 2 3 4 5))
(reduce * 1 (list 1 2 3 4 5))

(defn enumerate-interval [low high]
  (if (> low high)
    nil
    (cons low (enumerate-interval (+ low 1) high))))
(enumerate-interval 2 7)
; could also use built-in range
(range 2 8)

(defn enumerate-tree [tree]
  (cond (nil? tree) nil
        (not (list? tree)) (list tree)
        (empty? tree) nil ; rest of '() is (), need to return nil if empty
        :else (concat (enumerate-tree (first tree))
                      (enumerate-tree (rest tree)))))
(enumerate-tree (list 1 (list 2 (list 3 4)) 5))

(def tree (list 1 (list 2 (list 3 4)) 5))

(defn sum-odd-squares [tree]
  (reduce +
          0
          (map square
               (filter odd?
                       (enumerate-tree tree)))))

(sum-odd-squares tree)

(defn even-fibs [n]
  (reduce cons
          nil
          (filter even?
                  (map fib
                       (enumerate-interval 0 n)))))


