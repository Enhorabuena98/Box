package cp4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class PersonajesSimpsons {
    // Atributos de la clase
    String nombre;
    int edad;
    String trabajo;
    String color;
    
    // Constructor de la clase
    public PersonajesSimpsons(Element personaje) {
    	this.nombre = personaje.getElementsByTagName("nombre").item(0).getTextContent();
    	this.edad = Integer.parseInt(personaje.getAttribute("Edad"));
        this.trabajo = personaje.getElementsByTagName("Trabajo").item(0).getTextContent();
        this.color = personaje.getElementsByTagName("ColorRopa").item(0).getTextContent();
    }
    
    // Método toString para representar el objeto
    @Override
    public String toString() {
        return "\n\t<Simpson>\n\t\t <nombre>" + nombre + "</nombre>\n\t\t <trabajo>" + trabajo + "</trabajo>\n\t\t <color>"
                + color + "</color>\n\t\t <edad>" + edad + "</edad>\n\t</Simpson>";
    }
    
    // Método para buscar un personaje por nombre
    public static PersonajesSimpsons buscar(ArrayList<PersonajesSimpsons> personajes, String nombreBuscado) {
        for (PersonajesSimpsons personaje : personajes) {
            if (personaje.nombre.equalsIgnoreCase(nombreBuscado)) {
                return personaje;
            }
        }
        return null;
    }

    // Método para añadir un nuevo personaje a la lista
    public static void añadir(ArrayList<PersonajesSimpsons> personajes, PersonajesSimpsons nuevoPersonaje) {
        personajes.add(nuevoPersonaje);
    }

    // Método para ordenar los personajes por edad
    public static void ordenar(ArrayList<PersonajesSimpsons> personajes) {
        Collections.sort(personajes, Comparator.comparingInt(p -> p.edad));
    }

    // Método para pedir un personaje por pantalla y mostrarlo
    public static void pedirYMostrar(ArrayList<PersonajesSimpsons> personajes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del personaje a buscar:");
        String nombreBuscado = scanner.nextLine();
        PersonajesSimpsons personajeEncontrado = buscar(personajes, nombreBuscado);
        if (personajeEncontrado != null) {
            System.out.println("Personaje encontrado: " + personajeEncontrado);
        } else {
            System.out.println("Personaje no encontrado.");
        }
    }

    // Método main modificado para pruebas
    public static void main(String[] args) {
        ArrayList<PersonajesSimpsons> personajes = new ArrayList<>();
        Document doc = abrirXML("simpsons.xml");
        NodeList nodolista = doc.getElementsByTagName("Simpson");
        for (int i = 0; i < nodolista.getLength(); i++) {
            Element personaje = (Element) nodolista.item(i);
            PersonajesSimpsons pb = new PersonajesSimpsons(personaje);
            personajes.add(pb);
        }
        
        // Llamada a los métodos implementados
        System.out.println("<Simpsons>");
        for (PersonajesSimpsons pb1 : personajes) {
            System.out.println("\t" + pb1);
        }
        System.out.println("</Simpsons>");
        
        // Ejemplo de búsqueda
        pedirYMostrar(personajes);

        // Ejemplo de ordenamiento
        ordenar(personajes);
        System.out.println("Personajes ordenados por edad:");
        for (PersonajesSimpsons pb : personajes) {
            System.out.println(pb);
        }
    }

    // Método para abrir el XML
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
