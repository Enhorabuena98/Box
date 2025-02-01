package cp2AD;

public class MaximoThreads {
    public static void main(String[] args) {
        try {
            // Verificar que se hayan proporcionado argumentos
            if (args.length == 0) {
                System.out.println("Por favor, proporciona una lista de números como argumentos.");
                return;
            }

            // Convertir los argumentos de String a int[]
            int[] listaNumeros = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                listaNumeros[i] = Integer.parseInt(args[i]);
            }

            // Creamos el objeto Maximo que será compartido entre los hilos
            Maximo maximoCompartido = new Maximo();

            // Determinamos el número de procesadores disponibles
            Runtime runtime = Runtime.getRuntime();
            int numProcesadores = runtime.availableProcessors();
            System.out.println("Dividiendo la tarea en " + numProcesadores + " hilos");

            // Calculamos el tamaño de las sublistas
            int longitudLista = listaNumeros.length;
            int tamanoSublista = (int) Math.ceil((double) longitudLista / numProcesadores);

            // Creamos el array de hilos
            Thread[] vectorHilos = new Thread[numProcesadores];

            // Creación y lanzamiento de hilos
            for (int i = 0; i < numProcesadores; i++) {
                int inicio = i * tamanoSublista;
                int fin = Math.min((i + 1) * tamanoSublista - 1, longitudLista - 1);

                // Creamos un objeto MaximoSublista
                MaximoSublista tarea = new MaximoSublista(listaNumeros, inicio, fin, maximoCompartido);

                // Creamos y lanzamos el hilo
                vectorHilos[i] = new Thread(tarea);
                vectorHilos[i].setName("Hilo " + i);
                vectorHilos[i].start();
            }

            // Esperar a que todos los hilos terminen
            for (int i = 0; i < numProcesadores; i++) {
                try {
                    vectorHilos[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Imprimir el máximo final
            System.out.println("El máximo de la lista es: " + maximoCompartido.get());

        } catch (NumberFormatException e) {
            System.out.println("Error: todos los argumentos deben ser números enteros.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
