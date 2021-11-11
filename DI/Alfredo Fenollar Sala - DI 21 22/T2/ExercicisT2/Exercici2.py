# Modifica el codi de l’anterior activitat per a que es puga passar per
# línia de comandaments el títol i el text del botó.
# Recomanable usar el launch.json del debugger per a introduir els arguments.
# Example de comando:
# python3 activitat2.2.py "APP" "Text"

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
    if len(sys.argv) >= 3:
        window = MainWindow(sys.argv[1], sys.argv[2])
    else:
        window = MainWindow()
    window.show()
    sys.exit(app.exec())


if __name__ == '__main__':
    main()
