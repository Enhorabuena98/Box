package PExamen;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class CrearJson {

	public static ArrayList<Personajes> crearLista() {
		
	
	String[] nombres = {
		    "Rick Sanchez", "Morty Smith", "Summer Smith", "Beth Smith", "Jerry Smith", 
		    "Birdperson", "Mr. Meeseeks", "Squanchy", "Mr. Poopybutthole", "Tammy Guetermann",
		    "Evil Morty", "Pickle Rick", "Abradolf Lincler", "Unity", "Krombopulos Michael", 
		    "Noob-Noob", "Jessica", "Scary Terry", "Beth Clone", "Phoenixperson"
		};

		String[] rangos = {
		    "Científico", "Aventurero", "Estudiante", "Veterinaria", "Desempleado", 
		    "Guerrero", "Asistente", "Revolucionario", "Amigo de la Familia", null,
		    "Dictador", "Pepinillo", null, "Conciencia Colectiva", "Asesino a Sueldo", 
		    "Empleado", "Interés Amoroso", "Pesadilla", "Clon", null
		};

		String[] planetas = {
		    "Tierra (C-137)", "Tierra (C-137)", "Tierra (C-137)", null, "Tierra (C-137)", 
		    "Planeta Fénix", "Tierra (C-137)", "Planeta Squanch", null, "Planeta Gazorpazorp",
		    "Tierra (Desconocida)", "Tierra (C-137)", "Tierra (C-137)", "Planeta Unity", null, 
		    "Tierra (C-137)", null, "Dimensión de Pesadillas", "Tierra (C-137)", "Planeta Fénix"
		};

		int[] edades = {
		    70, 14, 17, 34, 35, 
		    50, 0, 45, 30, 0, 
		    14, 70, 35, 1000, 0, 
		    22, 17, 0, 34, 50
		};

		double[] salarios = {
		    150000, 50000, 30000, 0, 0, 
		    120000, 10000, 0, 75000, 60000, 
		    200000, 0, 60000, 150000, 85000, 
		    0, 25000, 50000, 80000, 120000
		};

		String[] productoras = {
		    "Adult Swim", null, "Adult Swim", "Adult Swim", "Adult Swim", 
		    "Adult Swim", "Adult Swim", "Adult Swim", "Adult Swim", "Adult Swim",
		    "Adult Swim", null, "Adult Swim", "Adult Swim", null, 
		    "Adult Swim", "Adult Swim", "Adult Swim", null, "Adult Swim"
		};
	
		ArrayList<Personajes> lista = new ArrayList<Personajes>();
		for (int i = 0; i < nombres.length; i++) {
			lista.add(new Personajes(nombres[i],rangos[i],planetas[i],productoras[i],edades[i],salarios[i]));
		}
		return lista;
	}		
	public static void main(String[] args) {

		ArrayList<Personajes> lista = crearLista();
		JSONObject general = new JSONObject();
		JSONArray array = new JSONArray();
		general.put("Ricky", array);
		
		for (Personajes per : lista) {
			array.put(per.convertidor());
		}
		
		try (FileWriter fw = new FileWriter("morty.json")) {
			fw.write(general.toString(3));
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
