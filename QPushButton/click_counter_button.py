from PySide6.QtWidgets import QPushButton

class ClickCounterButton(QPushButton):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.click_count = 0  # Contador de clics
        self.update_text()  # Actualizar el texto inicial
        
        # Conectar el clic del botón al método que incrementa el contador
        self.clicked.connect(self.increment_click_count)

    def increment_click_count(self):
        """Incrementa el contador de clics y actualiza el texto."""
        self.click_count += 1
        self.update_text()

    def update_text(self):
        """Actualiza el texto del botón con el contador actual."""
        self.setText(f"Clicks realizados: {self.click_count}")
