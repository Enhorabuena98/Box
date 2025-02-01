import os
from PySide6.QtWidgets  import QApplication,QMainWindow,QWidget, QToolBar, QWhatsThis,QTextEdit, QDockWidget
from PySide6.QtGui import QAction,QIcon,QKeySequence
from PySide6.QtCore import Qt

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Imprimir en doc")
        self.setGeometry(600,300,600,400)

        widget_principal = QWidget(self)
        self.setCentralWidget(widget_principal)

        barra_menu = self.menuBar()
        menu = barra_menu.addMenu("&mMenu")

        ruta1 = os.path.join(os.path.dirname(__file__),"../Imprimir.png")
        ruta2 = os.path.join(os.path.dirname(__file__),"../ayuda.png")

        accion1 = QAction(QIcon(ruta1), "&Imprimir por consola", self)
        accion1.setShortcut(QKeySequence("ctrl+p"))
        accion1.setWhatsThis("Accion para imprimir")
        accion1.triggered.connect(self.imprimir_por_consola)

        accion2 = QAction(QIcon(ruta2),"&Qhe es esto?", self)
        accion2.setShortcut("ctrl+h")
        accion2.setWhatsThis("Accion de modo ayuda")
        accion2.triggered.connect(self.modo_ayuda)

        menu.addActions([accion1, accion2])

        barra_herramientas = QToolBar("Barra de ehrramientas")
        barra_herramientas.addActions([accion1,accion2])
        barra_herramientas.setToolButtonStyle(Qt.ToolButtonTextUnderIcon)

        self.addToolBar(barra_herramientas)

        self.dockText = QTextEdit()
        self.dock = QDockWidget("dock widget", self)
        self.dock.setWidget(self.dockText)
        self.dock.setWhatsThis("Dock donde imprimir")

        self.addDockWidget(Qt.TopDockWidgetArea, self.dock)

    def modo_ayuda(self):
        if QWhatsThis.inWhatsThisMode():
            QWhatsThis.leaveWhatsThisMode()
        else:
            QWhatsThis.enterWhatsThisMode()

    def imprimir_por_consola(self):
        self.dock.widget().append("hola que tal")

if __name__ == "__main__":
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()