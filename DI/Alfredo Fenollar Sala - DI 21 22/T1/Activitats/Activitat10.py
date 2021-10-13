import sys
from os.path import dirname

sys.path.append(dirname(__file__))

# 9. Fes una aplicació que donada la següent llista,
# imprimisca els seus membres: aficions = [‘esports’, ‘cine’, ‘teatre’]
print()
aficions = ['esports', 'cine', 'teatre']


def imprimir_membres(*membres):
	for membre in membres:
		print(membre)


imprimir_membres(aficions)