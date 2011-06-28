(def x (conj (list 3 4) (list 1 2)))

(defn pair? [x]
  (> (count x) 1))
(defn count-leaves [x]
  (cond (nil? x) 0
        (not (list? x)) 1
        (empty? x) 0
        :else (+ (count-leaves (first x))
                 (count-leaves (rest x)))))
(count-leaves x)
(count-leaves (list x x))
