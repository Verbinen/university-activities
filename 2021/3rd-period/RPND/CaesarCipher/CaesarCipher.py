#Made by: Eduardo Verbinen & Felipe Correa

import os

alfabeto = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
nova_lista = []

def informa_inicio(letra):
  for l in range(len(alfabeto)-1):
    if letra.upper() == alfabeto[l]:
      nova_lista = alfabeto[l:] + alfabeto[:l]
      break;
  return nova_lista

def criptografar(texto, inicial):

  nova_lista = informa_inicio(inicial)

  convertido = ""

  for letra in texto:

    is_caracter = True

    for l in range(len(alfabeto)-1):
      if alfabeto[l] == letra.upper():
        convertido += nova_lista[l]
        is_caracter = False

    if is_caracter:
      convertido += letra

  return convertido

def descriptografar(texto, inicial):

  nova_lista = informa_inicio(inicial)

  desconvertido = ""

  for letra in texto:

    is_caracter = True

    for l in range(len(nova_lista)-1):

      if nova_lista[l] == letra.upper():
        desconvertido += alfabeto[l]
        is_caracter = False

    if is_caracter:
      desconvertido += letra


  return desconvertido


executar = "S"

while executar.upper() == "S":

  print("---------- CIFRA DE CESAR ----------\n")

  tamanho_escolha = 10

  print("Escolha uma opção: \n 1 - Cifrar \n 2 - Decifrar \n")
  opcao = 3

  while opcao > 2 or opcao < 0:
    opcao = int(input())

  while tamanho_escolha > 1:
      letra = input("Digite qual a letra inicial para " + ("descriptografar: \n\n" if opcao == 2 else "criptografar: \n\n"))
      tamanho_escolha = len(letra)

  texto = input("Digite o texto que deseja " + ("descriptografar: \n\n" if opcao == 2 else "criptografar: \n\n"))

  if opcao == 1:
    print("\n\n Texto criptografado: \n ") 
    print(criptografar(texto, letra))

  else:
    print("\n\n Texto descriptografado: \n ")
    print(descriptografar(texto, letra))

  executar = "F"

  while executar.upper() != "S" and executar.upper() != "N":
    executar = input("\n Deseja criptografar ou descriptografar um novo texto? S ou N \n")

  os.system('cls' if os.name == 'nt' else 'clear')