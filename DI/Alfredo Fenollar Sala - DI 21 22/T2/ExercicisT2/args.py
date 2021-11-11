import sys


def main():
    arguments = sys.argv

    for i in range(0, len(arguments)):
        print("Argument {}: {}".format(i, arguments[i]))


if __name__ == '__main__':
    main()
