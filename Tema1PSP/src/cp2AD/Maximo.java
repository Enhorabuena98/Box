package cp2AD;

class Maximo {
    private long maximo = Long.MIN_VALUE;

    Maximo() { }

    synchronized long get() {
        return this.maximo;
    }

    synchronized void actualizar(long nuevoMaximo) {
        if (nuevoMaximo > this.maximo) {
            System.out.println("Actualizando máximo a " + nuevoMaximo);
            this.maximo = nuevoMaximo;
        }
    }
}
