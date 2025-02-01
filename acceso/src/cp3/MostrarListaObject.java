package cp3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MostrarListaObject {

    // Nombre del fichero donde se almacenarán los objetos de tipo "Alumnos"
    private final static String nombreFicheroObjeto = "AlumnoListaObjeto.dat";

    public static void main(String[] args) {
        // Lista para almacenar los objetos de tipo "Alumnos"
        ArrayList<Alumnos> alumnosLista = new ArrayList<>();

        // Leer los alumnos previamente guardados en el archivo (si existen)
        alumnosLista = leerAlumnosDesdeArchivo(nombreFicheroObjeto);

        // Obtener los datos del nuevo alumno del usuario
        String nombre = obtenerInput("Nombre del alumno: ");
        int edad = Integer.parseInt(obtenerInput("Edad del alumno: "));
        String ciclo = obtenerInput("Ciclo del alumno: ");
        double nota = Double.parseDouble(obtenerInput("Nota del alumno: "));

        // Crear un nuevo objeto "Alumno" con los datos proporcionados
        Alumnos alumno = new Alumnos(nombre, edad, ciclo, nota);

        // Agregar el nuevo alumno a la lista
        alumnosLista.add(alumno);

        // Guardar la lista de alumnos en el archivo
        guardarAlumnosEnArchivo(alumnosLista, nombreFicheroObjeto);

        // Mostrar el contenido del archivo con todos los alumnos guardados
        mostrarContenido(nombreFicheroObjeto);
    }

    /**
     * Método para leer una lista de alumnos desde un archivo.
     * @param nombreArchivo El nombre del archivo desde el cual se leerá la lista de alumnos.
     * @return Una lista de alumnos leída desde el archivo.
     */
    public static ArrayList<Alumnos> leerAlumnosDesdeArchivo(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            // Leer y devolver la lista de alumnos desde el archivo
            return (ArrayList<Alumnos>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // En caso de error, imprimir el stacktrace y devolver una lista vacía
            e.printStackTrace();
            return new ArrayList<Alumnos>();
        }
    }

    /**
     * Método para obtener una entrada del usuario.
     * @param mensaje El mensaje que se mostrará al usuario.
     * @return La entrada del usuario como un String.
     */
    private static String obtenerInput(String mensaje) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(mensaje);
        try {
            return reader.readLine();
        } catch (IOException e) {
            // En caso de error, imprimir el stacktrace y devolver una cadena vacía
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Método para guardar la lista de alumnos en un archivo.
     * @param listaAlumnos La lista de alumnos que se guardará.
     * @param nombreArchivo El nombre del archivo donde se guardará la lista.
     */
    public static void guardarAlumnosEnArchivo(ArrayList<Alumnos> listaAlumnos, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            // Escribir la lista de alumnos en el archivo
            oos.writeObject(listaAlumnos);
            System.out.println("Alumnos guardados en " + nombreArchivo);
        } catch (IOException e) {
            // En caso de error, imprimir el stacktrace
            e.printStackTrace();
        }
    }

    /**
     * Método para mostrar el contenido del archivo de alumnos.
     * @param nombreArchivo El nombre del archivo que contiene la lista de alumnos.
     */
    public static void mostrarContenido(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            // Leer la lista de alumnos del archivo
            ArrayList<Alumnos> listaAlumnos = (ArrayList<Alumnos>) ois.readObject();
            // Mostrar cada alumno de la lista
            for (Alumnos alumno : listaAlumnos) {
                System.out.println(alumno);
            }
        } catch (IOException | ClassNotFoundException e) {
            // En caso de error, imprimir el stacktrace
            e.printStackTrace();
        }
    }
}
