import os
import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QToolBar, QWhatsThis, QDockWidget, QTextEdit, QWidget
from PySide6.QtGui import QAction, QIcon, QKeySequence
from PySide6.QtCore import Qt

# Clase personalizada para redirigir stdout
class ConsoleRedirector:
    def __init__(self, text_edit):
        self.text_edit = text_edit

    def write(self, text):
        self.text_edit.append(text)  # Añadir el texto al QTextEdit

    def flush(self):
        pass  # No es necesario para QTextEdit

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setGeometry(600, 300, 600, 400)
        self.setWindowTitle("Ventana principal con menus")

        # Crear el área central principal (componente principal)
        widget_principal = QWidget(self)
        self.setCentralWidget(widget_principal)

        # Crear la barra de menú
        barra_menu = self.menuBar()
        menu = barra_menu.addMenu("&Menu")

        ruta_imagen1 = os.path.join(os.path.dirname(__file__), "../Imprimir.png")
        ruta_imagen2 = os.path.join(os.path.dirname(__file__), "../ayuda.png")

        # Crear acciones
        accion1 = QAction(QIcon(ruta_imagen1), "&Imprimir por consola", self)
        accion1.setShortcut(QKeySequence("ctrl+p"))
        accion1.setWhatsThis("Accion para imprimir en dock")
        accion1.triggered.connect(self.imprimir_por_consola)

        accion2 = QAction(QIcon(ruta_imagen2), "&Que es esto?", self)
        accion2.setShortcut(QKeySequence("ctrl+h"))
        accion2.setWhatsThis("Accion para entrar/salir del modo WhatsThis")

        accion2.triggered.connect(self.whatsThis)

        # Añadir la acción al menú
        menu.addAction(accion1)
        menu.addAction(accion2)

        # Crear la barra de herramientas
        barra_herramientas = QToolBar("Barra de herramientas 1")
        barra_herramientas.addAction(accion1)
        barra_herramientas.addAction(accion2)
        barra_herramientas.setToolButtonStyle(Qt.ToolButtonTextUnderIcon)

        # Añadir la barra de herramientas a la ventana
        self.addToolBar(barra_herramientas)

        # Crear un QDockWidget
        self.dockText = QTextEdit()
        
        self.dock = QDockWidget("dock widget", self)
        self.dock.setWidget(self.dockText)
        self.dock.setWhatsThis("Dock en el que se imprimirá")

        self.addDockWidget(Qt.TopDockWidgetArea, self.dock)

    def whatsThis(self):
        if QWhatsThis.inWhatsThisMode():
            QWhatsThis.leaveWhatsThisMode()
        else:
            QWhatsThis.enterWhatsThisMode()

    def imprimir_por_consola(self):
        self.dock.widget().append("holaaaaaaaa")
if __name__ == "__main__":
    app = QApplication([])
    ventana1 = VentanaPrincipal()
    ventana1.show()
    app.exec()


