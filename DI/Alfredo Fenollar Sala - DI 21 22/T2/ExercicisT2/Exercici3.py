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

from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton
# Importamos sys si necesitamos usar argumentos
import sys
# Libreria para pasar argumentos del comando
import argparse


class MainWindow(QMainWindow):
    def __init__(self, args):
        super().__init__()
        title, text, fixed, size_x, size_y = "La meua aplicació", "Aceptar", False, 300, 200
        # Main window config
        if args.title:
            title = args.title
        if args.button_text:
            text = args.button_text
        if args.fixed_size:
            fixed = args.fixed_size
        if args.size:
            size_x, size_y = args.size
        self.setWindowTitle(title)
        # self.setMinimumSize(200, 150)
        # self.setMaximumSize(1200, 800)
        self.setGeometry(600, 400, size_x, size_y)
        if(fixed):
            self.setFixedSize(size_x, size_y)

        # QPushButton
        self.button = QPushButton(text)
        self.setCentralWidget(self.button)
        self.button.clicked.connect(QApplication.instance().quit)
        # self.button.show() - No hace falta porque button es
        # parte de la ventana y ya se hace un show de la ventana

        # Status bar
        self.statusBar().showMessage('Alfre')


def main():
    # argparse
    parser = argparse.ArgumentParser()
    parser.add_argument("-t", "--title", help="Title of application")
    parser.add_argument("-b", "--button-text", help="Button text")
    parser.add_argument("-f", "--fixed-size", action="store_true",
                        help="Window fixed size")
    parser.add_argument("-s", "--size", nargs=2, metavar=("SIZE_X", "SIZE_Y"), type=int,
                        help="Window's size")
    args = parser.parse_args()

    # PySide6
    app = QApplication(args)
    window = MainWindow(args)
    window.show()
    sys.exit(app.exec())


if __name__ == '__main__':
    main()
