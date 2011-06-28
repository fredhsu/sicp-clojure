(load-file "/Users/fhsu/dev/clojure/sicp/1.2/smallest-divisor.clj")

(defn report-prime [elapsed-time]
  (print " *** ")
  (print elapsed-time))
(defn start-prime-test [n]
  (if (prime? n) (time (prime? n))))
(defn timed-prime-test [n]
  (newline)
  (print n)
  (start-prime-test n))
(defn search-for-primes [start end] 
  (doseq [n (range start end 2)]
    (timed-prime-test n)))
(search-for-primes 1001 1020)
(search-for-primes 10001 10050)
(search-for-primes 100001 100100)
(search-for-primes 1000001 1000100)

