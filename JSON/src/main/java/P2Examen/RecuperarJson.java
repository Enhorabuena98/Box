package P2Examen;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class RecuperarJson {

	public static ArrayList<Personajes> recuperarLista(String archivo) {
		ArrayList<Personajes> lista = new ArrayList<Personajes>();
		try (FileReader fr = new FileReader(archivo)) {
			StringBuilder myJson = new StringBuilder();
			
			int i;
			while ((i = fr.read())!= -1) {
				myJson.append((char) i);
				
			}
			JSONObject personajes = new JSONObject(myJson.toString());
			JSONArray personajesArray = personajes.getJSONArray("Ricky");
			for (int j = 0; j < personajesArray.length(); j++) {
				JSONObject personajesObjeto = personajesArray.getJSONObject(j);
				Personajes richymorti = new Personajes(personajesObjeto);
				lista.add(richymorti);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	public static void main(String[] args) {

		ArrayList<Personajes> lista = recuperarLista("morthy.json");
		Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Mostrar todos los personajes");
            System.out.println("2. Filtrar por nombre");
            System.out.println("3. Ordenar por edad");
            System.out.println("4. Ordenar por nombre");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Lista de Personajes ---");
                    for (Personajes p : lista) {
                        System.out.println(p);
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombreFiltro = scanner.nextLine();
                    System.out.println("\n--- Personajes Filtrados ---");
                    for (Personajes p : lista) {
                        if (p.getNombre().equalsIgnoreCase(nombreFiltro)) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- Lista Ordenada por Edad ---");
                    lista.sort(Comparator.comparingInt(Personajes::getEdad));
                    for (Personajes p : lista) {
                        System.out.println(p);
                    }
                    break;

                case 4:
                    System.out.println("\n--- Lista Ordenada por Nombre ---");
                    lista.sort(Comparator.comparing(Personajes::getNombre));
                    for (Personajes p : lista) {
                        System.out.println(p);
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 5);

        scanner.close();
    }
	}


