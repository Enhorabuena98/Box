package Ptenis;

public class Tenis {
	//1550 y sacar  salva
	
	String apellido, nombre, club;
	int lic, anio;
	double ranking;
	
	
	public Tenis(int lic, String apellido, String nombre, String club, int anio, double ranking) {
		super();
		this.lic = lic;
		this.apellido = apellido;
		this.nombre = nombre;
		this.club = club;
		this.anio = anio;
		this.ranking = ranking;
		
	}
	public String toCSV() {
		return lic + "," + apellido + "," + nombre + "," + club + "," + anio + "," + ranking ;
	}
	@Override
	public String toString() {
		return "Tenis [apellido=" + apellido + ", nombre=" + nombre + ", club=" + club + ", lic=" + lic + ", anio="
				+ anio + ", ranking=" + ranking + "]";
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public int getLic() {
		return lic;
	}

	public void setLic(int lic) {
		this.lic = lic;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public double getRanking() {
		return ranking;
	}

	public void setRanking(double ranking) {
		this.ranking = ranking;
	}
	

}
