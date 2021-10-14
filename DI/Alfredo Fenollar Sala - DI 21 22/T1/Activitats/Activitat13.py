# 13. Anem a implementar un xicotet joc per consola. El programa generarà un número aleatori
# entre 0 i 100 (utilitzeu randint() del mòdul random) i demanarà a l’usuari que introduïsca un número.
# Mentre el número siga massa menut, llançarà una excepció ErrorEnterMassaMenut indicant-li-ho.
# Si per contra és massa gran llançarà ErrorEnterMassaGran.
# El joc acabarà quan s’introduïsca un valor no numèric o quan s’introduïsca l’enter buscat,
# en este cas felicitarà a l’usuari.
import random


def main():
	class NoEsUnNumero(Exception):
		"""Llançada quan el valor introduït no és vàlid"""
		pass
	
	class NumMassaGran(Exception):
		"""Llançada quan el valor introduït es massa gran"""
		pass
	
	class NumMassaMenut(Exception):
		"""Llançada quan el valor introduït es massa menut"""
		pass
	
	# Usuari adivina un numero hasta que lo acierta
	aleatorio = random.randint(0, 100)
	while True:
		try:
			i_num = input("Dona'm un número: ")
			if i_num.isdigit():
				if int(i_num) > aleatorio:
					raise NumMassaGran
				elif int(i_num) < aleatorio:
					raise NumMassaMenut
				else:
					print("Has guanyat!!")
			else:
				raise NoEsUnNumero
		except NumMassaGran:
			print("El numero es massa gran!\n")
		except NumMassaMenut:
			print("El numero es massa menut!\n")
		except NoEsUnNumero:
			print("No m'has donat un número!\n")
			break
	print("Fi del programa")


if __name__ == '__main__':
	main()
