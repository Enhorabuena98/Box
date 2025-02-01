from PySide6.QtWidgets import QApplication, QMainWindow, QVBoxLayout, QWidget, QPushButton, QMessageBox
from editor import EditorUsuario


class VentanaRegistro(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Registro de usuario")

        # Configuración del widget central
        widget_central = QWidget(self)
        self.setCentralWidget(widget_central)

        layout = QVBoxLayout(widget_central)

        # Componente EditorUsuario
        self.editor_usuario = EditorUsuario(self)
        self.editor_usuario.validacion_cambiada.connect(self.mostrar_estado_validacion)
        layout.addWidget(self.editor_usuario)

        # Botón de Registrar
        boton_registrar = QPushButton("Registrar", self)
        boton_registrar.clicked.connect(self.validar_usuario)
        layout.addWidget(boton_registrar)

    def mostrar_estado_validacion(self, es_valido):
        """Muestra el estado de validacion"""
        if es_valido:
            self.editor_usuario.setStyleSheet("border: 2px solid green;")
        else:
            self.editor_usuario.setStyleSheet("border: 2px solid red;")

    def validar_usuario(self):
        """Valida el usuario al hacer clic"""
        es_valido = self.editor_usuario.es_usuario_valido()
        if es_valido:
            QMessageBox.information(self, "Registro", "nombre de usuario es valido")
        else:
            QMessageBox.warning(self, "Registro", "nombre de usuario no es valido")


if __name__ == "__main__":
    import sys

    app = QApplication(sys.argv)
    ventana = VentanaRegistro()
    ventana.resize(400, 200)
    ventana.show()
    sys.exit(app.exec())
