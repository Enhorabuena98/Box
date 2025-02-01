package cp4;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import primerproceso.primerProceso;

public class PersonajesBralStars {
	String nombre;
	Double poder;
	String habilidad;
	int edad;
	
	public PersonajesBralStars(Element personaje) {
		this.nombre = personaje.getElementsByTagName("Nombre").item(0).getTextContent();
		this.poder = Double.parseDouble(personaje.getElementsByTagName("Poder").item(0).getTextContent());
		this.habilidad = personaje.getElementsByTagName("Habilidades").item(0).getTextContent();
		this.edad = Integer.parseInt(personaje.getAttribute("edad"));
	}

	@Override
	public String toString() {
		return "\n\t<Brawler>\n\t\t <nombre>" + nombre + "</nombre>\n\t\t <poder>" + poder + "</poder>\n\t\t <habilidad>"
				+ habilidad + "</habilidad>\n\t\t <edad>"
				+ edad + "</edad>\n\t</Brawler>";
	}
	
	public static void main(String[] args) {
		ArrayList<PersonajesBralStars> personajes = new ArrayList<>();
		Document doc = abrirXML("BrawlStars.xml");
		NodeList nodolista = doc.getElementsByTagName("Brawler");
		for (int i = 0; i < nodolista.getLength(); i++) {
			Element personaje = (Element) nodolista.item(i);
			PersonajesBralStars pb = new PersonajesBralStars(personaje);
			personajes.add(pb);
		
		}
		
		System.out.println("<Personajes>");
		for (PersonajesBralStars pb1 : personajes) {
			System.out.println("\t"+pb1);
		}
		System.out.println("</Personajes>");

	}
	private static Document abrirXML(String archivo) {
		try {	
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newNSInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document documento = db.parse(archivo);
		documento.getDocumentElement().normalize();
		
		return documento;
		
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
