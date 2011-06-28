(defn make-point [x y]
  (list x y))
(defn x-point [point] (first point))
(defn y-point [point] (second point))

(defn make-segment [start end] (list start end))
(defn start-segment [segment] (first segment))
(defn end-segment [segment] (second segment))

(defn midpoint-segment [segment]
  (make-point (/ (+ (x-point (start-segment segment)) (x-point (end-segment segment))) 2)
              (/ (+ (y-point (start-segment segment)) (y-point (end-segment segment))) 2)))
(defn print-point [p]
  (newline)
  (print "(")
  (print (x-point p))
  (print ",")
  (print (y-point p))
  (print ")"))

(print-point (midpoint-segment (make-segment (make-point 0 0) (make-point 4 4))))
(print-point (midpoint-segment (make-segment (make-point 8 8) (make-point 4 4))))
