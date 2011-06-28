(load-file "/Users/fhsu/dev/clojure/sicp/2.1/ex-2.2.clj")
(use 'clojure.contrib.math)
(defn square [x] (* x x))
(defn make-rect-points [a b c d]
  (list (make-segment a b) (make-segment b c)))
(defn make-rect-segs [s1 s2]
  (list s1 s2))
(defn segment-length [segment]
  (sqrt (+ (square (- (x-point (start-segment segment)) (x-point (end-segment segment)))) 
           (square (- (y-point (start-segment segment)) (y-point (end-segment segment)))))))
(defn rect-perimeter [rect] 
  (* 2 (+ (segment-length (first rect)) (segment-length (second rect)))))
(defn rect-area [rect]
  (* (segment-length (first rect)) (segment-length (second rect))))
