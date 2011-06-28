(defn accumulate [op initial asequence]
  (if (empty? asequence)
    initial
    (op (first asequence)
        (accumulate op initial (rest asequence)))))
(defn horner-eval [x coeff]
  (accumulate (fn [this-coeff higher-terms]
            (+ (* x higher-terms) this-coeff))
          0
          coeff))

(horner-eval 2 (list 1 3 0 5 0 1))
