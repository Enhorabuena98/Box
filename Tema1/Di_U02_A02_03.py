from PySide6.QtWidgets import QApplication, QPushButton, QWidget, QLabel, QLineEdit

class VentanaPrincipal(QWidget):
    def __init__(self):
        super().__init__()
        self.inicializar_interfaz()
        self.crear_qlabel()
        self.crear_qlineedit()
        self.configurar_interacciones()

    def inicializar_interfaz(self):
        self.setWindowTitle("Ventana")
        self.setGeometry(100, 100, 300, 200)

    def crear_qlabel(self):
        self.label1 = QLabel("hola", self)
        self.label1.move(50, 50)
        self.label1.setFixedSize(50, 30)

    def crear_qlineedit(self):
        self.lineedit1 = QLineEdit("hola", self)
        self.lineedit1.move(100, 50)
        self.lineedit1.setMaxLength(5)
        self.lineedit1.setFixedSize(50, 30)

    def configurar_interacciones(self):
        self.lineedit1.textChanged.connect(lambda texto: self.label1.setText(texto))

    

def iniciar_aplicacion():
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()

if __name__ == "__main__":
    iniciar_aplicacion()
