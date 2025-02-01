from PySide6.QtWidgets import (
    QApplication,
    QMainWindow,
    QComboBox,
    QLineEdit,
    QPushButton,
    QLabel,
    QVBoxLayout,
    QHBoxLayout,
    QWidget
)

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Temperaturas")
        self.setGeometry(530, 330, 450, 170)

        # Crear un widget central
        widget_central = QWidget(self)
        self.setCentralWidget(widget_central)

        # Layout principal
        layout = QVBoxLayout(widget_central)

        # Layout horizontal para los combobox
        layout_horiz = QHBoxLayout()
        
        # Combobox de origen
        self.cb_origen = QComboBox(self)
        self.cb_origen.addItems(["Celsius", "Fahrenheit"])
        layout_horiz.addWidget(self.cb_origen)

        # Etiqueta "a"
        self.lb_separacion = QLabel("a", self)
        layout_horiz.addWidget(self.lb_separacion)

        # Combobox de destino
        self.cb_destino = QComboBox(self)
        self.cb_destino.addItems(["Fahrenheit", "Celsius"])
        layout_horiz.addWidget(self.cb_destino)

        # Añadir el layout horizontal al layout principal
        layout.addLayout(layout_horiz)

        # LineEdit para ingresar el valor
        self.le_valor = QLineEdit(self)
        self.le_valor.setPlaceholderText("Ingresa el valor de la temperatura")
        layout.addWidget(self.le_valor)

        # Botón para convertir
        self.pb_cambio = QPushButton("Convertir", self)
        self.pb_cambio.clicked.connect(self.convertir_temperatura)
        layout.addWidget(self.pb_cambio)

        # Label para mostrar el resultado
        self.lb_resultado = QLabel("Resultado:", self)
        layout.addWidget(self.lb_resultado)

    def convertir_temperatura(self):
        try:
            temp = float(self.le_valor.text())
            unidad_origen = self.cb_origen.currentText()
            unidad_destino = self.cb_destino.currentText()

            if unidad_origen == "Celsius" and unidad_destino == "Fahrenheit":
                resultado = (temp * 9/5) + 32
            elif unidad_origen == "Fahrenheit" and unidad_destino == "Celsius":
                resultado = (temp - 32) * 5/9
            else:
                resultado = temp

            self.lb_resultado.setText(f"Resultado: {resultado:.2f} {unidad_destino}")
        
        except ValueError:
            self.lb_resultado.setText("Error")

if __name__ == "__main__":
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()
