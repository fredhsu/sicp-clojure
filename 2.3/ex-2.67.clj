(load-file "/Users/fhsu/dev/clojure/sicp-clojure/2.3/huffman.clj")
(def sample-tree 
  (make-code-tree (make-leaf 'A 4)
                  (make-code-tree 
                    (make-leaf 'B 2) 
                    (make-code-tree (make-leaf 'D 1)
                                    ; symbol (cadr pair)) ; frequency
                                    (make-leaf 'C 1)))))
(def sample-message '(0 1 1 0 0 1 0 1 0 1 1 1 0))

