(defn accumulate [op initial asequence]
  (if (empty? asequence)
    initial
    (op (first asequence)
        (accumulate op initial (rest asequence)))))

(defn flatmap [proc aseq] 
  (accumulate concat nil (map proc aseq)))

(accumulate concat 
            nil
            (map (fn [i] 
                   (map (fn [j] (list i j))
                        (range 1 i)))
                 (range 1 9)))

(defn permutations [s]
  (if (empty? s)
    '(())
    (flatmap (fn [x]
               (map (fn [p] (cons x p))
                    (permutations (remove #{x} s))))
             s)))
