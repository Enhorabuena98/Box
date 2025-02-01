package com.practica.cp5;

import org.json.JSONArray;
import org.json.JSONObject;

public class JugadorFutbol {
		
	private Long idFutbolista;
	private String nombre;
    private int edad;
    private boolean juega;
    private String[] posiciones;
    
    public JugadorFutbol(Long idFutbolista, String nombre, int edad, boolean juega, String[] posiciones) {
		super();
		this.idFutbolista = idFutbolista;
		this.nombre = nombre;
		this.edad = edad;
		this.juega = juega;
		this.posiciones = posiciones;
	}
    
    public Long getIdFutbolista() {
		return idFutbolista;
	}

	public void setIdFutbolista(Long idFutbolista) {
		this.idFutbolista = idFutbolista;
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

	public boolean isJuega() {
		return juega;
	}

	public void setJuega(boolean juega) {
		this.juega = juega;
	}

	public String[] getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(String[] posiciones) {
		this.posiciones = posiciones;
	}

	public JSONObject asJSON() {
		JSONObject jugador = new JSONObject();
		jugador.put("idFutbolista", idFutbolista);
		jugador.put("nombre", nombre);
		jugador.put("edad", edad);
		jugador.put("juega", juega);
		
		JSONArray lasPosiciones = new JSONArray();
		
		for (String posiciones : this.posiciones) {
			lasPosiciones.put(posiciones);
		}
		jugador.put("posiciones", posiciones);
		return jugador;
	}
	

}
