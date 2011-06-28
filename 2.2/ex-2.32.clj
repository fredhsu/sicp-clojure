(defn subsets [s]
  (if (empty? s) '(()) 
    (let [rest-sub (subsets (rest s))]
      (concat rest-sub (map 
                       (fn [x] (cons (first s) x)) 
                       rest-sub)))))

(subsets '(1 2 3))
