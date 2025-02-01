from PySide6.QtWidgets import (
    QApplication, QMainWindow, QWidget, QGridLayout, QPushButton, QSizePolicy
)


class VentanaPrincipal(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Layout cuadrícula")

        layout_cuadrícula = QGridLayout()
        componente_principal = QWidget()
        componente_principal.setLayout(layout_cuadrícula)
        self.setCentralWidget(componente_principal)

        btn_0_0 = QPushButton('0,0')
        btn_0_1 = QPushButton('0,1')
        btn_0_2 = QPushButton('0,2')
        btn_0_3 = QPushButton('0,3')

        for btn in [btn_0_0, btn_0_1, btn_0_2, btn_0_3]:
            btn.setSizePolicy(QSizePolicy.MinimumExpanding, QSizePolicy.MinimumExpanding)

        layout_cuadrícula.addWidget(btn_0_0, 0, 0)
        layout_cuadrícula.addWidget(btn_0_1, 0, 1)
        layout_cuadrícula.addWidget(btn_0_2, 0, 2)
        layout_cuadrícula.addWidget(btn_0_3, 0, 3)

        
        btn_1_0 = QPushButton('1,0-3')
        btn_1_0.setSizePolicy(QSizePolicy.MinimumExpanding, QSizePolicy.MinimumExpanding)
        layout_cuadrícula.addWidget(btn_1_0, 1, 0, 1, 4)

        btn_2_2 = QPushButton('2,2-3')
        btn_2_2.setSizePolicy(QSizePolicy.MinimumExpanding, QSizePolicy.MinimumExpanding)
        layout_cuadrícula.addWidget(btn_2_2, 2, 0, 2, 2)

        


app = QApplication([])

ventana = VentanaPrincipal()
ventana.show()

app.exec()
