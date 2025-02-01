package Pexamen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Pexamen.Pokemons;
public class AppPokemon {
	
	private static final String nombreFicheroIn = "./pokemon.csv";
	private static final String nombreFicheroAsh = "./pokemonAsh.csv";
	private static final String nombreFicheroEntrenadores = "./pokemonEntrenadores.csv";
	

	public static void main(String[] args) {
		ArrayList<Pokemons>pokemons;
		pokemons = importar(nombreFicheroIn);
		for (Pokemons pokemon : pokemons) {
			System.out.println(pokemon);
		}
		Pokemons elMejor = mejorAtaque(pokemons);
		System.out.println("El pokemon con el mejor ataque es: " + elMejor);
		expAsh(nombreFicheroAsh, pokemons);
		expEntrenadores(nombreFicheroEntrenadores, pokemons);
	}


	private static void expEntrenadores(String nom, ArrayList<Pokemons> pokemons) {
		FileWriter fw = null;
		File f = new File(nom);
		try {
			fw = new FileWriter(f);
		
		
		BufferedWriter bfw = new BufferedWriter(fw);
		
		for (Pokemons pokemon : pokemons) {
			if (pokemon.getEntrenador().equals("Ash")) {
				bfw.write(pokemon.toCSV());
				bfw.newLine();
			}
		}
		bfw.close();
		fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


	private static void expAsh(String nom, ArrayList<Pokemons> pokemons) {
		FileWriter fw = null;
		File f = new File(nom);
		try {
			fw = new FileWriter(f);
		
		
		BufferedWriter bfw = new BufferedWriter(fw);
		
		for (Pokemons pokemon : pokemons) {
			if (pokemon.getEntrenador().equals("Ash")) {
				bfw.write(pokemon.toCSV());
				bfw.newLine();
			}
		}
		bfw.close();
		fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private static Pokemons mejorAtaque(ArrayList<Pokemons> pokemons) {
		if (pokemons ==null) {
			return null;
		}
		Pokemons p = pokemons.get(0);
		for (int i = 1; i < pokemons.size(); i++) {
			if(pokemons.get(i).getAtaque()>p.getAtaque()) {
				p = pokemons.get(i);
			}
		}
		return p;
	}


	private static ArrayList<Pokemons> importar(String nombre) {
		FileReader fr = null;
		ArrayList<Pokemons>pokemons = null;
		
		pokemons = new ArrayList<Pokemons>();
		File f = new File(nombre);
		try {
			fr = new FileReader(f);
			BufferedReader bfr = new BufferedReader(fr);
			String linea;
			while((linea=bfr.readLine())!=null) {
				String[]partes = linea.split(",");
				Pokemons p = new Pokemons(partes[0],partes[1],
						Double.parseDouble(partes[2]),
						Integer.parseInt(partes[3]),
						Double.parseDouble(partes[4]),
						partes[5],partes[6]);
				pokemons.add(p);
			}
			fr.close();
			bfr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pokemons;
	}

}
