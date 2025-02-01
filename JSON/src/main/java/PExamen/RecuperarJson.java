package PExamen;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class RecuperarJson {
	
	public static ArrayList<Personajes> recuperarLista(String archivo){
		ArrayList<Personajes> lista = new ArrayList<Personajes>();
		try (FileReader fr = new FileReader(archivo)) {
			StringBuilder myJson = new StringBuilder();
			
			int i;
			while ((i = fr.read())!= -1) {
				myJson.append((char) i);
			}
			JSONObject personajes = new JSONObject(myJson.toString());
			JSONArray personajesArray	= personajes.getJSONArray("Ricky");
			
			for (int j = 0; j < personajesArray.length(); j++) {
				 JSONObject personajesObjeto =personajesArray.getJSONObject(j);
				 Personajes richymorti = new Personajes(personajesObjeto);
				 lista.add(richymorti);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
		
	}
	public static void main(String[] args) {

		ArrayList<Personajes> lista = recuperarLista("morty.json");
		for (Personajes per : lista) {
			System.out.println(per);
		}
	}

}
