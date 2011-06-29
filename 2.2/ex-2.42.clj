(load-file "/Users/fhsu/dev/clojure/sicp-clojure/2.2/flatmap.clj")


(def empty-board '(()))
(defn adjoin-position [new-row col rest-of-queens]
  (cons new-row rest-of-queens))

(defn safe? [k positions] 
   ; current queen is at start of positions list 
   (def queenPos (first positions)) 
   ; top and bot are used to check for diagonal entries 
   (defn safe-iter [top bot remain] 
     (cond (empty? remain) true
           ; Checks for same row and diagonals 
           (or (= (first remain) queenPos) 
                (= (first remain) top) 
                (= (first remain) bot)) false
           :else 
            (safe-iter (- top 1) (+ bot 1) (rest remain)))) 
   (safe-iter (- queenPos 1) (+ queenPos 1) (rest positions))) 


(defn queens [board-size]
  (defn queen-cols [k]
    (if (= k 0)
      (list empty-board)
      (filter
        (fn [positions] (safe? k positions))
        (flatmap
          (fn [rest-of-queens]
            (map (fn [new-row]
                   (adjoin-position new-row k rest-of-queens))
                 (range 1 board-size)))
          (queen-cols (- k 1))))))
  (queen-cols board-size))

