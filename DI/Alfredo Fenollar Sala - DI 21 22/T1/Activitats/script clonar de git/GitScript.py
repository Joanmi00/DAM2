import os

if __name__ == '__main__':
	ruta_base = os.path.dirname(__file__)
	os.chdir(ruta_base)
	with open("repositoris.txt", 'r', encoding='utf-8') as f:
		for linia in f.read().splitlines():
			os.system("git clone {}".format(linia))
