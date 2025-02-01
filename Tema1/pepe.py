from PySide6.QtWidgets import QMainWindow,QToolBar,QDockWidget,QApplication,QTextEdit,QPushButton,QWhatsThis
from PySide6.QtGui import QAction,QKeySequence,QIcon
from PySide6.QtCore import Qt

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.statusBar().showMessage("Listo")

        self.setWindowTitle("Ventana principal con menu")
        self.resize(800,600)
                
        self.favicon = QIcon(r"C:\Users\ppsot\OneDrive\Escritorio\ventana.png")
        self.setWindowIcon(self.favicon)

        barraMenus = self.menuBar()
        menu = barraMenus.addMenu("&Menu")        

        barraHerramientas = QToolBar("Barra de Herramientas")
        self.addToolBar(barraHerramientas) 

        accionImprimir = QAction(QIcon(r"C:\Users\ppsot\OneDrive\Escritorio\impresora1.png"),"&Imprimir por consola", self)
        accionImprimir.setStatusTip("Al ejecutar esta accion, se añadira el texto 'Accion Pulsada' en el dock")
        accionImprimir.setShortcut(QKeySequence("Ctrl+p"))
        accionImprimir.triggered.connect(self.imprimirEnDock)

        accionAyuda = QAction(QIcon(r"C:\Users\ppsot\OneDrive\Escritorio\ayuda.png"),"&¿Qué es esto?",self)
        accionAyuda.setStatusTip("Haz clic para activar/desactivar el modo ¿Qué es esto?")
        accionAyuda.setShortcut(QKeySequence("Ctrl+a"))
        accionAyuda.triggered.connect(self.activarModoAyuda)

        menu.addAction(accionImprimir)        
        barraHerramientas.addAction(accionImprimir)      

        menu.addAction(accionAyuda)
        barraHerramientas.addAction(accionAyuda)

        self.dockText = QTextEdit()        
        
        self.dock = QDockWidget("dock widget", self)
        self.dock.setWidget(self.dockText)
        self.addDockWidget(Qt.TopDockWidgetArea, self.dock)

        barraHerramientas.setToolButtonStyle(Qt.ToolButtonTextUnderIcon) 

        #a cada acccion asignar con setwahtsthis la informacion que ofrecemos al usuario

        
    def imprimirPorConsola(self):
        print("Accion pulsada")

    
    def activarModoAyuda(self):
        if QWhatsThis.inWhatsThisMode():
            QWhatsThis.leaveWhatsThisMode()
        else:
            QWhatsThis.enterWhatsThisMode() 


    def imprimirEnDock(self):
        self.dock.widget().append("holaaaaaaaa")
        #self.dockText.append("Acción pulsada")           


if __name__ == "__main__":
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()