package P2Examen;

import org.json.JSONObject;

public class Personajes {

	String nombre,rango,planeta,productura;
	int edad;
	double salario;
	
	public Personajes(String nombre, String rango, String planeta, String productura, int edad, double salario) {
		this.nombre = nombre;
		this.rango = rango;
		this.planeta = planeta;
		this.productura = productura;
		this.edad = edad;
		this.salario = salario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRango() {
		return rango;
	}
	public void setRango(String rango) {
		this.rango = rango;
	}
	public String getPlaneta() {
		return planeta;
	}
	public void setPlaneta(String planeta) {
		this.planeta = planeta;
	}
	public String getProductura() {
		return productura;
	}
	public void setProductura(String productura) {
		this.productura = productura;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Personajes [nombre=" + nombre + ", rango=" + rango + ", planeta=" + planeta + ", productura="
				+ productura + ", edad=" + edad + ", salario=" + salario + "]";
	}
	public Personajes(JSONObject jsonobject) {
		this.nombre = jsonobject.getString("nombre");
		this.rango = jsonobject.optString("rango","");
		this.planeta = jsonobject.optString("planeta", "");
		this.productura = jsonobject.optString("productora", "");
		this.edad = jsonobject.getInt("edad");
		this.salario = jsonobject.getDouble("salario");
	}
	public JSONObject convertidor() {
		JSONObject personaje = new JSONObject();
		personaje.put("nombre", nombre);
		personaje.put("rango", rango);
		personaje.put("planeta", planeta);
		personaje.put("productora", productura);
		personaje.put("edad", edad);
		personaje.put("salario", salario);
		
		return personaje;
	}
}
