# 11. Crea una aplicació que vaja llegint operacions d’un fitxer (una operació per línia) i
# afegisca els resultats. Per exemple, si llig: 4 + 4 haurà de generar: 4 + 4 = 8
# Utilitza funcions anònimes per a implementar les operacions.
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
