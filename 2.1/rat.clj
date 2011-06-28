(load-file "/Users/fhsu/dev/clojure/sicp/1.2/gcd.clj")

(defn make-rat [n d] (list n d))
(defn numer [x] (first x))
(defn denom [x] (second x))
(defn print-rat [x]
  (newline)
  (print (numer x))
  (print "/")
  (print (denom x)))
(defn add-rat [x y]
  (make-rat (+ (* (numer x) (denom y))
               (* (numer y) (denom x)))
            (* (denom x) (denom y))))
(defn sub-rat [x y]
  (make-rat (- (* (numer x) (denom y))
               (* (numer y) (denom x)))
            (* (denom x) (denom y))))

(defn mul-rat [x y]
  (make-rat (* (numer x) (numer y))
            (* (denom y) (denom x))))
(defn div-rat [x y]
  (make-rat (* (numer x) (denom y))
            (* (numer y) (denom x))))
(numer (make-rat 1 2))
(denom (make-rat 1 2))
(def one-half (make-rat 1 2))
(def one-third (make-rat 1 3))

(print-rat one-half)
(print-rat (add-rat one-half one-third))
(print-rat (mul-rat one-half one-third))
(print-rat (add-rat one-third one-third))

(defn make-rat [n d] 
  (let [g (gcd n d)]
    (list (/ n g) (/ d g))))
(print-rat (add-rat one-third one-third))

