package cp4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ExPersonajesSimpsons {
	
	String nombre;
	int edad;
	String trabajo;
	String color;
	
	public ExPersonajesSimpsons(Element personaje) {
		this.nombre = personaje.getElementsByTagName("Nombre").item(0).getTextContent();
		this.edad = Integer.parseInt(personaje.getAttribute("Edad"));
		this.trabajo = personaje.getElementsByTagName("Trabajo").item(0).getTextContent();;
		this.color = personaje.getElementsByTagName("ColorRopa").item(0).getTextContent();;
	}

	@Override
	public String toString() {
		return "\n\t<Simpson>\n\t\t <nombre>" + nombre + "</nombre>\n\t\t <trabajo>" + trabajo + "</trabajo>\n\t\t <color>"
                + color + "</color>\n\t\t <edad>" + edad + "</edad>\n\t</Simpson>";
	}
//	public static ExPersonajesSimpsons buscar(ArrayList<ExPersonajesSimpsons>personajes,String nombreBuscado) {
//		for (ExPersonajesSimpsons personaje : personajes) {
//			if (personaje.nombre.equalsIgnoreCase(nombreBuscado)) {
//				return personaje;
//			}
//		}
//		return null;
//	}
//	public static void añadir(ArrayList<ExPersonajesSimpsons>personajes,ExPersonajesSimpsons nuevoPersonaje) {
//		personajes.add(nuevoPersonaje);
//	}
//	public static void ordenar (ArrayList<ExPersonajesSimpsons>personajes) {
//		Collections.sort(personajes, Comparator.comparingInt(p -> p.edad));
//	}
	public static void ordenar (ArrayList<ExPersonajesSimpsons>personajes) {
		Collections.sort(personajes, Comparator.comparingInt(p -> p.edad));
	}
//	public static void pedirYMostrar(ArrayList<ExPersonajesSimpsons>personajes) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Ingrese el nombre a buscar:");
//		String nombreBuscado = sc.nextLine();
//		ExPersonajesSimpsons personajeEncontrado = buscar(personajes, nombreBuscado);
//		if (personajeEncontrado!=null) {
//			System.out.println("Aquitah:"+personajeEncontrado);
//		} else {
//			System.out.println("Notah");
//		}
//	}
	public static void main(String[] args) {
//		array vacio
		ArrayList<ExPersonajesSimpsons>personajes = new ArrayList<>();
//		usar el abrirxml en un document doc
		Document doc = abrirXML("simpsons2.xml");
//		var para recorrer
		NodeList nodolista = doc.getElementsByTagName("Simpson");
//      recorrer
		for (int i = 0; i < nodolista.getLength(); i++) {
//			1element con cast del nodolista.item 2guardarlo en pb 3 add
			Element personaje = (Element) nodolista.item(i);
			ExPersonajesSimpsons pb = new ExPersonajesSimpsons(personaje);
			personajes.add(pb);
		}
//		mostrar
		System.out.println("<Simpsons>");
		for (ExPersonajesSimpsons pb1 : personajes) {
			System.out.println("\t" + pb1);
		}
		System.out.println("</Simpsons>");
		
//		ordenar(personajes);
//		System.out.println("Personajes Ordenados: ");
//		for (ExPersonajesSimpsons pb2 : personajes) {
//			System.out.println(pb2);
//		}
//		pedirYMostrar(personajes);

	}

	private static Document abrirXML(String archivo) {
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document documento = db.parse(archivo);
			documento.getDocumentElement().normalize();
			return documento;
		} catch (Exception e) {
		System.out.println(e);
		}
		return null;
	}

}
