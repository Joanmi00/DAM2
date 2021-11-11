from PySide6.QtWidgets import QApplication,  QMainWindow, QPushButton

# Sols si necessitem arguments importem sys
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
    sys.exit(app.exec())


if __name__ == "__main__":
    main()
