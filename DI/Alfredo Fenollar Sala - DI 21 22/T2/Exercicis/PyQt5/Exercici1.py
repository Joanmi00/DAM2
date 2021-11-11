# 1. Has de definir una classe MainWindow, que herede de QMainWindow
# 2. Amb el metode setWindowTitle() posa-li titol a l'aplicació <<La meua aplicació>>
# 3. Amb QPushButton(), crea un botó amb el text , <<Aceptar>>
# 4. Afig el botó a la part central de al finestra amb setCentralWidget(<<component>>).
# 5. Recorda mostrar la finestra i iniciar el bucle d'esdeveniments

from PyQt5.QtWidgets import QApplication,  QMainWindow, QPushButton
# Importamos sys si necesitamos usar argumentos
import sys


class MainWindow(QMainWindow):
    def __init__(self, title="La meua aplicació", text="Aceptar"):
        super().__init__()
        # Main window config
        self.setGeometry(500, 500, 450, 220)
        self.setMinimumSize(150, 120)

        # Title
        self.setWindowTitle(title)

        # QPushButton
        button = QPushButton(text, self)
        self.setCentralWidget(button)
        button.clicked.connect(QApplication.instance().quit)

        # Status bar
        self.statusBar().showMessage('Alfre')


def main():
    app = QApplication(sys.argv)
    if len(sys.argv) >= 3:
        window = MainWindow(sys.argv[1], sys.argv[2])
    else:
        window = MainWindow()
    window.show()
    sys.exit(app.exec_())


if __name__ == '__main__':
    main()
