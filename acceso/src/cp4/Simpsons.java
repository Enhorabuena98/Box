package cp4;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Simpsons {

	public static void main(String[] args) {

		String[] personajes = {"Homer Simpson", "Marge Simpson", "Bart Simpson", "Lisa Simpson", "Maggie Simpson", "Apu Nahasapeemapetilon", "Moe Szyslak"};
        int[] edades = {38, 36, 10, 8, 1, 45, 50};
        String[] trabajos = {"Inspector de Seguridad Nuclear", "Ama de Casa", "Estudiante", "Estudiante", "Bebé", "Dueño de Kwik-E-Mart", "Dueño de la Taberna de Moe"};
        String[] coloresRopa = {"Blanco", "Azul", "Naranja", "Rojo", "Magenta", "Verde", "Blanco"};
	
        Document documento;
        try {
//        	doc 4.
			documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
//			element raiz
			Element raiz = documento.createElement("Simpsons");
//			asociar raiz
			documento.appendChild(raiz);
//			asociar los nodos valueof/appendchildcreatetextnode
			for (int i = 0; i < coloresRopa.length; i++) {
				Element simpson = documento.createElement("Simpson");
				simpson.setAttribute("Edad", String.valueOf(edades[i]));
				raiz.appendChild(simpson);
				
				Element nombre = documento.createElement("Nombre");
				nombre.appendChild(documento.createTextNode(personajes[i]));
				simpson.appendChild(nombre);
				
				Element trabajo = documento.createElement("Trabajo");
				trabajo.appendChild(documento.createTextNode(trabajos[i]));
				simpson.appendChild(trabajo);
				
				Element color = documento.createElement("ColorRopa");
				color.appendChild(documento.createTextNode(coloresRopa[i]));
				simpson.appendChild(color);
			}
			
			Transformer trans = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(documento);
			StreamResult resultado = new StreamResult(new FileOutputStream("simpsons.xml"));
			trans.transform(source, resultado);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
