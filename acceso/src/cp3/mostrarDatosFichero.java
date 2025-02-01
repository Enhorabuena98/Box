package cp3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class mostrarDatosFichero {

private final static String nombrefichero ="Alumno.dat";
	
	public static void main(String[] args) {
		
	    ArrayList<Alumnos> alumnosLista = new ArrayList<>();

	 String mensajeNombre = "Nombre del alumno: ";
	    // Pedir datos del alumno al usuario
	    String nombre = obtenerInput(mensajeNombre);
	    int edad = Integer.parseInt(obtenerInput("Edad del alumno: "));
	    String ciclo = obtenerInput("Ciclo del alumno: ");
	    double nota = Double.parseDouble(obtenerInput("Nota del alumno: "));

	    // Crear el objeto Alumno
	    Alumnos alumno = new Alumnos(nombre, edad, ciclo, nota);

	    // Agregar el nuevo alumno a la lista
	    alumnosLista.add(alumno);

	    // Guardar la lista de alumnos en el archivo
	   guardarAlumnosEnArchivoBinario(alumnosLista, nombrefichero);
	 
	
	    // Mostrar la lista de alumnos
	   mostrarfichero();
		
	}

	
	// Método para obtener entrada del usuario

	private static String obtenerInput(String mensaje) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	//utiliza DataOutputStream para guardar los campos individuales de cada objeto Alumnos en un archivo, 
	//y cada campo se almacena por separado en un formato binario. 
	public static void guardarAlumnosEnArchivoBinario(ArrayList<Alumnos> listaAlumnos, String nombreArchivo) {
		//true hace que se añadan los alumnos al final del fichero
	    try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(nombreArchivo, true))) {
	        for (Alumnos alumno : listaAlumnos) {
	            dos.writeUTF(alumno.getNombre());
	            dos.writeInt(alumno.getEdad());
	            dos.writeUTF(alumno.getCiclo());
	            dos.writeDouble(alumno.getNota());
	        }
	        System.out.println("Alumnos guardados en " + nombreArchivo);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	// Método para leer un objeto Alumno desde un archivo binario
	
	
public static void mostrarfichero() {
	DataInputStream dis = null;
	try {
		
			dis = new DataInputStream(new FileInputStream(nombrefichero));
		
	while(dis.available()>0) {
		 try {
		System.out.println("\nmostar fichero\n");
		System.out.println("Nombre: "+ dis.readUTF());
		System.out.println("Edad: "+dis.readInt());
		System.out.println("Ciclo: "+dis.readUTF());
		System.out.println("Nota: "+dis.readDouble());
		
	 } catch (EOFException e) {
         // Se alcanzó el final del archivo, salir del bucle
         break;
     }
	}
	dis.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	

}


}
