package cp3;

import java.io.Serializable;

public class Alumnos implements Serializable {

	  private static final long serialVersionUID = 1L;
	    //  private static final long serialVersionUID = 1L;
	    private String nombre;
	    private int edad;
	    private String ciclo;
	    private double nota;

	    public Alumnos(String nombre, int edad, String ciclo, double nota) {
	        this.nombre = nombre;
	        this.edad = edad;
	        this.ciclo = ciclo;
	        this.nota = nota;
	    }

	    public Alumnos() {
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public int getEdad() {
	        return edad;
	    }

	    public void setEdad(int edad) {
	        this.edad = edad;
	    }

	    public String getCiclo() {
	        return ciclo;
	    }

	    public void setCiclo(String ciclo) {
	        this.ciclo = ciclo;
	    }

	    public double getNota() {
	        return nota;
	    }

	    public void setNota(double nota) {
	        this.nota = nota;
	    }

	    @Override
	    public String toString() {
	        return "Alumno{" + "nombre=" + nombre + ", edad=" + edad + ", ciclo=" + ciclo + ", nota=" + nota + '}';
	    }


	    public String toCSV() {
	        return nombre + ","+ edad + "," + ciclo + "," + nota ;
	    }

	    public boolean aprobado(){
	        return this.nota>5;
	    }
}
