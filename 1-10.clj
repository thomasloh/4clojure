
; 1. Nothing but the truth
(= true true)

; 2. Simple Math
(= (- 10 (* 2 3)) 4)

; 3. Intro to strings
(= "HELLO WORLD" (.toUpperCase "hello world"))

; 4. Intro to lists
(= (list :a :b :c) '(:a :b :c))

; 5. Lists: conj
(= '(1 2 3 4) (conj '(2 3 4) 1))
(= (list 1 2 3 4) (conj '(2 3 4) 1))

; 6. Intro to vectors
(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

; 7. Vectors: conj
(= [1 2 3 4] (conj [1 2 3] 4))
(= (vector 1 2 3 4) (conj [1 2 3] 4))

; 8. Intro to sets
(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))
(= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d}))

; 9. Sets: conj
(= #{1 2 3 4} (conj #{1 4 3} 2))

; 10. Intro to maps
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 (:b {:a 10 :b 20 :c 30}))

; 11. Maps: conj
(= {:a 1 :b 2 :c 3} (conj {:a 1} {:b 2} [:c 3]))



