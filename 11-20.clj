; 11. Maps: conj
(= {:a 1 :b 2 :c 3} (conj {:a 1} {:b 2} [:c 3]))

; 12. Intro to Seqeuences
(= 3  (first '(3 2 1)))
(= 3 (second [2 3 4]))
(= 3 (last (list 1 2 3)))

; 13. Sequences: rest
(= [20 30 40] (rest [10 20 30 40]))

; 14. Intro to functions
(= 8 ((fn add-five [x] (+ x 5)) 3))
(= 8 ((fn [x] (+ x 5)) 3))
(= 8 (#(+ % 5) 3))
(= 8 ((partial + 5) 3))

; 15. Double down
(= (#(* % 2) 2) 4)
(= ((fn double-down [x] (* x 2)) 3) 6)
(= ((fn [x] (* x 2)) 11) 22)
(= (#(* 2 %1) 7) 14)

; 16. Hello World
(= (#(str "Hello, " % "!") "Dave") "Hello, Dave!")
(= ((fn [s] (str "Hello, " s "!")) "Jenn") "Hello, Jenn!")
(= ((fn greet [x] (str "Hello, " x "!")) "Rhea") "Hello, Rhea!")

; 17. Sequences: map
(= '(6 7 8) (map #(+ % 5) '( 1 2 3)))

; 18. Sequences: filter
(= (list 6 7) (filter #(> % 5) '(3 4 5 6 7)))

; 19. Last element
(= ((comp first reverse) [1 2 3 4 5]) 5)
(= (#(first (reverse %)) '(5 4 3)) 3)
(= ((comp peek vec) ["b" "c" "d"]) "d")

; 20. Penultimate element
(= ((comp second reverse) [list 1 2 3 4 5]) 4)
(= ((comp first rest reverse) ["a" "b" "c"]) "b")
(= ((comp peek pop vec) [[1 2] [3 4]]) [1 2])



