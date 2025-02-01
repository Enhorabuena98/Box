package EntregableHilos;

import java.util.concurrent.*;

public class BusquedaElementoArray {

    public static boolean buscarElemento(int[] array, int elementoBuscado) throws InterruptedException, ExecutionException {
        // Número de procesadores disponibles
        int numeroProcesadores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numeroProcesadores);

        // Dividir el array en partes iguales para cada hilo
        int tamanioPorHilo = array.length / numeroProcesadores;
        Future<Boolean>[] resultados = new Future[numeroProcesadores];

        for (int i = 0; i < numeroProcesadores; i++) {
            int inicio = i * tamanioPorHilo;
            int fin = (i == numeroProcesadores - 1) ? array.length : inicio + tamanioPorHilo;

            // Asignar tareas a los hilos
            resultados[i] = executor.submit(new TareaBusqueda(array, elementoBuscado, inicio, fin));
        }

        // Recolectar resultados
        boolean encontrado = false;
        for (Future<Boolean> resultado : resultados) {
            if (resultado.get()) {
                encontrado = true;
                break;
            }
        }

        // Apagar el executor
        executor.shutdown();

        return encontrado;
    }
}

class TareaBusqueda implements Callable<Boolean> {
    private final int[] array;
    private final int elemento;
    private final int inicio;
    private final int fin;

    public TareaBusqueda(int[] array, int elemento, int inicio, int fin) {
        this.array = array;
        this.elemento = elemento;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public Boolean call() {
        for (int i = inicio; i < fin; i++) {
            if (array[i] == elemento) {
                return true;
            }
        }
        return false;
    }
}
