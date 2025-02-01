package PracExPSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Sumatorio {

    private static BufferedReader lanzarSubproceso(long sum1, long sum2) {
        // Definimos el ProcessBuilder para lanzar la clase Suma
        ProcessBuilder pb = new ProcessBuilder("java", "C:\\Users\\DELL\\eclipse-workspace\\Tema1PSP\\src\\Apartado5\\Suma.java", Long.toString(sum1), Long.toString(sum2));

        try {
            // Lanzamos el proceso
            Process p = pb.start();

            // Recogemos la salida y la devolvemos
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            p.getInputStream()));

            return br;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        // Si no se proporcionan dos argumentos, cerramos la aplicación
        if (args.length != 2)
            System.exit(-1);

        Long num1, num2;
        Long suma = 0L;

        // Ponemos el menor número delante
        if (Long.parseLong(args[0]) > Long.parseLong(args[1])) {
            num1 = Long.parseLong(args[1]);
            num2 = Long.parseLong(args[0]);
        } else {
            num1 = Long.parseLong(args[0]);
            num2 = Long.parseLong(args[1]);
        }

        // Preguntamos al usuario si desea ejecutar en secuencial o paralelo
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Desea ejecutar la suma en modo secuencial o paralelo? (S/P): ");
        String modo = sc.nextLine().toUpperCase();

        // Modo secuencial
        if (modo.equals("S")) {
            // Llamamos a un único subproceso para calcular toda la suma
            BufferedReader br = lanzarSubproceso(num1, num2);
            try {
                suma = Long.parseLong(br.readLine());
                System.out.println("Resultado secuencial: " + suma);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
        // Modo paralelo
        else if (modo.equals("P")) {
            int numeroProcesadores = Runtime.getRuntime().availableProcessors();
            System.out.println("El número de procesadores es: " + numeroProcesadores);
            Long tamanyoParticion = ((num2 - num1) / numeroProcesadores);

            // Si el tamaño de la partición es inferior a 1, lo ejecutamos con un solo proceso
            if (tamanyoParticion < 1) {
                numeroProcesadores = 1;
                tamanyoParticion = num2 - num1 - 1;
            }

            // Estructuras de datos para mejorar la lectura de los buffers
            BufferedReader[] bReaders = new BufferedReader[numeroProcesadores];
            int j = 0; // índice para el vector bReaders
            System.out.println("Tamaño de partición: " + tamanyoParticion);

            for (int i = 0; i < numeroProcesadores; i++) {
                Long valorIni = num1 + i * tamanyoParticion;
                Long valorFin = num1 + ((i + 1) * tamanyoParticion) - 1;

                // El último proceso ejecuta todos los restantes
                if (i == numeroProcesadores - 1)
                    valorFin = num2;

                System.out.println("Lanzando proceso " + i + ": " + valorIni + "-" + valorFin);

                bReaders[j] = lanzarSubproceso(valorIni, valorFin);
                j++;
            }

            // Una vez finalizado, empezamos con la lectura de los búffers
            for (int i = 0; i < numeroProcesadores; i++) {
                System.out.println("Esperando el resultado del proceso " + i);
                try {
                    suma += Long.parseLong(bReaders[i].readLine());
                    System.out.println("Resultado del subproceso: " + suma);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            System.out.println("Resultado final (paralelo): " + suma);
        } else {
            System.out.println("Opción no válida. Elija 'S' para secuencial o 'P' para paralelo.");
        }

        sc.close();
    }
}
