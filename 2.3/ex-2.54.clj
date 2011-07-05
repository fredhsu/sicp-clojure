(defn equal? [a b]
  (cond (and (empty? a) (empty? b)) true
        (= (first a) (first b)) (equal? (rest a) (rest b)) 
        :else false))

(equal? '(this is a list) '(this is a list))

(equal? '(this is a list) '(this (is a) list))
