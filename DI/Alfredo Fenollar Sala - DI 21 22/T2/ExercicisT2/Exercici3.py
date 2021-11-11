# Basant-nos en el codi de l’activitat 2, anem a fer una gestió
# més pràctica i real dels paràmetres d’entrada de l’script.
# Este és l’aspecte que tindrà l’ajuda de l’execució de l’script.
# Per a fer tota aquesta gestió, busca una llibreria de python que t’ajude.

'''
usage: Exercici3.py [-h] [-t TITLE] [-b BUTTON_TEXT] [-f] [-s SIZE SIZE]

optional arguments:
    -h, --help            show this help message and exit
    -t TITLE, --title TITLE
                        Title of application
    -b BUTTON_TEXT, --button-text BUTTON_TEXT
                        Button text
    -f, --fixed-size      Window fixed size
    -s SIZE SIZE, --size SIZE SIZE
                        Size of windows
'''

from PySide6.QtWidgets import QApplication,  QMainWindow, QPushButton
# Importamos sys si necesitamos usar argumentos
import sys
# Libreria para pasar argumentos del comando
import argparse


class MainWindow(QMainWindow):
    def __init__(self, title="La meua aplicació", text="Aceptar"):
        super().__init__()
        # Main window config
        self.setWindowTitle(title)
        self.setGeometry(600, 300, 300, 200)
        self.setMinimumSize(200, 150)
        self.setMaximumSize(400, 250)
        # self.setFixedSize(400,600)

        # QPushButton
        self.button = QPushButton(text)
        self.setCentralWidget(self.button)
        self.button.clicked.connect(QApplication.instance().quit)
        # self.button.show() No hace falta porque button es parte the la ventana
        # y ya se hace un show de la ventana

        # Status bar
        self.statusBar().showMessage('Alfre')


def main():
    # argparse
    parser = argparse.ArgumentParser(description='Crear una ventana.')
    parser.add_argument("echo", help="echo the string you use here")
    # parser.add_argument('integers', metavar='N', type=int,
    #                     nargs='+', help='an integer for the accumulator')
    # parser.add_argument('--sum', dest='accumulate', action='store_const',
    #                     const=sum, default=max,
    #                     help='sum the integers (default: find the max)')
    args = parser.parse_args()
    print(args.echo)
    # print(args.accumulate(args.integers))

    # PySide6
    app = QApplication(sys.argv)
    if len(sys.argv) >= 3:
        window = MainWindow(sys.argv[1], sys.argv[2])
    else:
        window = MainWindow()
    window.show()
    sys.exit(app.exec())


if __name__ == '__main__':
    main()
