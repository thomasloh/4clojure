; 41. Drop every Nth item
(defn drop-every-nth-item
  [s n]
  (keep-indexed #(if (not= (mod (inc %1) n) 0) %2) s))
(= (drop-every-nth-item [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
(= (drop-every-nth-item [:a :b :c :d :e :f] 2) [:a :c :e])
(= (drop-every-nth-item [1 2 3 4 5 6] 4) [1 2 3 5 6])

; 42. Factorial Fun
(defn factorial-fun
  [n]
  (reduce * 1 (range 1 (inc n))))
(= (factorial-fun 1) 1)
(= (factorial-fun 3) 6)
(= (factorial-fun 5) 120)
(= (factorial-fun 8) 40320)

; 43. Reverse Interleave
(defn reverse-interleave
  [s n]
  (partition (/ (count s) n) (apply interleave (partition n s))))
(= (reverse-interleave [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
(= (reverse-interleave (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
(= (reverse-interleave (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))

; 44. Rotate Sequence
(defn rotate-seq
  [n s]
  (let [l (count s)
        x (if (pos? n) (- l (mod n l)) (mod (Math/abs n) l))
        y (if (pos? n) (mod n l) (mod (+ l n) l))]
        (concat (take-last x s) (take y s))))
(= (rotate-seq 2 [1 2 3 4 5]) '(3 4 5 1 2))
(= (rotate-seq -2 [1 2 3 4 5]) '(4 5 1 2 3))
(= (rotate-seq 6 [1 2 3 4 5]) '(2 3 4 5 1))
(= (rotate-seq 1 '(:a :b :c)) '(:b :c :a))
(= (rotate-seq -4 '(:a :b :c)) '(:c :a :b))


; 45. Intro to Iterate
(= '(1 4 7 10 13) (take 5 (iterate #(+ 3 %) 1)))


; 46. Flipping out
(defn flip-out
  [f]
  (fn [& args] (apply f (reverse args))))
(= 3 ((flip-out nth) 2 [1 2 3 4 5]))
(= true ((flip-out >) 7 8))
(= 4 ((flip-out quot) 2 8))
(= [1 2 3] ((flip-out take) [1 2 3 4 5] 3))


; 47. Contain Yourself
(contains? #{4 5 6} 4)
(contains? [1 1 1 1 1] 4)
(contains? {4 :a 2 :b} 4)
; (not (contains? '(1 2 4) 4))


; 48. Intro to some
(= 6 (some #{2 7 6} [5 6 7 8]))
(= 6 (some #(when (even? %) %) [5 6 7 8]))


; 49. Split a sequence
(defn split-a-seq
  [n s]
  (vec (list (take n s) (drop n s))))
(= (split-a-seq 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
(= (split-a-seq 1 [:a :b :c :d]) [[:a] [:b :c :d]])
(= (split-a-seq 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])


; 50. Split by Type
(defn split-by-type
  [s]
  (vals (group-by type s)))
(= (set (split-by-type [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})
(= (set (split-by-type [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})
(= (set (split-by-type [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})


