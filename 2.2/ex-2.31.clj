(defn square [x] (* x x))

(defn tree-map [func tree]
  (map (fn [sub-tree] 
         (if (and (seq? sub-tree) (not (empty? sub-tree)))
           (square-tree-map sub-tree)
           (func sub-tree))) 
       tree))
(defn square-tree [tree] (tree-map square tree))
(square-tree (list 1
                         (list 2 (list 3 4) 5)
                         (list 6 7)))
