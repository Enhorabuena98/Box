from PySide6.QtWidgets import QApplication, QWidget, QComboBox, QLabel

class VentanaPrincipal(QWidget):
    def __init__(self):
        super().__init__()
        self.inicializar_interfaz()
        self.crear_combo_box()
        self.asignar_meses()
        self.configurar_interacciones()

    def inicializar_interfaz(self):
        self.setWindowTitle("ComboBox")
        self.setGeometry(150, 150, 500, 500)

    def crear_combo_box(self):
        self.comboBox = QComboBox(self)
        self.comboBox.move(15, 15)

    def asignar_meses(self):
        meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"]
        self.comboBox.addItems(meses)

    def configurar_interacciones(self):
        self.comboBox.currentIndexChanged.connect(self.mostrar_mes)

    def mostrar_mes(self):
        mes_seleccionado = self.comboBox.currentText()
        indice = self.comboBox.currentIndex() + 1
        print(f"Número del mes: {indice}, Mes seleccionado: {mes_seleccionado}")

def iniciar_aplicacion():
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()

if __name__ == "__main__":
    iniciar_aplicacion()
