# 8. Fes una aplicació que imprimisca els primers 100 números imparells.

def main():
	for parells in range(1, 200, 2):
		print(parells)


def version_mala():
	cont = 0
	"Primeros 100 numeros impares:"
	for i in range(250):
		if (i % 2 == 1) & (cont <= 100):
			cont = cont + 1
			print(i)
		elif cont > 100:
			break


if __name__ == '__main__':
	main()
