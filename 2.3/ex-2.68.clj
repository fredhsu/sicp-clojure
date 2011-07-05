(load-file "/Users/fhsu/dev/clojure/sicp-clojure/2.3/huffman.clj")
(def sample-tree 
  (make-code-tree (make-leaf 'A 4)
                  (make-code-tree 
                    (make-leaf 'B 2) 
                    (make-code-tree (make-leaf 'D 1)
                                    ; symbol (cadr pair)) ; frequency
                                    (make-leaf 'C 1)))))
(def sample-message '(0 1 1 0 0 1 0 1 0 1 1 1 0))

(defn encode-symbol [sym tree]
  (cond (= sym (symbol-leaf (left-branch tree))) '(0)
        (= sym (symbol-leaf (right-branch tree))) '(1)
        :else 
        (cons 1 (encode-symbol sym (right-branch tree)))))

(defn encode [message tree]
  (if (empty? message)
    '()
    (concat (encode-symbol (first message) tree)
            (encode (rest message) tree))))

(encode '(A D A B B C A) sample-tree)
