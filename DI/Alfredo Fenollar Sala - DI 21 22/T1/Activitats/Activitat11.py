# 11. Crea una aplicació que vaja llegint operacions d’un fitxer (una operació per línia) i
# afegisca els resultats. Per exemple, si llig: 4 + 4 haurà de generar: 4 + 4 = 8
# Utilitza funcions anònimes per a implementar les operacions.
import os


def main():
	ruta_base = os.path.dirname(__file__)
	ruta_operacions = os.path.join(ruta_base, "operacions.txt")
	ruta_resultats = os.path.join(ruta_base, "resultats.txt")
	
	with open(ruta_operacions, 'r', encoding='utf-8') as f_in:
		with open(ruta_resultats, 'w', encoding='utf-8') as f_out:
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
