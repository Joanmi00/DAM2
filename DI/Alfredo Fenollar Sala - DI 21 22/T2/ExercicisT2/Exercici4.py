#!/usr/bin/python
''' ENUNCIADO
    Fes una aplicació amb tres botons. Inicialment, l’aplicació ocuparà el tamany normalitzat i els botons estaran centrats, tant verticalment com horitzontalment en tot moment:

    ·Inicialment l’aplicació es mostrarà centrada sobre la pantalla amb el tamany normalitzat.
    ·Al fer clic al botó de l’esquerra Maximitza, l’aplicació passarà a ocupar el tamany màxim definit.
    ·Al fer clic al botó de la dreta Minimitza, l’aplicació passarà a ocupar el tamany mínim definit.
    ·Al fer clic al botó central Normalitza, l’aplicació passarà a ocupar de nou el tamany normalitzat.
    ·En cada cas, els botons es deshabilitzaran segons corresponga. És a dir, en tamany normalitzat, el botó corresponent a normalitzar el tamany estarà deshabilitat i la restat habilitats. Per a la resta de tamanys, aplicarem el mateix criteri.
    ·El tamanys normal, màxim i mínim de finestra, així com els tamanys de botó estaran definits a un arxiu config.py
    ·El tamany mínim mai podrà ser inferior a la suma dels tamanys de botó.
    ·El title de l’aplicació mostrarà en cada moment en quin estat es troba Normalitzat, Maximitzat o Minimitzat
    '''

# Imports de PySide6
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton
from PySide6.QtCore import QSize
# Importamos sys si necesitamos usar argumentos
import sys
# Libreria para pasar argumentos del comando
import argparse


class MainWindow(QMainWindow):
    def __init__(self, args):
        super().__init__()
        self.BUTTON_WIDTH=120
        self.BUTTON_HEIGHT=30
        self.initUI(args)

    def initUI(self, args):
        # Declarar valor predet. de variables
        title, text, fixed, size_x, size_y = "La meua aplicació", "Aceptar", False, 400, 400
        # Establecer nuevo valor de variables si es necesario
        if args.title:
            title = args.title
        # Text inutilizado por ahora
            # if args.button_text:
            #     text = args.button_text
        if args.fixed_size:
            fixed = args.fixed_size
        if args.size:
            size_x, size_y = args.size
        # Montar Ventana llamando a cada método
        self.mainWindow(title, fixed, size_x, size_y)
        self.buttons()
        self.extras()

    def mainWindow(self, title, fixed, size_x, size_y):
        self.setWindowTitle(title)
        self.setMinimumSize(200, 150)
        # self.setMaximumSize(1200, 800)
        if(fixed):
            self.setFixedSize(size_x, size_y)
        self.resize(size_x, size_y)
        self.center_to_screen()

    def buttons(self):
        # QPushButton
        b_max = QPushButton("Maximiza", self)
        b_max.resize(self.BUTTON_WIDTH, self.BUTTON_HEIGHT)
        # b_max.pos()
        b_norm = QPushButton("Normaliza", self)
        b_max.resize(self.BUTTON_WIDTH, self.BUTTON_HEIGHT)
        b_min = QPushButton("Minimiza", self)
        b_max.resize(self.BUTTON_WIDTH, self.BUTTON_HEIGHT)
        #self.setCentralWidget(pybutton1)
        # Connectamos la señal clicked a la ranura del respectivo button_pressed
        b_max.clicked.connect(self.b_max_pressed)
        b_norm.clicked.connect(self.b_norm_pressed)
        b_min.clicked.connect(self.b_min_pressed)

    def extras(self):
        # Status bar
        self.statusBar().showMessage('Alfre')

    def center_to_screen(self):
        qr = self.frameGeometry()
        cp = self.screen().availableGeometry().center()
        qr.moveCenter(cp)
        self.move(qr.topLeft())

    def b_max_pressed(self):
        print("Boton 1")
    
    def b_norm_pressed(self):
        print("Boton 2")
    
    def b_min_pressed(self):
        print("Boton 3")


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
    app = QApplication(sys.argv)
    window = MainWindow(args)
    window.show()
    sys.exit(app.exec())


if __name__ == '__main__':
    main()
