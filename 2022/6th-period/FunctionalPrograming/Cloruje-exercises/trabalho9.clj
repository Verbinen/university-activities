
;Eduardo Monteiro Verbinen

; 1. Utilizando  a  linguagem  Clojure,  crie  uma  função  chamada  ultimo  que  receba  uma  lista  e devolva o último elemento desta lista sem usar as funções já prontas e disponíveis para esta mesma finalidade na linguagem Clojure.

(defn ultimo [lis]
  (if (= (count lis) 1)
    (first lis)
    (ultimo (rest lis))))

(println "ultimo: entrada: '(10 12 7 26 27 68 74); resultado:" (ultimo '(10 12 7 26 27 68 74)))

; 2. Utilizando a linguagem Clojure, crie uma função chamada penultimo que receba uma lista e  devolva  o  penúltimo  elemento  desta  lista  usar as  funções  já  prontas  e disponíveis para esta mesma finalidade na linguagem Clojure.

(defn penultimo [lst]
  (if (= (count lst) 2)
    (first lst)
    (penultimo (rest lst))))

(println "penultimo: entrada: '(10 12 7 26 27 68 74); resultado:" (penultimo '(10 12 7 26 27 68 74)))

; 3. Utilizando a linguagem Clojure, crie uma função chamada elementoN que receba uma lista e um inteiro N e devolva o  elemento que  está na  posição N desta lista usar as funções já prontas e disponíveis para esta mesma finalidade na linguagem Clojure

(defn elementoN [lst x]
  (if (= x 0)
    (first lst)
    (elementoN (rest lst) (- x 1))))

(println "elementoN: entrada: '(10 12 7 26 27 68 74) 2; resultado:" (elementoN '(10 12 7 26 27 68 74) 2))

; 4. Utilizando  a  linguagem Clojure,  crie  uma função  chamada  inverso  que  receba uma  lista  e devolva esta lista com as posições dos elementos invertidas. Por exemplo recebe [1,2,3] e devolve [3,2,1]. Sem usar as funções já prontas e disponíveis para esta mesma finalidade na linguagem Clojure.

(defn inverso [lst]
  (if (= (count lst) 0)
    []
    (conj (inverso (rest lst)) (first lst))))

(println "inverso: entrada: '(1 2 3 4 56); resultado:" (inverso '(1 2 3 4 56)))

; 5. Utilizando a  linguagem Clojure, crie uma função chamada  mdc que receba  dois inteiros e devolve o mínimo divisor comum entre eles.  Sem usar as funções já prontas e disponíveis para esta mesma finalidade na linguagem Clojure.

(defn aux [k j]
  (if (>= k j)
    (aux (- k j) j)
    k))

(defn mdc [k j]
  (if (= j 0)
    k
    (mdc j (aux k j))))

(println "mdc: entrada: 32 64; resultado:" (mdc 32 126))
