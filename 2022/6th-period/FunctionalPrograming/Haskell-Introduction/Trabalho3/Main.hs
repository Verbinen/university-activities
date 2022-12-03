--Eduardo Monteiro Verbinen
module Main where


{- 1. Escreva uma função chamada soma1 que recebe um inteiro como argumento e retorna um 
inteiro uma unidade maior que a entrada. -}

soma1 :: Int -> Int
soma1 = (+ 1)

{- 2. Escreva  uma  função  chamada  sempre  que,  não  importando  o  valor  de  entrada,  devolva sempre zero. Observe que neste caso a entrada pode ser de qualquer tipo. -}

sempre :: x -> Int
sempre x = 0

{- 3. Escreva  uma  função  chamada  treco  que  receba  três  valores  em  ponto  flutuantes  com precisão dupla e retorne o resultado da soma dos dois primeiros multiplicado pelo terceiro. -}

treco :: Double -> Double -> Double -> Double
treco x y z = (+) x y * z

{- 4. Escreva uma função chamada resto que devolva o resto de uma divisão entre dois números 
inteiros. -}

resto :: Int -> Int -> Int
resto = mod

{-5. Escreva uma função chamada precoMaior que devolva o maior valor entre quatro valores 
monetários.-}

precoMaior ::  Double -> Double -> Double -> Double -> Double
precoMaior x y z k =  maior (maior x y) (maior z k)

maior :: Double -> Double -> Double
maior x y = if x > y then x else y

{- 6. Escreva uma função chamada impar que devolva True, sempre que o resultado do produto de dois números inteiros for ímpar. -}

impar :: Int -> Int -> Bool
impar x y
    | mod (mult x y) 2 == 1 = True
    | otherwise = False

mult :: Int -> Int -> Int
mult x y = x * y

{- 7. Em Haskell existe o tipo par cuja assinatura tem a seguinte forma: 𝑝𝑎𝑟∷(𝐼𝑛𝑡,𝐼𝑛𝑡).
Escreva uma função em Haskell que devolva a soma dos componentes de um par de inteiros.-}

par :: (Int,Int) -> Int
par (x, y) = x + y

{- 8. Escreva uma função em Haskell que receba números reais (double) e devolva o resultado 
da equação 𝑥2 +𝑦/2 +𝑧.-}

segundoGrau :: Float -> Float -> Float -> Float
segundoGrau x y z = (*) x x + (/) y 2 + z

{- 9. Escreva uma função em Haskell chamada diagnostico que receba o peso do aluno e imprima 
um  diagnóstico  de  obesidade,  segundo  a  tabela  que  pode  ser  encontrada  no  link: 
Sobrepeso,  obesidade  e  obesidade  mórbida:  entenda  a  diferença  entre  os  três termos 
(cuidadospelavida.com.br).  Observe  que  este  diagnóstico  é  meramente  estatístico  e não tem
nenhum valor real, está sendo usado nesta questão apenas para a definição das faixas. Todo e
qualquer diagnóstico deve ser feito por um profissional médico. -}

diagnostico :: Float -> Float -> String
diagnostico weight height
    | (/) weight (height**2) < 17 = "Muito abaixo do peso"
    | (/) weight (height**2) <= 18.49 = "Abaixo do peso"
    | (/) weight (height**2) <= 24.99 = "Peso normal"
    | (/) weight (height**2) <= 29.99 = "Sobrepeso"
    | (/) weight (height**2) <= 34.99 = "Obesidade Ieve"
    | (/) weight (height**2) <= 39.99 = "Obesidade severa"
    | otherwise = "Obesidade morbida"

{- 10. Escreva uma função em Haskell chamada bissexto que receba um ano e devolva True se o ano for
bisexto sabendo que anos bissextos obedecem a seguinte regra: 
    Todos os anos que sejam divididos por 4
    Exceto os anos que são múltiplos de 100
    Exceto os anos que são múltiplos de 400
    1997 não é bissexto, 1900 não é bissexto e 2000 é bissexto -}

bissexto :: Int -> Bool
bissexto x
    | mod x 4 == 0 && (mod x 400 == 0 || mod x 100 /= 0) = True
    | otherwise = False
  

main = do
    putStr "Func. 1: entrada: 3; resultado: "
    print(soma1 3)
    
    putStr "Func. 2: entrada: Batata Frita; resultado: "
    print(sempre "Batata Frita")
    
    putStr "Func. 3: entrada: 2.5, 2.5, 2; resultado: "
    print(treco 2.5 2.5 2)
    
    putStr "Func. 4: entrada: 11, 2; resultado: "
    print(resto 11 2)
    
    putStr "Func. 5: entrada: 1 6.1 6.2 4; resultado: "
    print(precoMaior 1 6.1 6.2 4)
    
    putStr "Func. 6: entrada: 2 1; resultado: "
    print(impar 2 1)
    
    putStr "Func. 7: entrada: 2, 4; resultado: "
    print(par (2, 4))
    
    putStr "Func. 8: entrada: 7, 9, 6; resultado: "
    print(segundoGrau 7 9 6)
    
    putStr "Func. 9: entrada: 95 1.90; resultado: "
    print(diagnostico 95 1.90)
    
    putStr "Func. 10: entrada: 1900; resultado: "
    print(bissexto 1900)
    
