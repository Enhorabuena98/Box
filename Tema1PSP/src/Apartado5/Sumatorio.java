package Apartado5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Sumatorio {

    public static void main(String[] args) {
    	
    	
        // Si no se proporcionan dos argumentos, cerramos la aplicación
        if (args.length != 2) {
            System.out.println("Se requieren 2 argumentos (números a sumar).");
            System.exit(-1);
        }

        
        
        
        // Parsear los argumentos a Long
        Long num1 = Long.parseLong(args[0]);
        Long num2 = Long.parseLong(args[1]);
        long resultado;

        // si el primer numeroo fuera la mayor lo cambia de orden
        if (num1 > num2) {
			Long Aux = num1;
			num1 = num2;
			num2 = Aux;
		}
        
        
        
        // Crear un scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Quieres calcular el sumatorio de forma secuencial (s) o en paralelo (p)? ");
        char metodo = scanner.next().charAt(0); // Leer la primera letra de la respuesta

        
        
        

        // Elegir el método a utilizar
        if (metodo == 's' || metodo == 'S')
        	
        {
            // Calcular la suma secuencial
            resultado = calcularSumatorioSecuencial(num1, num2);
            System.out.println("Resultado del sumatorio secuencial de " + num1 + " a " + num2 + ": " + resultado);
        } else {
            // Calcular la suma en paralelo
            resultado = calcularSumatorioParalelo(num1, num2);
            System.out.println("Resultado del sumatorio paralelo de " + num1 + " a " + num2 + ": " + resultado);
        }

        // Cerrar el scanner
        scanner.close();
    }

    // Método que calcula el sumatorio en paralelo (antes era secuencial)
    public static long calcularSumatorioParalelo(Long num1, Long num2) {
        Long suma = 0L;
        for (Long i = num1; i <= num2; i++) {
            suma += i;
        }
        return suma;
    }

    // Método que calcula el sumatorio secuencialmente (antes era paralelo)
    public static long calcularSumatorioSecuencial(Long num1, Long num2) {
        Long suma = 0L;
        // Número de procesadores disponibles
        int numeroProcesadores = Runtime.getRuntime().availableProcessors();
        System.out.println("Número de procesadores: " + numeroProcesadores);
        Long tamanyoParticion = (num2 - num1 + 1) / numeroProcesadores;

        // Llamamos a los subprocesos
        for (int i = 0; i < numeroProcesadores; i++) {
            Long valorIni = num1 + i * tamanyoParticion;
            Long valorFin = num1 + (i + 1) * tamanyoParticion - 1;

            // El último proceso ejecuta el resto de los números
            if (i == numeroProcesadores - 1) {
                valorFin = num2;
            }

            System.out.println("Lanzando proceso " + i + ": " + valorIni + "-" + valorFin);
            Long resultadoParcial = lanzarSubproceso(valorIni, valorFin);

            if (resultadoParcial != null) {
                suma += resultadoParcial;
                System.out.println("Suma parcial: " + suma);
            } else {
                System.out.println("No se recibió salida del subproceso.");
            }
        }

        return suma;
    }

    // Este método lanza un subproceso para calcular la suma en el rango [sum1, sum2]
    private static Long lanzarSubproceso(Long sum1, Long sum2) {
        try {
            // Usamos ProcessBuilder para ejecutar la clase Suma
            ProcessBuilder pb = new ProcessBuilder(
                "java", "\"C:\\Users\\DELL\\eclipse-workspace\\Tema1PSP\\src\\Apartado5\\Suma.java\"", Long.toString(sum1), Long.toString(sum2));
            pb.redirectErrorStream(true); // Redirige el error a la salida estándar
            Process p = pb.start();

            // Capturamos la salida del subproceso
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = br.readLine();

            // Verificamos si la línea no es null
            if (line != null) {
                long resultado = Long.parseLong(line);
                return resultado;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }
}
