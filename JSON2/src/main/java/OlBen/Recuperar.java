package OlBen;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class Recuperar {

    public static ArrayList<Personajes> recuperarLista(String archivo) {
        ArrayList<Personajes> lista = new ArrayList<>();

        try {
            FileReader fr = new FileReader(archivo);
            StringBuilder myJson = new StringBuilder();

            int i;
            while ((i = fr.read()) != -1) {
                myJson.append((char) i);
            }
            fr.close();

            // Parsear el contenido JSON completo
            JSONObject jugadores = new JSONObject(myJson.toString());

            // Aquí usamos la clave correcta para obtener el array "Campeones"
            JSONArray jugadoresArray = jugadores.getJSONArray("Campeones");

            // Iterar sobre cada objeto en el array y crear los personajes
            for (int j = 0; j < jugadoresArray.length(); j++) {
                JSONObject jugadoresObjeto = jugadoresArray.getJSONObject(j);
                Personajes oliverBenji = new Personajes(jugadoresObjeto);
                lista.add(oliverBenji);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static void main(String[] args) {
        // Recuperar la lista de personajes desde el archivo JSON
        ArrayList<Personajes> lista = recuperarLista("oliver.json");

        // Mostrar cada personaje recuperado en la consola
        for (Personajes per : lista) {
            System.out.println(per);
        }
    }
}

