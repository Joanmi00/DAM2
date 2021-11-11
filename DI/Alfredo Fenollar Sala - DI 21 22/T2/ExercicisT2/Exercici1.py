# 1. Has de definir una classe MainWindow, que herede de QMainWindow
# 2. Amb el metode setWindowTitle() posa-li titol a l'aplicació <<La meua aplicació>>
# 3. Amb QPushButton(), crea un botó amb el text , <<Aceptar>>
# 4. Afig el botó a la part central de al finestra amb setCentralWidget(<<component>>).
# 5. Recorda mostrar la finestra i iniciar el bucle d'esdeveniments

from PySide6.QtWidgets import QApplication,  QMainWindow, QPushButton
# Importamos sys si necesitamos usar argumentos
import sys


class MainWindow(QMainWindow):
    def __init__(self, title="Mi Aplicación", text="Aceptar"):
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
    app = QApplication(sys.argv)
    window = MainWindow()
    window.show()
    sys.exit(app.exec())


if __name__ == '__main__':
    main()
