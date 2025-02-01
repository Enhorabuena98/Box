from PySide6.QtWidgets import QApplication, QMainWindow
from buscador import BuscadorEmpresas
import os


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Buscador de Empresas")

        # Rutas de imágenes
        ruta1 = os.path.join(os.path.dirname(__file__), "descarga.jpg")
        ruta2 = os.path.join(os.path.dirname(__file__), "descarga1.jpg")
        ruta3 = os.path.join(os.path.dirname(__file__), "descarga2.jpg")
        ruta4 = os.path.join(os.path.dirname(__file__), "descarga4.jpg")
        ruta5 = os.path.join(os.path.dirname(__file__), "descarga5.jpg")

        # Lista de empresas de ejemplo con logos
        empresas = [
            {"nombre": "PinApple", "direccion": "C/Sin nombre, s/n", "ciudad": "00000 Ciudad Sin Ley", "logo": ruta1},
            {"nombre": "Xiao-my", "direccion": "C/Sin destino, s/n", "ciudad": "11111 Ciudad Sin Memoria", "logo": ruta2},
            {"nombre": "BigTechMeta", "direccion": "C/Sin rumbo, s/n", "ciudad": "22222 Pueblo Fantasma", "logo": ruta3},
            {"nombre": "Toggle", "direccion": "C/Sin señal, s/n", "ciudad": "33333 Pueblo Ardiente", "logo": ruta4},
            {"nombre": "Amatron", "direccion": "C/Sin alcohol, s/n", "ciudad": "44444 Pueblo Seca", "logo": ruta5},
        ]

        # Crear el componente buscador
        buscador = BuscadorEmpresas(empresas)
        buscador.empresa_doble_clic.connect(self.on_empresa_seleccionada)

        # Configurar el buscador como widget central
        self.setCentralWidget(buscador)

    def on_empresa_seleccionada(self, nombre):
        print(f"Empresa seleccionada: {nombre}")


if __name__ == "__main__":
    import sys

    app = QApplication(sys.argv)
    window = MainWindow()
    window.resize(400, 600)
    window.show()
    sys.exit(app.exec())
