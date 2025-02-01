import os
from PySide6.QtWidgets import QLineEdit
from PySide6.QtGui import QAction, QIcon

class PasswordLineEdit(QLineEdit):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.setEchoMode(QLineEdit.Password)  # Modo contraseña por defecto

        # Obtener el directorio del script actual
        script_dir = os.path.dirname(os.path.abspath(__file__))

        # Generar rutas absolutas para las imágenes
        self.show_password_icon_path = os.path.join(script_dir, "ojo_visible.png")
        self.hide_password_icon_path = os.path.join(script_dir, "ojo_oculto.png")

        # Crear la acción para alternar visibilidad
        self.toggle_action = QAction(self)
        self.toggle_action.setIcon(QIcon(self.hide_password_icon_path))
        self.addAction(self.toggle_action, QLineEdit.TrailingPosition)
        self.setFixedHeight(40)
        # Conectar la acción al método para alternar
        self.toggle_action.triggered.connect(self.toggle_password_visibility)

    def toggle_password_visibility(self):
        """Alterna entre modo contraseña y texto visible."""
        if self.echoMode() == QLineEdit.Password:
            self.setEchoMode(QLineEdit.Normal)
            self.toggle_action.setIcon(QIcon(self.show_password_icon_path))
        else:
            self.setEchoMode(QLineEdit.Password)
            self.toggle_action.setIcon(QIcon(self.hide_password_icon_path))
