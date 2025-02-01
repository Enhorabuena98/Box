import os
from PySide6.QtWidgets import (
    QApplication, QMainWindow, QToolBar, QLineEdit, QLabel, QWhatsThis,
    QDockWidget, QTextEdit, QWidget, QColorDialog, QFileDialog, QFontDialog,
    QInputDialog, QMessageBox, QStatusBar
)
from PySide6.QtGui import QAction, QIcon, QKeySequence, QFont
from PySide6.QtCore import Qt
from PySide6.QtWebEngineWidgets import QWebEngineView

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setGeometry(270, 441, 1260, 370)
        self.setWindowTitle("Ventana principal con menús")
        
        widget_principal = QWidget(self)
        self.setCentralWidget(widget_principal)


        self.status_bar = QStatusBar()
        self.setStatusBar(self.status_bar)

        barra_menu = self.menuBar()
        menu_archivo = barra_menu.addMenu("&Archivo")
        menu_edicion = barra_menu.addMenu("&Edición")

        ruta_imagen1 = os.path.join(os.path.dirname(__file__), "ico1.png")
        ruta_imagen2 = os.path.join(os.path.dirname(__file__), "ico2.png")
        ruta_imagen3 = os.path.join(os.path.dirname(__file__), "ico3.png")
        ruta_imagen4 = os.path.join(os.path.dirname(__file__), "ico4.png")
        ruta_imagen5 = os.path.join(os.path.dirname(__file__), "ico5.png")
        ruta_imagen6 = os.path.join(os.path.dirname(__file__), "ico6.png")
        ruta_imagen7 = os.path.join(os.path.dirname(__file__), "ico7.png")
        ruta_imagen8 = os.path.join(os.path.dirname(__file__), "ico8.png")
        ruta_imagen9 = os.path.join(os.path.dirname(__file__), "ico9.png")
        ruta_imagen10 = os.path.join(os.path.dirname(__file__), "ico10.png")
        ruta_imagen11 = os.path.join(os.path.dirname(__file__), "ico11.png")
        ruta_imagen12 = os.path.join(os.path.dirname(__file__), "ico12.png")
        ruta_imagen13 = os.path.join(os.path.dirname(__file__), "ico13.png")
        ruta_imagen14 = os.path.join(os.path.dirname(__file__), "ico14.png")
        ruta_imagen15 = os.path.join(os.path.dirname(__file__), "ico15.png")
        ruta_imagen16 = os.path.join(os.path.dirname(__file__), "ico16.png")
        ruta_imagen17 = os.path.join(os.path.dirname(__file__), "ico17.png")




        accion1 = self.crear_accion(ruta_imagen1, "&Nuevo Block", "ctrl+n", "Acción para abrir un block", self.nuevo_block)
        accion2 = self.crear_accion(ruta_imagen2, "&Abrir Archivo", "ctrl+a", "Acción para abrir un archivo", self.abrir_archivo)
        accion3 = self.crear_accion(ruta_imagen3, "&Guardar Archivo", "ctrl+s", "Acción para guardar el archivo", self.guardar_archivo)
        accion4 = self.crear_accion(ruta_imagen4, "&Deshacer", "ctrl+z", "Acción para deshacer", self.deshacer)
        accion5 = self.crear_accion(ruta_imagen5, "&Rehacer", "ctrl+r", "Acción para rehacer", self.rehacer)
        accion6 = self.crear_accion(ruta_imagen6, "&Cortar", "ctrl+x", "Acción para cortar", self.cortar)
        accion7 = self.crear_accion(ruta_imagen7, "&Copiar", "ctrl+c", "Acción para copiar", self.copiar)
        accion8 = self.crear_accion(ruta_imagen8, "&Pegar", "ctrl+v", "Acción para pegar", self.pegar)
        accion9 = self.crear_accion(ruta_imagen9, "&Buscar", "ctrl+f", "Acción para buscar", self.buscar)
        accion10 = self.crear_accion(ruta_imagen10, "&Reemplazar", "ctrl+p", "Acción para reemplazar", self.reemplazar)
        accion11 = self.crear_accion(ruta_imagen11, "&Color del Bloc", "ctrl+o", "Acción para cambiar el color del block", self.cambiar_color)
        accion12 = self.crear_accion(ruta_imagen12, "&Ayuda", "ctrl+h", "Acción de ayuda", self.mostrar_ayuda)
        accion13 = self.crear_accion(ruta_imagen13, "&Salir", "ctrl+e", "Acción de salir", self.cerrar_aplicacion)
        accion14 = self.crear_accion(ruta_imagen14, "&Cambiar Tipo de Letra", "ctrl+t", "Cambiar fuente de letra", self.cambiar_fuente)

        acciongpt = self.crear_accion(ruta_imagen15, "&Chatgpt", "ctrl+k", "Abre chatgpt", self.abrir_chatgpt)
        accionlofi = self.crear_accion(ruta_imagen16, "&Lofi", "ctrl+l", "Abre Lofi", self.abrir_lofi)
        accionriver = self.crear_accion(ruta_imagen17, "&River", "ctrl+j", "Abre River", self.abrir_river)




        menu_archivo.addActions([accion1,accion2, accion3, accion12, acciongpt, accionlofi, accionriver, accion13])
        menu_edicion.addActions([accion4,accion5,accion6,accion7,accion8,accion9,accion10,accion11,accion14])

        barra_herramientas = QToolBar("Barra de herramientas")
        barra_herramientas.addActions([accion1,accion2, accion3,accion4,accion5,accion6,accion7,accion8,accion9,
                                    accion10,accion11, accion14, accion12, acciongpt, accionlofi, accionriver, accion13])
        barra_herramientas.setToolButtonStyle(Qt.ToolButtonTextUnderIcon)
        self.addToolBar(barra_herramientas)

        self.dockText = QTextEdit()
        self.dock = QDockWidget("Dock de salida", self)
        self.dock.setWidget(self.dockText)
        self.addDockWidget(Qt.TopDockWidgetArea, self.dock)

        self.dockText.textChanged.connect(self.contar_palabras)
        self.contador_palabras_label = QLabel("Palabras: 0")
        self.status_bar.addPermanentWidget(self.contador_palabras_label)

    def crear_accion(self, ruta_icono, texto, atajo, whatsthis, funcion):
        accion = QAction(QIcon(ruta_icono), texto, self)
        accion.setShortcut(QKeySequence(atajo))
        accion.setWhatsThis(whatsthis)
        accion.triggered.connect(funcion)
        return accion

    def contar_palabras(self):
        texto = self.dock.widget().toPlainText()
        palabras = [palabra for palabra in texto.split() if palabra]
        numero_palabras = len(palabras)
        self.contador_palabras_label.setText(f"Palabras: {numero_palabras}")

    def nuevo_block(self):
        self.dock.widget().clear()
        self.dock.widget().append("Nuevo block creado.")
        self.status_bar.showMessage("Nuevo block creado.", 3000)
        self.contar_palabras()

    def abrir_archivo(self):
        file_name, _ = QFileDialog.getOpenFileName(self, "Abrir archivo", "", "Archivos de texto (*.txt)")
        if file_name:
            with open(file_name, 'r') as f:
                contenido = f.read()
            self.dock.widget().setText(contenido)
            self.status_bar.showMessage(f"Archivo '{file_name}' abierto.", 3000)
            self.contar_palabras()

    def guardar_archivo(self):
        file_name, _ = QFileDialog.getSaveFileName(self, "Guardar archivo", "", "Archivos de texto (*.txt)")
        if file_name:
            with open(file_name, 'w') as f:
                f.write(self.dock.widget().toPlainText())
            self.status_bar.showMessage(f"Archivo guardado como '{file_name}'.", 3000)

    def deshacer(self):
        self.dock.widget().undo()
        self.status_bar.showMessage("Deshacer realizado.", 3000)
        self.contar_palabras()

    def rehacer(self):
        self.dock.widget().redo()
        self.status_bar.showMessage("Rehacer realizado.", 3000)
        self.contar_palabras()

    def cortar(self):
        self.dock.widget().cut()
        self.status_bar.showMessage("Texto cortado.", 3000)
        self.contar_palabras()

    def copiar(self):
        self.dock.widget().copy()
        self.status_bar.showMessage("Texto copiado.", 3000)

    def pegar(self):
        self.dock.widget().paste()
        self.status_bar.showMessage("Texto pegado.", 3000)
        self.contar_palabras()

    def buscar(self):
        buscar_texto, ok = QInputDialog.getText(self, "Buscar", "Introduce el texto a buscar:")
        if ok and buscar_texto:
            cursor = self.dock.widget().textCursor()
            cursor.setPosition(0)
            self.dock.widget().setTextCursor(cursor)
            encontrado = self.dock.widget().find(buscar_texto)
            if encontrado:
                self.status_bar.showMessage(f"'{buscar_texto}' encontrado.", 3000)
            else:
                self.status_bar.showMessage(f"'{buscar_texto}' no encontrado.", 3000)
                
    def reemplazar(self):
        buscar_texto, ok1 = QInputDialog.getText(self, "Reemplazar", "Texto a buscar:")
        if ok1 and buscar_texto:
            reemplazar_texto, ok2 = QInputDialog.getText(self, "Reemplazar", "Reemplazar por:")
            if ok2 and reemplazar_texto:
                texto_completo = self.dock.widget().toPlainText()
                if buscar_texto in texto_completo:
                    nuevo_texto = texto_completo.replace(buscar_texto, reemplazar_texto)
                    self.dock.widget().setText(nuevo_texto)
                    self.status_bar.showMessage(f"'{buscar_texto}' ha sido reemplazado por '{reemplazar_texto}'.", 3000)
                else:
                    self.status_bar.showMessage(f"'{buscar_texto}' no encontrado.", 3000)
                    self.contar_palabras()

    def cambiar_color(self):
        color = QColorDialog.getColor()
        if color.isValid():
            self.dock.widget().setStyleSheet(f"background-color: {color.name()}")
            self.status_bar.showMessage(f"Color del block cambiado a {color.name()}.", 3000)

    def cambiar_fuente(self):
        ok, fuente = QFontDialog.getFont(self.dock.widget().font(), self)
        if ok:
            if isinstance(fuente, QFont):
                self.dock.widget().setFont(fuente)
                self.status_bar.showMessage(f"Tipo de letra cambiado a {fuente.family()}.", 3000)
            else:
                self.status_bar.showMessage("Selección de fuente no válida.", 3000)
        else:
            self.status_bar.showMessage("Selección de fuente cancelada.", 3000)

    def mostrar_ayuda(self):
        if QWhatsThis.inWhatsThisMode():
            QWhatsThis.leaveWhatsThisMode()
        else:
            QWhatsThis.enterWhatsThisMode()
    
    def cerrar_aplicacion(self):
        QApplication.quit()

    def abrir_chatgpt(self):
        url_chatgpt = "https://chat.openai.com/"
        self.web_view_chatgpt = QWebEngineView()
        self.web_view_chatgpt.setUrl(url_chatgpt)
        self.web_view_chatgpt.setWindowTitle("ChatGPT")
        self.web_view_chatgpt.setGeometry(270, 30, 1260, 380)
        self.web_view_chatgpt.show()
    
    def abrir_lofi(self):
        url_lofi = "https://www.247lofiradio.com/"
        self.web_view_lofi = QWebEngineView()
        self.web_view_lofi.setUrl(url_lofi)
        self.web_view_lofi.setWindowTitle("Lofi")
        self.web_view_lofi.setGeometry(0, 0, 260, 780)
        self.web_view_lofi.show()
        
    def abrir_river(self):
        url_river = "https://www.riverbankcomputing.com/static/Docs/PyQt6/api/qtwebenginewidgets/qwebengineview.html#QWebEngineView"
        self.web_view_river = QWebEngineView()
        self.web_view_river.setUrl(url_river)
        self.web_view_river.setWindowTitle("River")
        self.web_view_river.setGeometry(270, 30, 1260, 380)
        self.web_view_river.show()
        
if __name__ == "__main__":
    app = QApplication([])
    ventana1 = VentanaPrincipal()
    ventana1.show()
    app.exec()
