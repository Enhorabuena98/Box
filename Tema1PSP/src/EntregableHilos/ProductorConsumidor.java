package EntregableHilos;

import java.util.concurrent.*;

public class ProductorConsumidor {
    public static void main(String[] args) {
        int rangoMin = 0; // Puedes reemplazar estos valores por parámetros ingresados.
        int rangoMax = 20; // Este límite se usará para detener el productor.

        BlockingQueue<Integer> cola = new ArrayBlockingQueue<>(10);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(new Productor(cola, rangoMin, rangoMax));
        executor.execute(new Consumidor(cola, rangoMax));

        executor.shutdown();
    }
}

class Productor implements Runnable {
    private final BlockingQueue<Integer> cola;
    private final int rangoMin;
    private final int rangoMax;

    public Productor(BlockingQueue<Integer> cola, int rangoMin, int rangoMax) {
        this.cola = cola;
        this.rangoMin = rangoMin;
        this.rangoMax = rangoMax;
    }

    @Override
    public void run() {
        try {
            for (int i = rangoMin; i <= rangoMax; i++) {
                cola.put(i); // Produce un número dentro del rango
                System.out.println("Productor produjo: " + i);
                Thread.sleep(100); // Simula tiempo de producción
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumidor implements Runnable {
    private final BlockingQueue<Integer> cola;
    private final int rangoMax;

    public Consumidor(BlockingQueue<Integer> cola, int rangoMax) {
        this.cola = cola;
        this.rangoMax = rangoMax;
    }

    @Override
    public void run() {
        int elementosConsumidos = 0;
        try {
            while (elementosConsumidos <= rangoMax) {
                Integer numero = cola.take();
                System.out.println("Consumidor procesó: " + numero);
                elementosConsumidos++;
                Thread.sleep(150); // Simula tiempo de procesamiento
            }
            System.out.println("Consumidor ha terminado.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
