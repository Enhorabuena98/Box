package EntregableHilos;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import EntregableHilos.BusquedaElementoArray;
import EntregableHilos.CalculadoraFactorial;
import EntregableHilos.ProductorConsumidor;

public class MainConMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Buscar un elemento en un array (Ejercicio 1)");
            System.out.println("2. Productor-Consumidor (Ejercicio 2)");
            System.out.println("3. Calcular factorial (Ejercicio 3)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion;
            try {
                opcion = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); 
                continue;
            }

            switch (opcion) {
                case 1:
                    ejecutarBusquedaArray();
                    break;
                case 2:
                    ejecutarProductorConsumidor();
                    break;
                case 3:
                    ejecutarCalculoFactorial();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void ejecutarBusquedaArray() {
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i; 
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el elemento a buscar: ");
        int elemento;

        try {
            elemento = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Entrada no válida. Debe ingresar un número entero.");
            return;
        }

        boolean encontrado;
        try {
            encontrado = BusquedaElementoArray.buscarElemento(array, elemento);
            if (encontrado) {
                System.out.println("El elemento " + elemento + " fue encontrado en el array.");
            } else {
                System.out.println("El elemento " + elemento + " no está en el array.");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void ejecutarProductorConsumidor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor inicial del rango: ");
        int rangoMin = scanner.nextInt();

        System.out.print("Ingrese el valor final del rango: ");
        int rangoMax = scanner.nextInt();

        System.out.println("Ejecutando Productor-Consumidor con rango [" + rangoMin + ", " + rangoMax + "]...");

        Thread hiloProductorConsumidor = new Thread(() -> {
            ProductorConsumidor.main(new String[]{String.valueOf(rangoMin), String.valueOf(rangoMax)});
        });

        hiloProductorConsumidor.start();

        try {
            hiloProductorConsumidor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    private static void ejecutarCalculoFactorial() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número para calcular su factorial: ");
        int numero;

        try {
            numero = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Entrada no válida. Debe ingresar un número entero.");
            return;
        }

        if (numero < 0) {
            System.out.println("El factorial no está definido para números negativos.");
            return;
        }

        // Uso de la clase CalculadoraFactorial
        BigInteger resultado;
        try {
            resultado = CalculadoraFactorial.calcularFactorial(numero);
            System.out.println("El factorial de " + numero + " es: " + resultado);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
