/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.cp5;



import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author joange
 */
class AlumnoTel {

    private Long idAlumno;
    private String nombre;
    private int edad;
    private boolean repetidor;
    private String[] telefonos;

    public AlumnoTel(Long idAlumno, String nombre, int edad, boolean repetidor, String[] telefonos) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.edad = edad;
        this.repetidor = repetidor;
        this.telefonos = telefonos;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdat() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isRepetidor() {
        return repetidor;
    }

    public void setRepetidor(boolean repetidor) {
        this.repetidor = repetidor;
    }

    public String[] getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String[] telefonos) {
        this.telefonos = telefonos;
    }

  
    public JSONObject asJSON() {
       
    	JSONObject alumno = new JSONObject();
    	alumno.put("idAlumno", idAlumno);
    	alumno.put("nombre", nombre);
    	alumno.put("edad", edad);
    	alumno.put("repetidor", repetidor);

    	JSONArray losTelefonos = new JSONArray();
    	
    	for (String tel : this.telefonos) {
			losTelefonos.put(tel);
		}
    	alumno.put("telefonos", telefonos);
    	
        return alumno;
    }

}


