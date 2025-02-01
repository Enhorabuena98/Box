from PySide6.QtCore import Qt
from PySide6.QtWidgets import QApplication,QMainWindow, QWidget, QLayout, QHBoxLayout, QVBoxLayout,QPushButton

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Layout")
        componente_principal = QWidget()
        componente_principal.setLayout(self.crearLH1())
        self.setCentralWidget(componente_principal)

    def crearLV(self):
        layout_vertical = QVBoxLayout()
        layout_vertical.addWidget(QPushButton('V1'))
        layout_vertical.addWidget(QPushButton('V2'))
        layout_vertical.addWidget(QPushButton('V3'))
        layout_vertical.addWidget(QPushButton('V4'))
        layout_vertical.addWidget(QPushButton('V5'))
        return layout_vertical
    
    def crearLH2(self):
        layout_horizontal2 = QHBoxLayout()
        layout_horizontal2.addWidget(QPushButton("H1"))
        layout_horizontal2.addWidget(QPushButton("H2"))
        layout_horizontal2.addWidget(QPushButton("H3"))
        layout_horizontal2.addWidget(QPushButton("H4"))
        return layout_horizontal2
    
    def crearLH1(self):
        layout_horizontal1 = QHBoxLayout()
        layout_horizontal1.addLayout(self.crearLV())
        layout_horizontal1.addLayout(self.crearLH2())
        return layout_horizontal1


if __name__ == "__main__":
    app = QApplication([])
    ventana1 = VentanaPrincipal()
    ventana1.show()
    app.exec()  


        





