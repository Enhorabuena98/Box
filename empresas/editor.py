from PySide6.QtWidgets import QLineEdit
from PySide6.QtCore import Signal
import re


class EditorUsuario(QLineEdit):
    # Señal personalizada que emite el estado de validación (válido o no válido)
    validacion_cambiada = Signal(bool)

    def __init__(self, parent=None):
        super().__init__(parent)
        self.setPlaceholderText("Introduce tu nombre de usuario...")

    def focusOutEvent(self, event):
        """Se ejecuta al perder el foco; valida el texto introducido."""
        super().focusOutEvent(event)
        es_valido = self.es_usuario_valido()
        self.validacion_cambiada.emit(es_valido)

    def es_usuario_valido(self):
        """Valida si el nombre de usuario cumple las reglas."""
        texto = self.text()
        patron = r'^[A-Za-z][A-Za-z0-9_-]{3,13}[A-Za-z0-9]$'
        return re.match(patron, texto) is not None
