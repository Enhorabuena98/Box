# paso1 imports
from PySide6.QtWidgets import (
    QApplication,
    QMainWindow,
    QWidget,
    QVBoxLayout,
    QHBoxLayout,
    QComboBox,
    QLineEdit,
    QLabel,
    QPushButton
)
#  paso2 ventana
class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Temperaturas")
        self.setGeometry(530,330,450,170)

        # paso3 Qwidget central
        widget_central = QWidget(self)
        self.setCentralWidget(widget_central)
        # paso4 layouts
        layout = QVBoxLayout(widget_central)
        layout_horizontal = QHBoxLayout()
        # paso5 añadir combobox medidas
        self.cb_origen = QComboBox(self)
        self.cb_origen.addItems(["Celsius", "Fahrenheit"])
        layout_horizontal.addWidget(self.cb_origen)
        # Etiqueta "a"
        self.lb_separacion = QLabel("a", self)
        layout_horizontal.addWidget(self.lb_separacion)
        self.cb_destino = QComboBox(self)
        self.cb_destino.addItems(["Farenheit","Celsius"])
        layout_horizontal.addWidget(self.cb_destino)
        # paso6 layaout en layout
        layout.addLayout(layout_horizontal)
        # lineedit para meter valor
        self.le_valor = QLineEdit(self)
        self.le_valor.setPlaceholderText("Ingresa el valor de la temperatura")
        layout.addWidget(self.le_valor)
        
        # boton para convertir
        self.pb_cambio = QPushButton("Convertir",self)
        self.pb_cambio.clicked.connect(self.convertir_temperatura)
        layout.addWidget(self.pb_cambio)
        # label resultado
        self.lb_resultado = QLabel("Resultado", self)
        layout.addWidget(self.lb_resultado)

    def convertir_temperatura(self):
        try:
            temp = float(self.le_valor.text())
            unidad_origen = self.cb_origen.currentText()
            unidad_destino = self.cb_destino.currentText()

            if unidad_origen == "Celsius" and unidad_destino == "Farenheit":
                resultado = (temp * 9/5) + 32
            elif unidad_origen == "Farenheit" and unidad_destino == "Celsius":
                resultado = (temp -32) * 5/9
            else:
                resultado = temp
            self.lb_resultado.setText(f"Resultado: {resultado:.2f} {unidad_destino}")
        except ValueError:
            self.lb_resultado.setText("Error")

    
if __name__=="__main__":
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()