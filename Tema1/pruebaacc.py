from PySide6.QtWidgets import (QApplication,QMainWindow,
QWidget,QToolBar,QDockWidget,QTextEdit,QWhatsThis)
from PySide6.QtGui import QAction,QIcon,QKeySequence
from PySide6.QtCore import Qt
import os

class ventana(QMainWindow):
    def __init__(self):
        super().__init__()
class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Acciones")
        self.setGeometry(600,300,600,400)
#1 widget
        widget_principal = QWidget(self)
        self.setCentralWidget(widget_principal)
#2 menu
        barra_menu = self.menuBar()
        menu = barra_menu.addMenu("&Menu")
#3 rutas
        ruta1 = os.path.join(os.path.dirname(__file__),"../Imprimir.png")
        ruta2 = os.path.join(os.path.dirname(__file__),"../ayuda.png")
#4 accion1
        accion1 = QAction(QIcon(ruta1),"&Imprimir",self)
        accion1.setWhatsThis("Imprimir")
        accion1.setShortcut("ctrl+p")
        accion1.triggered.connect(self.imprimir_dock)
#5 accion2
        accion2 = QAction(QIcon(ruta2),"&Ayuda",self)
        accion2.setWhatsThis("Ayuda")
        accion2.setShortcut("ctrl+h")
        accion2.triggered.connect(self.modo_ayuda)
#6 añadir acciones
        menu.addActions([accion1,accion2])
#7 toolbar
        barra_herramientas = QToolBar("Barra de herramientas")
        barra_herramientas.addActions([accion1,accion2])
        barra_herramientas.setToolButtonStyle(Qt.ToolButtonTextUnderIcon)
#8 addtoolbar
        self.addToolBar(barra_herramientas)
#9 dock y textedit
        self.edittext = QTextEdit()
        self.dock = QDockWidget("Dock Widget", self)
        self.dock.setWidget(self.edittext)
        self.dock.setWhatsThis("Dock donde imprimir")
#10 adddockwidget
        self.addDockWidget(Qt.TopDockWidgetArea,self.dock)
# def1
    def modo_ayuda(self):
        if QWhatsThis.inWhatsThisMode():
            QWhatsThis.leaveWhatsThisMode()
        else:
            QWhatsThis.enterWhatsThisMode()
# def2
    def imprimir_dock(self):
        self.dock.widget().append("Hola que tal")
# main
if __name__=="__main__":
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()