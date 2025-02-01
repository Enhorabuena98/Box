package Examenpsp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Paralelizacion {
	
	public static void main(String[] args) {
//		paso 1: comprobar que hay dos argumentos
		if (args.length != 2) {
			System.out.println("dos argumentos bro");
			System.exit(-1);
		}
//		paso 2: inicializar los argumentos como variables
		long inicio = Long.parseLong(args[0]);
		long fin = Long.parseLong(args[1]);
//		paso 3: ordenar los argumentos
		if (inicio > fin) {
			long temp = inicio;
			inicio = fin;
			fin = temp;
		}
//		paso 4: obtener el número de procesadores disponibles
		int numeroProcesadores = Runtime.getRuntime().availableProcessors();
		
//		paso 5: calcular el tamaño del intervalo para cada procesador
		long intervalo = (fin - inicio) / numeroProcesadores;
		System.out.println("Tamaño particion: " + intervalo);
//		paso 5.5: inicializar el arrays de bfr con el np de tamaño
		BufferedReader[] bReaders = new BufferedReader[numeroProcesadores];
		int brpos = 0;
		
		try {
//			paso 6: lanzar los subprocesos para cada partición
			for (int i = 0; i < numeroProcesadores; i++) {
				long subinicio = inicio + i * intervalo;
				long subfin = subinicio + intervalo - 1;
//				paso 6.5: ajustar el límite del último intervalo
				if (i == numeroProcesadores - 1) {
					subfin = fin;
				}
//				paso 7: lanzar los breaders con el metodo lanzarSubprocesos
				System.out.printf("Lanzando proceso %d: %d - %d%n", i, subinicio, subfin);
				bReaders[brpos] = lanzarSubproceso(subinicio, subfin);
				brpos++;
				System.out.println("Iniciando proceso: " + (i + 1) + " ");
			}
			
//			paso 8: inicializar variable para el resultado de la multiplicación total
			long multiplicacionTotal = 1;
			for (BufferedReader br : bReaders) {
				String linea;
//				paso 9: leer y multiplicar los resultados de cada subproceso
				while ((linea = br.readLine()) != null) {
					multiplicacionTotal *= Long.parseLong(linea);
					System.out.println("Resultado subproceso: " + multiplicacionTotal);
				}
			}
//			paso 10: imprimir el resultado final
			System.out.println("Total: " + multiplicacionTotal);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
//	metodo para lanzar subproceso que ejecuta la multiplicación en el intervalo dado
	private static BufferedReader lanzarSubproceso(long inicio, long fin) {
		try {
//			paso 1: iniciar el proceso y retornar el BufferedReader para leer su salida
			ProcessBuilder pb = new ProcessBuilder("java", "C:\\\\Users\\\\DELL\\\\eclipse-workspace\\\\Tema1PSP\\\\src\\\\Examenpsp\\\\MultiplicacionSimple.java", Long.toString(inicio), Long.toString(fin));
			Process p = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			return br;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
