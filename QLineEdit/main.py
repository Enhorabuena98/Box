from PySide6.QtWidgets import QApplication, QVBoxLayout, QMainWindow, QWidget
from password_line_edit import PasswordLineEdit  # Importar la clase personalizada

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Campo de Contraseña con Íconos Personalizados")

        password_field = PasswordLineEdit(self)
        password_field.setPlaceholderText("Introduce tu contraseña")

        layout = QVBoxLayout()
        layout.addWidget(password_field)

        container = QWidget()
        container.setLayout(layout)

        self.setCentralWidget(container)

if __name__ == "__main__":
    app = QApplication([])
    window = MainWindow()
    window.show()
    app.exec()
