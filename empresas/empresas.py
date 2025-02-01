from PySide6.QtWidgets import QWidget, QVBoxLayout, QScrollArea
from PySide6.QtCore import Signal
from empresa import Empresa  # Asegúrate de que el archivo empresa.py esté en la misma carpeta.

class Empresas(QWidget):
    empresa_doble_clic = Signal(str)  # Señal para emitir solo el nombre.

    def __init__(self, empresas, parent=None):
        super().__init__(parent)

        layout = QVBoxLayout(self)

        # Área de desplazamiento
        scroll_area = QScrollArea(self)
        scroll_area.setWidgetResizable(True)
        layout.addWidget(scroll_area)

        # Contenedor de empresas
        content_widget = QWidget()
        content_layout = QVBoxLayout(content_widget)

        for empresa in empresas:
            widget_empresa = Empresa(
                empresa["nombre"], empresa["direccion"], empresa["ciudad"], empresa.get("logo")
            )
            widget_empresa.doble_clic.connect(self.on_empresa_doble_clic)
            content_layout.addWidget(widget_empresa)

        scroll_area.setWidget(content_widget)

    def on_empresa_doble_clic(self, nombre, direccion, ciudad):
        # Emitir el nombre a la señal principal
        self.empresa_doble_clic.emit(nombre)
        print(f"Información de la empresa seleccionada:\nNombre: {nombre}\nDirección: {direccion}\nCiudad: {ciudad}")
