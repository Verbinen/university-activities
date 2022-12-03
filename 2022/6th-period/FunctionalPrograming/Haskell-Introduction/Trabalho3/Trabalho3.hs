--Eduardo Monteiro Verbinen
{- 1. Escreva  uma  função  para  o  cálculo  dos  números  da  sequência  de  Fibonacci,  utilizando Haskell. -}

fibonacciSequence :: Int -> Int
fibonacciSequence 0 = 0
fibonacciSequence 1 = 1
fibonacciSequence x = fibonacciSequence (x - 1) + fibonacciSequence (x - 2)

{- 2. Um dos primeiros algoritmos documentados é o algoritmo para o cálculo do Maior Divisor 
Comum  (MDC)  de  Euclides  publicado  por  volta do  ano 300  AC.  Podemos simplificar  este 
algoritmo  dizendo  que  dados  dois  inteiros  A  e  B,  o  MDC  entre  eles  será dado  pelo valor
absoluto de A se B=0 e pelo MDC entre B e o resto da divisão de A por B se B>0. Escreva uma  função para  o  cálculo  do  MDC  entre  dois  números  inteiros  positivos,  usando  o algoritmo de Euclides conforme apresentado aqui, utilizando Haskell.-}

mdc :: Int -> Int -> Int
mdc x 0 = abs x
mdc x y = mdc y (mod x y)

{- 3. Escreva uma função recursiva que dado um número inteiro n, devolva a soma dos dígitos 
deste  número.  Exemplo:  dado  1234  a  função  deverá  devolver  10.  Utilizando  Haskell  e 
recursividade.-}

somaConteudo :: Int -> Int
somaConteudo 0 = 0
somaConteudo x = somaConteudo (fst(divMod x 10)) + snd(divMod x 10)


{- 4. Escreva  uma  função  que  devolva  a  soma  de  todos  os  números  menores  que  10000  que 
sejam múltiplos de 3 ou 5. -}

somaMenor10000 :: Int -> Int -> Int
somaMenor10000 x 0 = x
somaMenor10000 x y
    | (snd(divMod y 3) == 0) || (snd(divMod y 5) == 0) = somaMenor10000 (x + y) (y - 1)
    | otherwise = somaMenor10000 x (y - 1)

{- 5. Escreva  uma  função que,  recebendo  uma  lista  de  inteiros,  apresente  a  diferença entre a soma dos quadrados e o quadrado da soma destes inteiros, usando recursividade. -}

somaElementosLista :: [Int] -> Int
somaElementosLista [] = 0
somaElementosLista (h: t) = h + somaElementosLista t

exponenciaElementosLista :: [Int] -> [Int]
exponenciaElementosLista x = [i^2 | i <- x]

diferencaSomaQuad :: [Int] -> Int
diferencaSomaQuad x = somaElementosLista (exponenciaElementosLista x) - (*) (somaElementosLista x) (somaElementosLista x)

{- 6. O Crivo de Eratóstenes não é o melhor algoritmo para encontrar números primos. Crie uma 
função que implemente o Crivo de Euler (Euler’s Sieve) para encontrar todos os números 
primos menores que um determinado inteiro dado. -}

crivoEuler :: Int -> [Int]
crivoEuler x = crivo x [2..x]

crivo :: Int -> [Int] -> [Int]
crivo x [] = []
crivo x y = if head y > x then y else [head y] ++ crivo x [z| z <- tail y, mod z (head y) /= 0]
  
  
{- 7. Nem  só  de  Fibonacci  vivem  os  exemplos  de  recursão.  Escreva  uma  função  que  devolva
todos os números de uma sequência de Lucas (2, 1, 3, 4, 7, 11, 18, 29, 47, 76, 123) menores 
que um inteiro dado. -}


lucasSequence :: Int -> Int -> Int -> [Int] -> [Int]
lucasSequence x y z k
  | z > y + x = lucasSequence y (x + y) z (k ++ [y + x])
  | otherwise = k

lucas :: Int -> [Int]
lucas 1 = [1]
lucas 2 = [2]
lucas z
    | z < 1 = []
    | otherwise = lucasSequence 2 1 z [2, 1]


{- 8. Escreva uma função, chamada aoContrario em Haskel para reverter uma lista. Dado [1,2,3] 
devolva [3,2,1]. -}

aoContrario :: [Int] -> [Int]
aoContrario [] = []
aoContrario (h : t) = aoContrario t ++ [h]

{- 9. Escreva uma função chamada somaRecursiva que recebe dois valores inteiros e devolve o 
produto destes valores sem usar o operador de multiplicação. -}

somaRecursiva :: Int -> Int -> Int
somaRecursiva x 0 = 0
somaRecursiva x y
    | y > 0 = x + somaRecursiva x (y - 1)
    | otherwise = negate (somaRecursiva x (negate y))

{- 10. Escreva uma função chamada comprimento que receba uma lista de  inteiros e devolva o 
comprimento desta lista. Observe que você não pode usar nenhuma função que já calcule 
o comprimento de uma lista.-}

comprimento :: [Int] -> Int
comprimento [] = 0
comprimento (h : t) = (+) 1 (comprimento t)


main = do
    putStrLn("Func. 1: entrada:7; resultado: " ++ show (fibonacciSequence 7))
    putStrLn("Func. 2: entrada: 96 160; resultado: " ++ show (mdc 96 160))
    putStrLn("Func. 3: entrada: 160; resultado: " ++ show (somaConteudo 160))
    putStrLn("Func. 4: entrada: 0 10000; resultado: " ++ show (somaMenor10000 0 10000))
    putStrLn("Func. 5: Entrada: [8, 7, 6]; Resultado: " ++ show (diferencaSomaQuad [8, 7, 6]))
    putStrLn ("Func. 6: entrada: 32; resultado: " ++ show(crivoEuler 32))
    putStrLn ("Func. 7: entrada: 50; resultado: " ++ show(lucas 50))
    putStrLn("Func. 8: entrada: [5,6,7,8]; resultado: " ++ show (aoContrario [5,6,7,8]))
    putStrLn("Func. 9: entrada: 2 8; resultado: " ++ show (somaRecursiva 2 8))
    putStrLn("Func. 10: Entrada: [9, 8, 4, 2, 6, 4, 2, 4]; Resultado: " ++ show (comprimento [9, 8, 4, 2, 6, 4, 2, 4]))
