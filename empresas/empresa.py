from PySide6.QtWidgets import QWidget, QLabel, QVBoxLayout, QHBoxLayout, QFrame
from PySide6.QtCore import Qt, Signal
from PySide6.QtGui import QPixmap

class Empresa(QFrame):  # Hereda de QFrame para poder usar setFrameStyle
    doble_clic = Signal(str, str, str)  # Señal para emitir nombre, dirección y ciudad.

    def __init__(self, nombre, direccion, ciudad, logo_path=None, parent=None):
        super().__init__(parent)

        self.nombre = nombre
        self.direccion = direccion
        self.ciudad = ciudad

        # Diseño principal
        layout = QHBoxLayout(self)
        layout.setSpacing(10)

        # Logo
        self.logo_label = QLabel(self)
        if logo_path:
            pixmap = QPixmap(logo_path).scaled(50, 50, Qt.KeepAspectRatio, Qt.SmoothTransformation)
            self.logo_label.setPixmap(pixmap)
        else:
            self.logo_label.setText("Sin Logo")
        layout.addWidget(self.logo_label)

        # Información de la empresa
        info_layout = QVBoxLayout()
        self.nombre_label = QLabel(self.nombre)
        self.direccion_label = QLabel(self.direccion)
        self.ciudad_label = QLabel(self.ciudad)

        info_layout.addWidget(self.nombre_label)
        info_layout.addWidget(self.direccion_label)
        info_layout.addWidget(self.ciudad_label)
        layout.addLayout(info_layout)

        # Estilo opcional
        self.setFrameStyle(QFrame.Panel | QFrame.Raised)  # Ahora se puede usar este método
        self.setAutoFillBackground(True)

    def mouseDoubleClickEvent(self, event):
        # Emitir señal con la información
        self.doble_clic.emit(self.nombre, self.direccion, self.ciudad)
        super().mouseDoubleClickEvent(event)
