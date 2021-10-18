# 10. Definix una llista i utilitzant filter, que la separe en dues llistes,
# una amb els elements parells i l’altra amb els senars.

def main():
	llista = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
	parells = list(filter(lambda x: x % 2 == 0, llista))
	imparells = list(filter(lambda x: x % 2 == 1, llista))
	print("parells:", end=" ")
	for i in parells:
		print(i, end=" ")
	print("\nimparells:", end=" ")
	for i in imparells:
		print(i, end=" ")


if __name__ == '__main__':
	main()
