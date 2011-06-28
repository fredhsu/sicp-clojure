(defn pascal [row col]
  ;Gives the pascal triangle value for a given row and column
  (if (or (= col 1) (= row col)) 1
    (+ (pascal (- row 1) (- col 1)) (pascal (- row 1) col))))

