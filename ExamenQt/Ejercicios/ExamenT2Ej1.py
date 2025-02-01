from PySide6.QtWidgets import (
    QApplication,
    QMainWindow,
    QWidget,
    QVBoxLayout,
    QFormLayout,
    QLabel,
    QLineEdit,
    QPushButton,
)

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Registro de Empleados")
        self.crear_campos()
        self.crear_layouts()
        

# labels y lineedits
    def crear_campos(self):
        self.nombre_label = QLabel("Nombre:")
        self.nombre_lineedit = QLineEdit()

        self.edad_label = QLabel("Edad:")
        self.edad_lineedit = QLineEdit()

        self.direccion_label = QLabel("Direccion:")
        self.direccion_lineedit = QLineEdit()

        self.telefono_label = QLabel("Telefono:")
        self.telefono_lineedit = QLineEdit()

        self.cargo_label = QLabel("Cargo:")
        self.cargo_lineedit = QLineEdit()

        self.salario_label = QLabel("Salario:")
        self.salario_lineedit = QLineEdit()

        self.empleadosRegistrados = QLabel("Empleados Registrados:")

        self.registrar = QPushButton("Registrar")
        self.registrar.clicked.connect(self.registrarEmpleados)
        
        
# layout
    def crear_layouts(self):
        self.layoutmain = QVBoxLayout()

        layout_form = QFormLayout()
        componente_principal = QWidget()
        componente_principal.setLayout(self.layoutmain)
        self.setCentralWidget(componente_principal)

        # rows
        layout_form.addRow(self.nombre_label, self.nombre_lineedit)
        layout_form.addRow(self.edad_label, self.edad_lineedit)
        layout_form.addRow(self.direccion_label, self.direccion_lineedit)
        layout_form.addRow(self.telefono_label, self.telefono_lineedit)
        layout_form.addRow(self.cargo_label, self.cargo_lineedit)
        layout_form.addRow(self.salario_label, self.salario_lineedit)

        self.layoutmain.addLayout(layout_form)
        self.layoutmain.addWidget(self.registrar)
        self.layoutmain.addWidget(self.empleadosRegistrados)


    # registrar
    def registrarEmpleados(self):

        nombre = self.nombre_lineedit.text()
        cargo = self.cargo_lineedit.text()
        salario = self.salario_lineedit.text()
        labelR = QLabel()
        labelR.setText(f"{nombre} - {cargo} - {salario}")
        self.layoutmain.addWidget(labelR)
        self.nombre_lineedit.clear()
        self.edad_lineedit.clear()
        self.direccion_lineedit.clear()
        self.telefono_lineedit.clear()
        self.cargo_lineedit.clear()
        self.salario_lineedit.clear()

if __name__ == "__main__":
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()
