package Tarea1;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class PokemonObject {

    private final static String nombreFicheroObjeto = "PokemonListaObjeto.dat";

    public static void main(String[] args) {
        ArrayList<Pokemon> pokemonLista = new ArrayList<>();

        pokemonLista = leerPokemonsDesdeArchivo(nombreFicheroObjeto);

        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\nElige una opción:");
            System.out.println("1. Agregar Pokémon");
            System.out.println("2. Ordenar Pokémon por nivel");
            System.out.println("3. Ordenar Pokémon por nombre");
            System.out.println("4. Buscar Pokémon por tipo");
            System.out.println("5. Mostrar Pokémon con nivel mayor a un valor");
            System.out.println("6. Eliminar Pokémon por nombre");
            System.out.println("7. Mostrar Pokémon con más puntos de vida");
            System.out.println("8. Mostrar todos los Pokémon");
            System.out.println("9. Salir");

            opcion = Integer.parseInt(obtenerInput("Opción: "));

            switch (opcion) {
                case 1:
                    agregarPokemon(pokemonLista);
                    guardarPokemonsEnArchivo(pokemonLista, nombreFicheroObjeto);
                    break;
                case 2:
                    ordenarPorNivel(pokemonLista);
                    break;
                case 3:
                    ordenarPorNombre(pokemonLista);
                    break;
                case 4:
                    String tipo = obtenerInput("Introduce el tipo de Pokémon a buscar: ");
                    buscarPorTipo(pokemonLista, tipo);
                    break;
                case 5:
                    int nivelMinimo = Integer.parseInt(obtenerInput("Introduce el nivel mínimo: "));
                    mostrarPokemonConNivelMayor(pokemonLista, nivelMinimo);
                    break;
                case 6:
                    String nombrePokemon = obtenerInput("Introduce el nombre del Pokémon a eliminar: ");
                    eliminarPokemonPorNombre(pokemonLista, nombrePokemon);
                    guardarPokemonsEnArchivo(pokemonLista, nombreFicheroObjeto);
                    break;
                case 7:
                    mostrarPokemonConMasPuntosDeVida(pokemonLista);
                    break;
                case 8:
                    mostrarLista(pokemonLista);
                    break;
                case 9:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } while (opcion != 9);

        sc.close();
    }

    public static void agregarPokemon(ArrayList<Pokemon> pokemonLista) {
        String nombre = obtenerInput("Nombre del Pokémon: ");
        String tipo = obtenerInput("Tipo del Pokémon: ");
        int nivel = Integer.parseInt(obtenerInput("Nivel del Pokémon: "));
        double puntosDeVida = Double.parseDouble(obtenerInput("Puntos de Vida del Pokémon: "));

        Pokemon pokemon = new Pokemon(nombre, tipo, nivel, puntosDeVida);
        pokemonLista.add(pokemon);
        System.out.println("Pokémon agregado exitosamente.");
    }

    public static void ordenarPorNivel(ArrayList<Pokemon> listaPokemon) {
        listaPokemon.sort(Comparator.comparingInt(Pokemon::getNivel));
        System.out.println("Pokémon ordenados por nivel:");
        mostrarLista(listaPokemon);
    }

    public static void ordenarPorNombre(ArrayList<Pokemon> listaPokemon) {
        listaPokemon.sort(Comparator.comparing(Pokemon::getNombre));
        System.out.println("Pokémon ordenados por nombre:");
        mostrarLista(listaPokemon);
    }

    // Método 4: Buscar Pokémon por tipo
    public static void buscarPorTipo(ArrayList<Pokemon> listaPokemon, String tipo) {
        System.out.println("Pokémon de tipo " + tipo + ":");
        for (Pokemon pokemon : listaPokemon) {
            if (pokemon.getTipo().equalsIgnoreCase(tipo)) {
                System.out.println(pokemon);
            }
        }
    }

    public static void mostrarPokemonConNivelMayor(ArrayList<Pokemon> listaPokemon, int nivelMinimo) {
        System.out.println("Pokémon con nivel mayor a " + nivelMinimo + ":");
        for (Pokemon pokemon : listaPokemon) {
            if (pokemon.getNivel() > nivelMinimo) {
                System.out.println(pokemon);
            }
        }
    }

    public static void eliminarPokemonPorNombre(ArrayList<Pokemon> listaPokemon, String nombre) {
        boolean encontrado = false;
        for (int i = 0; i < listaPokemon.size(); i++) {
            if (listaPokemon.get(i).getNombre().equalsIgnoreCase(nombre)) {
                listaPokemon.remove(i);
                encontrado = true;
                System.out.println("Pokémon " + nombre + " eliminado.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Pokémon con nombre " + nombre + " no encontrado.");
        }
    }

    public static void mostrarPokemonConMasPuntosDeVida(ArrayList<Pokemon> listaPokemon) {
        if (!listaPokemon.isEmpty()) {
            Pokemon maxPuntosDeVida = listaPokemon.stream().max(Comparator.comparingDouble(Pokemon::getPuntosDeVida)).orElse(null);
            System.out.println("El Pokémon con más puntos de vida es:");
            System.out.println(maxPuntosDeVida);
        } else {
            System.out.println("No hay Pokémon en la lista.");
        }
    }

    public static void mostrarLista(ArrayList<Pokemon> listaPokemon) {
        if (listaPokemon.isEmpty()) {
            System.out.println("La lista de Pokémon está vacía.");
        } else {
            for (Pokemon pokemon : listaPokemon) {
                System.out.println(pokemon);
            }
        }
    }

    public static ArrayList<Pokemon> leerPokemonsDesdeArchivo(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (ArrayList<Pokemon>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void guardarPokemonsEnArchivo(ArrayList<Pokemon> listaPokemon, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(listaPokemon);
            System.out.println("Pokémon guardados en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
}
