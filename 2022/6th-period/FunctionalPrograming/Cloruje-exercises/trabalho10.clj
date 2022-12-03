
;Eduardo Monteiro Verbinen

; 1. Na  aula  disponível  em:  https://replit.com/@frankalcantara/ClojureAula2?v=1  foram destacadas diversas funções (expressões), como funções de primeira ordem, disponíveis em Clojure.  Sua  primeira  tarefa  será  descrever  cada  uma  destas  funções  e  apresentar  dois exemplos  de  uso  de  cada  uma  delas.  Lembre-se  os  exemplos  precisam  ser  utilizados  de forma que o resutado da função possa ser visto no terminal.

; Função map
; Map é utilizado para aplicar uma função em cada elemento presente em uma lista ou coleção
; Exemplos:
(println "map: entrada: (fn [x] (- k 1)) [1 2 3 4 5] resultado: " (map (fn [k] (- k 1)) [9 5 2 4]))
(println "map: entrada: (fn [x] (+ x x)) [9 5 2 4] resultado: " (map (fn [k] (+ k k)) [9 5 2 4]))


; Função dissoc
; O dissoc é utilizado para remover uma chave de um map/dicionario.
; Exemplos:
(println "dissoc: entrada: {:a 1 :b 2} :a resultado: " (dissoc {:k 5 :j 7} :k))
(println "dissoc: entrada: {:f 3 :v 5} :v resultado: " (dissoc {:j 7 :k 5} :j))

; Função assoc 
; utilizado para associar um valor e uma chave ao map;dicionario.
; Exemplos:
(println "assoc: entrada: {:k 5 :j 7} :i 3 resultado: " (assoc {:k 5 :j 7} :i 3))
(println "assoc: entrada: {:k 5 :j 7} :i 9 resultado: " (assoc {:k 5 :j 7} :i 9))

; Função odd?
; Utilizado para retornar true se o número for impar
; Exemplos
(println "odd?: entrada: 7 resultado: " (odd? 7))
(println "odd?: entrada: 8 resultado: " (odd? 8))

; filter
; Utilziado para aplicar uma função a cada elemento de uma litsa/coleção, retornando uma nova ista a partir de uma condição desejada, ou seja, filtrando a lista
; Exemplos:
(println "filter: entrada: (fn [x] (< k 7)) [1 2 3 4 5] resultado: " (filter (fn [k] (< k 7)) [8 9 6 5 1]))
(println "filter: entrada: (fn [x] (> k 7)) [1 2 3 4 5] resultado: " (filter (fn [k] (> k 7)) [8 9 6 5 1]))

; range
; Utilizado para gerar range gera uma sequência de números inteiros.
; Exemplos:
(println "range: entrada: 7 resultado: " (range 7))
(println "range: entrada: 17 resultado: " (range 17))

; into
; utilizado para inserir elementos de uma lista, no inicio de outra lista.
; Exemplos:
(println "into: entrada: [13 45 46] [ 65 83 12 87 34 36] resultado: " (into [13 45 46] [1 2 3 4 5]))
(println "into: entrada: [1 2 3] [4 5] resultado: " (into [1 2 3] [4 5]))

; conj
; conj adiciona um elemento a uma coleção.
; Exemplos:
(println "conj: entrada: [7 7 7] 6 resultado: " (conj [7 7 7] 6))
(println "conj: entrada: [6 6 6] 7 resultado: " (conj [6 6 6] 7))

; nth
; Utilizado para retornar o elemento de uma coleção na posição especificada.
; Exemplos:
(println "nth: entrada: [7 8 9] 1 resultado: " (nth [7 8 9] 1))
(println "nth: entrada: [9 8 7] 0 resultado: " (nth [1 5 7] 0))

; inc
; Utilizado para incrementar um numero.
; Exemplos:
(println "inc: entrada: 19 resultado: " (inc 19))
(println "inc: entrada: 396 resultado: " (inc 396))


; empty?
; Utilziado para retornar true se a coleção estiver vazia.
; Exemplos:
(println "empty?: entrada: [76] resultado: " (empty? [76]))
(println "empty?: entrada: [] resultado: " (empty? []))

; char
; Utilizado para retornar o caractere correspondente ao dado número.
; Exemplos:
(println "char: entrada: 76 resultado: " (char 76))
(println "char: entrada: 67 resultado: " (char 67))

; partition-by
; Utilizado apra dividir uma coleção em subcoleções, de acordo com uma determinada condição/dunção.
; Exemplos:
(println "partition-by: entrada: (fn [x] (< x 7)) [-1 -2 -3 -4 8 9 10 11] resultado: " (partition-by (fn [k] (< k 7)) [-1 -2 -3 -4 8 9 10 11]))
(println "partition-by: entrada: (fn [x] (<= k -3)) [ -1 -2 -3 -4 8 9 10 11] resultado: " (partition-by (fn [k] (<= k -3)) [-1 -2 -3 -4 8 9 10 11]))

; count
; Utilizado para retorna a quantidade de elementos de uma coleção.
; Exemplos:
(println "count: entrada: [7 7 7 7 7] resultado: " (count [7 7 7 7 7]))
(println "count: entrada: [] resultado: " (count []))

; sort
; Utilizado para ordenar.
; Exemplos:
(println "sort: entrada: [99 98 97 96 95] resultado: " (sort [99 98 97 96 95]))
(println "sort: entrada: [] resultado: " (sort []))

; 2. Utilizando a linguagem Clojure, crie uma função chamada ehPrimo que receba um inteiro e devolva True caso este inteiro seja verdadeiro e False caso contrário. 

(defn ehPrimo [k]
  (if (<= k 1)
    false
    (if (= k 2)
      true
      (if (even? k)
        false
        (loop [j 3]
          (if (< j (Math/sqrt k))
            (if (zero? (rem k j))
              false
              (recur (+ j 2)))
            true))))))

(println "ehPrimo: entrada: 7; resultado:" (ehPrimo 7))
(println "ehPrimo: entrada: 6; resultado:" (ehPrimo 6))

; 3. Utilizando  a  linguagem  Clojure,  crie  uma  função  chamada  fatoresPrimos  que  receba  um inteiro e devolva uma lista dos seus fatores primos. Decomposição em fatores primos é uma tarefa fundamental da aritmética

(defn fatoresPrimos [k]
  (loop [k k
         j 2
         ftr []]
    (if (<= k 1)
      ftr
      (if (zero? (rem k j))
        (recur (/ k j) j (conj ftr j))
        (recur k (+ j 1) ftr)))))

(println "fatoresPrimos: entrada: 20; resultado:" (fatoresPrimos 20))

; 4. Utilizando  a  linguagem  Clojure,  crie  uma  função  chamada  todosPrimos  que  receba  dois valores inteiros e devolve todos os números primos que existam entre estes dois valores.  

(defn todosPrimos [k j]
  (loop [k k
         j j
         prm []]
    (if (<= k j)
      (if (ehPrimo k)
        (recur (+ k 1) j (conj prm k))
        (recur (+ k 1) j prm))
      prm)))

(println "todosPrimos: entrada: 1 16; resultado:" (todosPrimos 1 16))
