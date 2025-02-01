package cp2AD;

class MaximoSublista implements Runnable {

    private int[] lista;
    private int inicio;
    private int fin;
    private Maximo maximoCompartido;

    // Constructor
    MaximoSublista(int[] lista, int inicio, int fin, Maximo maximoCompartido) {
        this.lista = lista;
        this.inicio = inicio;
        this.fin = fin;
        this.maximoCompartido = maximoCompartido;
    }

    @Override
    public void run() {
        long maxLocal = Long.MIN_VALUE;
        Thread hiloActual = Thread.currentThread();
        System.out.println("Iniciando el hilo " + hiloActual.getName());

        // Calcular el máximo en la sublista
        for (int i = inicio; i <= fin; i++) {
            if (lista[i] > maxLocal) {
                maxLocal = lista[i];
            }
        }

        System.out.println("Máximo local del hilo " + hiloActual.getName() + ": " + maxLocal);

        // Actualizar el máximo compartido
        synchronized (maximoCompartido) {
            maximoCompartido.actualizar(maxLocal);
        }
    }
}
