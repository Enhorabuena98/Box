package com.practica.cp5;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class CasoPractico5 {

	public static void main(String[] args) {
		
		JugadorFutbol j1 = new JugadorFutbol(2000L, "Lionel Messi", 36, true, new String[]{"Delantero", "Capitán"});
		JugadorFutbol j2 = new JugadorFutbol(2001L, "Cristiano Ronaldo", 38, true, new String[]{"Delantero", "Extremo"});
		JugadorFutbol j3 = new JugadorFutbol(2002L, "Kylian Mbappé", 25, false, new String[]{"Delantero"});
		JugadorFutbol j4 = new JugadorFutbol(2003L, "Kevin De Bruyne", 32, true, new String[]{"Mediocampista", "Capitán"});
		JugadorFutbol j5 = new JugadorFutbol(2004L, "Virgil van Dijk", 33, true, new String[]{"Defensa", "Capitán"});
	
			JSONObject equipo = new JSONObject();
			JSONArray jugadores = new JSONArray();
			equipo.append("jugadores", jugadores);
			jugadores.put(j1.asJSON());
			jugadores.put(j2.asJSON());
			jugadores.put(j3.asJSON());
			jugadores.put(j4.asJSON());
			jugadores.put(j5.asJSON());
			
			try {
				FileWriter fw = new FileWriter("jugadores.json");
				fw.write(equipo.toString(3));
				fw.close();
				System.out.println("Exito");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
