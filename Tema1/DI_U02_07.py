from PySide6.QtWidgets import (
    QApplication,
    QMainWindow,
    QWidget,
    QFormLayout,
    QLabel,
    QLineEdit,
    QPushButton,
)

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Login")

        # interfaz
        usuario_label = QLabel("Usuario:")
        self.usuario_lineedit = QLineEdit()

        contraseña_label = QLabel("Contraseña:")
        self.contraseña_lineedit = QLineEdit()
        self.contraseña_lineedit.setEchoMode(QLineEdit.Password)

        self.resultado_label = QLabel("")

        login = QPushButton("Login")
        login.clicked.connect(self.validar_credenciales)

        # layout
        layout_form = QFormLayout()
        componente_principal = QWidget()
        componente_principal.setLayout(layout_form)
        self.setCentralWidget(componente_principal)

        # add
        layout_form.addRow(usuario_label, self.usuario_lineedit)
        layout_form.addRow(contraseña_label, self.contraseña_lineedit)
        layout_form.addRow(login)
        layout_form.addRow(self.resultado_label)

    # validar
    def validar_credenciales(self):
        usuario = self.usuario_lineedit.text()
        contraseña = self.contraseña_lineedit.text()

        if usuario == "admin" and contraseña == "admin":
            self.resultado_label.setText("Usuario correcto")
            self.resultado_label.setStyleSheet("color: green;")
        else:
            self.resultado_label.setText("Usuario incorrecto")
            self.resultado_label.setStyleSheet("color: red;")

if __name__ == "__main__":
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()
