package OlBen;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class CrearOB {


	public static ArrayList<Personajes> crearLista(){
		
		String[] nombres = {"Oliver Atom", "Benji Price", "Mark Lenders", "Tom Misaki", "Steve Hyuga", "Karl Heinz Schneider", "Taro Misaki", "Roberto Hongo", "Hikaru Matsuyama", "Rivaul"};
		String[] posiciones = {"Portero", "Portero", "Defensa", "Centrocampista", "Delantero", "Delantero", "Centrocampista", "Entrenador", "Centrocampista", "Centrocampista"};
	    String[] ciudades = {"Tokio", "Liverpool", "Hamburgo", "Nagano", "Sao Paulo", "Munich", "Nara", "Buenos Aires", "Osaka", "Río de Janeiro"};
	    int[] edades = {14, 15, 16, 14, 17, 18, 15, 40, 16, 25};
	    double[] latitudes = {35.6895, 53.4084, 53.5511, 36.6486, -23.5505, 48.8566, 34.6851, -34.6118, 34.6937, -22.9068};
	    double[] longitudes = {139.6917, -2.9916, 9.9937, 138.1948, -46.6333, 2.3522, 135.8049, -58.4173, 135.5022, -43.1729};

	    ArrayList<Personajes> lista = new ArrayList<Personajes>();
	    for (int i = 0; i < nombres.length; i++) {
			lista.add(new Personajes(nombres[i],posiciones[i],ciudades[i],edades[i],latitudes[i],longitudes[i]));
		
	    }
	    return lista;
	}

	public static void main(String[] args) {

		ArrayList<Personajes> lista = crearLista();
		JSONObject general = new JSONObject();
		JSONArray array = new JSONArray();
		general.put("Campeones", array);
		
		for (Personajes pers : lista) {
			array.put(pers.convertidor());
		}
		
		try (FileWriter fw = new FileWriter("oliver.json")) {
			fw.write(general.toString(3));
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
