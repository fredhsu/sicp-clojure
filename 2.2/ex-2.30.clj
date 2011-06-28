(defn square [x] (* x x))

(defn square-tree-recur [tree]
  (cond (nil? tree) nil
        (not (seq? tree)) (square tree)
        (empty? tree) '()
        :else (cons (square-tree (first tree))
                    (square-tree (rest tree)))))

(square-tree-recur (list 1
                         (list 2 (list 3 4) 5)
                         (list 6 7)))

(defn square-tree-map [tree]
  (map (fn [sub-tree] 
         (if (and (seq? sub-tree) (not (empty? sub-tree)))
           (square-tree-map sub-tree)
           (square sub-tree))) 
       tree))

(square-tree-map (list 1
                         (list 2 (list 3 4) 5)
                         (list 6 7)))
