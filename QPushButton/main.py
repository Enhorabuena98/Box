from PySide6.QtWidgets import QApplication, QVBoxLayout, QLabel, QWidget
from PySide6.QtGui import QIcon
from click_counter_button import ClickCounterButton  # Importar el componente
import os
# Crear la aplicación
app = QApplication()

# Ventana principal
window = QWidget()
layout = QVBoxLayout(window)

# Etiqueta superior
label = QLabel("Presiona el botón para ver los clicks")
layout.addWidget(label)

# Botón personalizado
click_counter_button = ClickCounterButton()
layout.addWidget(click_counter_button)

# Configuración de la ventana
window.setWindowTitle("Botón Contador de Clicks")
ruta_icon = os.path.join(os.path.dirname(__file__),"boton.jpg")
window.setWindowIcon(QIcon(ruta_icon))
window.resize(200, 70)
window.show()


# Ejecutar la aplicación
app.exec()
