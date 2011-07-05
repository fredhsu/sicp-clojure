(defn make-leaf [sym weight]
  (list 'leaf sym weight))

(defn leaf? [object]
  (= (first object) 'leaf))

(defn symbol-leaf [x]
  (fnext x))

(defn weight-leaf [x]
  (first (nnext x)))

(defn symbols [tree]
  (if (leaf? tree)
    (list (symbol-leaf tree))
    (first (nnext tree))))

(defn weight [tree]
  (if (leaf? tree)
    (weight-leaf tree)
    (fnext (nnext tree))))

(defn make-code-tree [left right]
  (list left
        right
        (concat (symbols left) (symbols right))
        (+ (weight left) (weight right))))

(defn left-branch [tree] (first tree))
(defn right-branch [tree] (fnext tree))


(defn choose-branch [bit branch]
  (cond (= bit 0) (left-branch branch)
        (= bit 1) (right-branch branch)
        :else (left-branch branch)))

(defn decode [bits tree]
  (defn decode-1 [bits current-branch]
    (if (empty? bits)
      '()
      (let [next-branch
            (choose-branch (first bits) current-branch)]
        (if (leaf? next-branch)
          (cons (symbol-leaf next-branch)
                (decode-1 (rest bits) tree))
          (decode-1 (rest bits) next-branch)))))
  (decode-1 bits tree))


(def sample-tree 
  (make-code-tree (make-leaf 'A 4)
                  (make-code-tree 
                    (make-leaf 'B 2) 
                    (make-code-tree (make-leaf 'D 1)
                                    ; symbol (cadr pair)) ; frequency
                                    (make-leaf 'C 1)))))
(def sample-message '(0 1 1 0 0 1 0 1 0 1 1 1 0))
