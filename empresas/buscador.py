from PySide6.QtWidgets import QWidget, QVBoxLayout, QLineEdit, QScrollArea
from PySide6.QtCore import Signal
from empresa import Empresa


class BuscadorEmpresas(QWidget):
    empresa_doble_clic = Signal(str)  # Señal para emitir el nombre de la empresa seleccionada.

    def __init__(self, empresas, parent=None):
        super().__init__(parent)

        # Configuración del layout principal
        layout = QVBoxLayout(self)
        self.setLayout(layout)

        # Campo de búsqueda
        self.campo_busqueda = QLineEdit(self)
        self.campo_busqueda.setPlaceholderText("Buscar empresas...")
        self.campo_busqueda.textChanged.connect(self.filtrar_empresas)
        layout.addWidget(self.campo_busqueda)

        # Área de desplazamiento para las empresas
        self.scroll_area = QScrollArea(self)
        self.scroll_area.setWidgetResizable(True)
        layout.addWidget(self.scroll_area)

        # Contenedor interno para las empresas
        self.contenedor_empresas = QWidget(self)
        self.layout_empresas = QVBoxLayout(self.contenedor_empresas)
        self.scroll_area.setWidget(self.contenedor_empresas)

        # Lista de widgets de empresas
        self.lista_empresas = []
        for empresa in empresas:
            widget_empresa = Empresa(
                empresa["nombre"], empresa["direccion"], empresa["ciudad"], empresa.get("logo")
            )
            widget_empresa.doble_clic.connect(self.on_empresa_doble_clic)
            self.layout_empresas.addWidget(widget_empresa)
            self.lista_empresas.append(widget_empresa) # Aqui se añade la empresa al final del array

    def filtrar_empresas(self, texto):
        """Muestra u oculta los widgets de empresas según el texto de búsqueda."""
        texto = texto.lower()
        for widget in self.lista_empresas:
            if texto in widget.nombre.lower():
                widget.show()
            else:
                widget.hide()

    def on_empresa_doble_clic(self, nombre, direccion, ciudad):
        """Emite el nombre de la empresa seleccionada al hacer doble clic."""
        self.empresa_doble_clic.emit(nombre)
        print(f"Empresa seleccionada:\nNombre: {nombre}\nDirección: {direccion}\nCiudad: {ciudad}")
