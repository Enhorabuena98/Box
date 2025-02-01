package cp4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CasoPractico4 {

    public static void main(String[] args) {
        String[] modulos = { "Acceso a Datos", "Programación de servicios y procesos",
                "Desarrollo de interfaces", "Programación multimedia y dispositivos móviles",
                "Sistemas de gestión empresarial", "Empresa e iniciativa emprendedora", "FOL" };
        boolean[] permiteFCT = { false, true, false, false, true, true, false };
        int[] horas = { 6, 3, 6, 5, 5, 3, 5 };
        double[] notas = { 8.45, 9.0, 8.0, 7.34, 8.2, 7.4, 7 };

        Document document;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Element raiz = document.createElement("Curso");

            document.appendChild(raiz);

            for (int i = 0; i < notas.length; i++) {
                // creamos un elemento módulo y lo añadimos a la raíz
                Element modulo = document.createElement("modulo");
                raiz.appendChild(modulo);
                // añadimos los atributos, previa conversión a String
                modulo.setAttribute("horas", String.valueOf(horas[i]));
                modulo.setAttribute("permiteFct", String.valueOf(permiteFCT[i]));

                // añadimos el nombre del módulo
                Element nombre = document.createElement("nombre");
                nombre.appendChild(document.createTextNode(modulos[i]));
                modulo.appendChild(nombre);

                // añadimos la nota del módulo
                Element nota = document.createElement("nota");
                nota.appendChild(document.createTextNode(String.valueOf(notas[i])));
                modulo.appendChild(nota);

                System.out.println("Horas: " + horas[i] + " Permite FCT: " + permiteFCT[i] + " Módulo: " + modulos[i]
                        + " Nota: " + notas[i]);
            }

            // Preparamos el transformer para la conversión
            Transformer trans = TransformerFactory.newInstance().newTransformer();

            // Origen: el DOM del documento creado
            DOMSource source = new DOMSource(document);

            // Destino: un fichero XML
            StreamResult result = new StreamResult(new FileOutputStream("misModulos.xml"));
            // Conversión !!
            trans.transform(source, result);
            System.out.println("Hemos terminado el xml");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
