from PyQt5.QtWidgets import QApplication, QWidget
# Importamos sys si necesitamos usar argumentos
import sys


def main():
    # Necessitem una instancia de QApplication per cada a
    # Li passem sys.argv per a permetre arguments des de la linia de
    # Si no anem a passar arguments, podem utilitzar QApplication([])
    app = QApplication(sys.argv)

    # Creem un QWidget, que sera la nostra finestra
    window = QWidget()
    window.show()  # IMPORTANT!!! Les finestres estan ocultes per defecte

    # Iniciem el bucle de events
    app.exec_()
    # exec es una paraula reservada en Python 2.7, per aixo afegim _


if __name__ == '__main__':
    main()
