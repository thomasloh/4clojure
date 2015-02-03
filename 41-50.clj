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
  )
(= (reverse-interleave [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
(= (reverse-interleave (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
(= (reverse-interleave (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))


