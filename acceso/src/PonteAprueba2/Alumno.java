package PonteAprueba2;

public class Alumno {
	
	public Alumno(String nombre, int edad, String ciclo,  double notaMedia) {
	super();
	this.nombre = nombre;
	this.ciclo = ciclo;
	this.edad = edad;
	this.notaMedia = notaMedia;
}
	private String nombre;
	private String ciclo; 
	private int edad;
	private double notaMedia;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getNotaMedia() {
		return notaMedia;
	}
	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", ciclo=" + ciclo + ", edad=" + edad + ", notaMedia=" + notaMedia
				+ "]";
	}
	public boolean aprobado() {
		if(notaMedia>=5) {
			return true;
		}
		return false;
	}
	public String toCSV() {
		return nombre + "," + edad + "," + ciclo + "," + notaMedia;
	}
	public boolean suspenso() {
		if(notaMedia<5) {
			return true;
		}
		return false;
	}
	
	
	

}