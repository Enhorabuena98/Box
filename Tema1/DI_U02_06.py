from PySide6.QtWidgets import QApplication, QMainWindow,QWidget, QGridLayout, QPushButton, QSizePolicy

class VentanaPrincipal(QMainWindow):

    def __init__(self):
        super().__init__()
        self.setWindowTitle("GridLayout")
        componente_principal = QWidget()
        componente_principal.setLayout(self.crearGL())
        self.setCentralWidget(componente_principal)

    def crearBotones(self):
        btnv1 =QPushButton("V1")
        btnv2 =QPushButton("V2")
        btnv3 =QPushButton("V3")
        btnv4 =QPushButton("V4")
        btnv5 =QPushButton("V5")
        btnh1 =QPushButton("H1")
        btnh2 =QPushButton("H2")
        btnh3 =QPushButton("H3")
        btnh4 =QPushButton("hhh")
        return btnv1,btnv2,btnv3,btnv4,btnv5,btnh1,btnh2,btnh3,btnh4
    
    def crearGL(self):
        layout_cuadricula = QGridLayout()
        btnv1,btnv2,btnv3,btnv4,btnv5,btnh1,btnh2,btnh3,btnh4 = self.crearBotones()
        layout_cuadricula.addWidget(btnv1,0,0)
        layout_cuadricula.addWidget(btnv2,1,0)
        layout_cuadricula.addWidget(btnv3,2,0)
        layout_cuadricula.addWidget(btnv4,3,0)
        layout_cuadricula.addWidget(btnv5,4,0)
        layout_cuadricula.addWidget(btnh1,2,1)
        layout_cuadricula.addWidget(btnh2,2,2)
        layout_cuadricula.addWidget(btnh3,2,3)
        layout_cuadricula.addWidget(btnh4,2,4)
        return layout_cuadricula
    
if __name__ == "__main__":
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()