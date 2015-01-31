; 31. Pack a Sequence
(defn pack-a-seq
  [s]
  (partition-by identity s))
(= (pack-a-seq [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
(= (pack-a-seq [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
(= (pack-a-seq [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))

; 32. Duplicate a sequence
(defn dup-a-seq
  [s]
  (reduce #(concat %1 (repeat 2 %2)) '() s))
(= (#(interleave % %) [1 2 3]) '(1 1 2 2 3 3))
(= (dup-a-seq [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
(= (dup-a-seq [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
(= (dup-a-seq [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))

; 33. Replicate a sequence
(defn replicate-a-seq
  [s, n]
  (apply interleave (repeat n s)))
(= (replicate-a-seq [1 2 3] 2) '(1 1 2 2 3 3))
(= (replicate-a-seq [:a :b] 4) '(:a :a :a :a :b :b :b :b))
(= (replicate-a-seq [4 5 6] 1) '(4 5 6))
(= ((fn [s, n] (mapcat #(repeat n %) s)) [4 5 6] 1) '(4 5 6))
(= (replicate-a-seq [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
(= (replicate-a-seq [44 33] 2) [44 44 33 33])

; 34. Implement range
(defn my-range
  [x y]
  (take (- y x) (iterate inc x)))
(= (my-range 1 4) '(1 2 3))
(= (my-range -2 2) '(-2 -1 0 1))
(= (my-range 5 8) '(5 6 7))

; 35. Local bindings

(= 7 (let [x 5] (+ 2 x)))
(= 7 (let [x 3, y 10] (- y x)))
(= 7 (let [x 21] (let [y 3] (/ x y))))

; 36. Let it be
(= 10 (let [x 7 y 3 z 1] (+ x y)))
(= 4 (let [x 7 y 3 z 1] (+ y z)))
(= 1 (let [x 7 y 3 z 1] z))


; 37. Regular Expressions
(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))


;38. Maximum value
(defn my-max
  [& args]
  (reduce #(if (> %1 %2) %1 %2) args))
(= (my-max 1 8 3 4) 8)
(= (my-max 30 20) 30)
(= (my-max 45 67 11) 67)


; 39. Interleave Two Seqs
(defn interleave-two-seqs
  [x y]
  (flatten (map #(list %1 %2) x y)))
(= (#(mapcat list %1 %2) [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
(= (interleave-two-seqs [1 2] [3 4 5 6]) '(1 3 2 4))
(= (interleave-two-seqs [1 2 3 4] [5]) [1 5])
(= (interleave-two-seqs [30 20] [25 15]) [30 25 20 15])


; 40. Interpose a Seq
(defn interpose-a-seq
  [x s]
  (concat (mapcat #(list % x) (butlast s)) (list (last s))))
(= (#(rest (interleave (repeat %1) %2)) 0 [1 2 3]) [1 0 2 0 3])
(= (apply str (interpose-a-seq ", " ["one" "two" "three"])) "one, two, three")
(= (interpose-a-seq :z [:a :b :c :d]) [:a :z :b :z :c :z :d])
