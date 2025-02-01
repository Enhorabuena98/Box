package Simpson;

public class Simpsons {

    private String nombre, apellido, familia;
    private int numCap, edad;
    private Double altura;

    public Simpsons(String nombre, String apellido, String familia, int numCap, int edad, Double altura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.familia = familia;
        this.numCap = numCap;
        this.edad = edad;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Simpsons [nombre=" + nombre + ", apellido=" + apellido + ", familia=" + familia + ", numCap="
                + numCap + ", edad=" + edad + ", altura=" + altura + "]";
    }

    public String toCSV() {
        return nombre + "," + apellido + "," + familia + "," + numCap + "," + edad + "," + altura;
    }

    public boolean simpsonsAltos() {
        return altura >= 1.65;
    }

    public boolean simpsonsBajos() {
        return altura < 1.65;
    }
}
