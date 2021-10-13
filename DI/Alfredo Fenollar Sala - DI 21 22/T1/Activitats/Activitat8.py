import sys
from os.path import dirname

sys.path.append(dirname(__file__))

# 8. Fes una aplicació que imprimisca els primers 100 números imparells.
cont = 0
"Primeros 100 numeros impares:"
for i in range(250):
	if (i % 2 == 1) & (cont <= 100):
		cont = cont + 1
		print(i)
	elif cont > 100:
		break
