package com.ejemplo.cp5;

import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class CasoPractico5 {

	public static void main(String[] args) {
        
        AlumnoTel a1 = new AlumnoTel(1000L, "Jose Andres Perez", 22, false, new String[]{"222333444", "555666777", "888999000"});
        AlumnoTel a2 = new AlumnoTel(1001L, "Ana Sanchis Cabanilles", 21, false, new String[]{"222333444", "555666777", "888999000", "333421039"});
        AlumnoTel a3 = new AlumnoTel(1002L, "Aina Gomes Pons", 23, true, new String[]{});
        AlumnoTel a4 = new AlumnoTel(1003L, "Ainara GabaldÃ³n Estruch", 24, false, new String[]{"222111214", "515626677"});

        	JSONObject clase = new JSONObject();
        	JSONArray alumnos = new JSONArray();
        	clase.append("alumnos", alumnos);
        	alumnos.put(a1.asJSON());
        	alumnos.put(a2.asJSON());
        	alumnos.put(a3.asJSON());
        	alumnos.put(a4.asJSON());
        	
        	
        	try {
				FileWriter fw = new FileWriter("alumnos.json");
				fw.write(clase.toString(3));
				fw.close();
				System.out.println("se ha generado el fichero alumnos.json");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
    }

}
