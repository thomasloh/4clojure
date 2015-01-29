; 21. Nth element
(= (#(first (drop %2 %1)) '(4 5 6 7) 2) 6)
(= ((fn [x, i] (last (take (+ i 1) x))) [:a :b :c] 0) :a)
(= (#((vec %1) %2) [1 2 3 4] 1) 2)
(= (#(first (nthnext %1 %2)) '([1 2] [3 4] [5 6]) 2) [5 6])

; 22. Count a sequence
(= (#(reduce (fn [n, x] (+ n 1)) 0 %) '(1 2 3 3 1)) 5)
(= ((comp (partial reduce + 0) (partial map (fn [x] 1))) "Hello World") 11)
(= (#(reduce + 0 (map (fn [x] 1) %)) [[1 2] [3 4] [5 6]]) 3)
(= (#(reduce + (map (constantly 1) %)) '(13)) 1)
(= (#(apply + (map (fn [_] 1) %)) '(:a :b :c)) 3)

; 23. Reverse a sequence
(= (reduce #(conj %1 %2) '() [1 2 3 4 5]) [5 4 3 2 1])
(= (into ()  (sorted-set 5 7 2 7)) '(7 5 2))
(= (apply (partial conj '()) [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]])

; 24. Sum it all up
(= (#(reduce + 0 %) [1 2 3]) 6)
(= (#(apply + %) (list 0 -2 5 5)) 8)
(= (reduce + #{4 2 1}) 7)
(= (apply + '(0 0 -1)) -1)
(= ((partial apply +) '(1 10 3)) 14)

; 25. Find the odd numbers
(= (filter odd? #{1 2 3 4 5}) '(1 3 5))
(= ((partial filter odd?) [4 2 1 6]) '(1))
(= (filter #(= (mod % 2) 1) [2 2 4 6]) '())
(= (filter (complement even?) [1 1 1 3]) '(1 1 1 3))

; 26. Fibonacci sequence
(= ((
     fn fibonacci-seq
        [n]
        (case n
          1 '(1)
          2 '(1 1)
          (let [prev (fibonacci-seq (- n 1)) prevrev (reverse prev)]
            (concat prev (list (+ (first prevrev) (second prevrev))))))) 3) '(1 1 2))
(= (#(take % (map first (iterate (fn [[x y]] [y (+ x y)]) [1 1]))) 6) '(1 1 2 3 5 8))
(= ((fn
     [n]
     (map first (reductions (fn [[a b] _] [b (+ a b)]) [1 1] (range 1 n)))) 8) '(1 1 2 3 5 8 13 21))


; 27. Palindrome detector
(defn palindrome?
  [s]
  (= (seq s) (seq (reverse s))))
(false? (palindrome? '(1 2 3 4 5)))
(true? (palindrome? "racecar"))
(true? (palindrome? [:foo :bar :foo]))
(true? (palindrome? '(1 1 3 3 1 1)))
(false? (palindrome? '(:a :b :c)))


; 28. Flatten a sequence
(defn my-flatten
  [x]
  (reduce #(concat %1 (if (sequential? %2) (my-flatten %2) (list %2))) '() x))
(= (my-flatten '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
(= (my-flatten ["a" ["b"] "c"]) '("a" "b" "c"))
(= (my-flatten '((((:a))))), '(:a))


; 29. Get the Caps
(defn get-caps
  [s]
  (clojure.string/join
   (filter #(= (str (clojure.string/upper-case %)) (str %)) (re-seq #"[a-zA-Z]" s))))
(defn get-caps-short
  [s]
  (apply str (re-seq #"[A-Z]" s)))
(= (get-caps-short "HeLlo, WoRlD!") "HLWRD")
(empty? (get-caps "nothing"))
(= (get-caps "$#A(*&987Zf") "AZ")


; 30. Compress a Sequence
(defn compress-seq
  [s]
  (map (comp first distinct) (partition-by identity s)))
(= (apply str (compress-seq "Leeeeeerrroyyy")) "Leroy")
(= (compress-seq [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
(= (compress-seq [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))







