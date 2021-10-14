# 12. Modifica el codi de l’activitat 11 per a que no es produïsquen errors en l’execució, ja siga
# per introdïur valor no definits per a les funcions, valors que no són numèrics o operacions desconegudes.
# Controla també que no es produïsquen errors en la lectura/escriptura dels arxius.
import os


def main():
	class NoEsUnNumero(Exception):
		"""Llançada quan el valor introduït no és vàlid"""
		pass
	
	class LongitudIncompatible(Exception):
		"""Llançada quan la longitud introduida no és vàlida"""
		pass
	
	class SimboloIncorrecto(Exception):
		"""Llançada quan el simbol introduït no és vàlid"""
		pass
	
	ruta_base = os.path.dirname(__file__)
	ruta_operacions = os.path.join(ruta_base, "operacions.txt")
	ruta_resultats = os.path.join(ruta_base, "resultats.txt")
	
	with open(ruta_operacions, 'r', encoding='utf-8') as f_in:
		with open(ruta_resultats, 'w', encoding='utf-8') as f_out:
			try:
				for linia in f_in.read().splitlines():
					parts = linia.split(" ")
					if not len(parts) == 3:
						raise LongitudIncompatible
					if not parts[0].isdigit() or not parts[2].isdigit():
						raise NoEsUnNumero
					if parts[1] == '+':
						f_out.write(str(linia + " = " + str(int(parts[0]) + int(parts[2])) + '\n'))
					elif parts[1] == '-':
						f_out.write(str(linia + " = " + str(int(parts[0]) - int(parts[2])) + '\n'))
					elif parts[1] == '*':
						f_out.write(str(linia + " = " + str(int(parts[0]) * int(parts[2])) + '\n'))
					elif parts[1] == '/':
						f_out.write(str(linia + " = " + str(int(parts[0]) / int(parts[2])) + '\n'))
					else:
						raise SimboloIncorrecto
			except NoEsUnNumero:
				print("No hi ha un número on se espera!\n")
			except SimboloIncorrecto:
				print("Hi ha un simbol incorrecte!\n")
			except LongitudIncompatible:
				print("La longitud introduida es incompatible!\n")


if __name__ == '__main__':
	main()
