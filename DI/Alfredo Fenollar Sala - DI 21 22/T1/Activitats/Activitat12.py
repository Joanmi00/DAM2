# 12. Modifica el codi de l’activitat 11 per a que no es produïsquen errors en l’execució, ja siga
# per introdïur valor no definits per a les funcions, valors que no són numèrics o operacions desconegudes.
# Controla també que no es produïsquen errors en la lectura/escriptura dels arxius.
import os


def main():
	ruta_base = os.path.dirname(__file__)
	ruta_a_recurs_in = os.path.join(ruta_base, "operacions.txt")
	ruta_a_recurs_out = os.path.join(ruta_base, "resultats.txt")
	
	with open(ruta_a_recurs_out, 'w', encoding='utf-8') as f_out:
		with open(ruta_a_recurs_in, 'r', encoding='utf-8') as f_in:
			for linia in f_in.read().splitlines():
				parts = linia.split(" ")
				if parts[1] == '+':
					f_out.write(str(linia + " = " + str(int(parts[0]) + int(parts[2])) + '\n'))
				elif parts[1] == '-':
					f_out.write(str(linia + " = " + str(int(parts[0]) - int(parts[2])) + '\n'))
				elif parts[1] == '*':
					f_out.write(str(linia + " = " + str(int(parts[0]) * int(parts[2])) + '\n'))
				elif parts[1] == '/':
					f_out.write(str(linia + " = " + str(int(parts[0]) / int(parts[2])) + '\n'))


if __name__ == '__main__':
	main()
