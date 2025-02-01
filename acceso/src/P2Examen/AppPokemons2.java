package P2Examen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

public class AppPokemons2 {
	private static final  String nombreFicheroIn = "./pokemon.csv";
	private static final  String nombreFicheroOut1 = "./pokemonAsh2.csv";
	private static final  String nombreFicheroOut2 = "./pokemonEntrenadores2.csv";

	public static void main(String[] args) {
		ArrayList<Pokemons2>pokemons2;
		pokemons2 = importar(nombreFicheroIn);
		for (Pokemons2 pokemon : pokemons2) {
			System.out.println(pokemon);
		}
		Pokemons2 elMejor = mejorAtaque(pokemons2);
		System.out.println("El maquina: " + elMejor);
		expAsh2(nombreFicheroOut1,pokemons2);
		expEntrenadores2(nombreFicheroOut2,pokemons2);
	}

	private static void expEntrenadores2(String nom, ArrayList<Pokemons2> pokemons2) {
		FileWriter fw = null;
		File f = new File(nom);
		
		try {
			fw = new FileWriter(f);
			BufferedWriter bfw = new BufferedWriter(fw);
			for (Pokemons2 pokemon2 : pokemons2) {
				if (!pokemon2.getEntrenador().equals("Ash")) {
					bfw.write(pokemon2.toCSV());
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

	private static void expAsh2(String nom, ArrayList<Pokemons2> pokemons2) {
		FileWriter fw = null;
		File f = new File(nom);
		
		try {
			fw = new FileWriter(f);
			BufferedWriter bfw = new BufferedWriter(fw);
			
			for (Pokemons2 pokemon2 : pokemons2) {
				if (pokemon2.getEntrenador().equals("Ash")) {
					bfw.write(pokemon2.toCSV());
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

	private static Pokemons2 mejorAtaque(ArrayList<Pokemons2> pokemons2) {
		if (pokemons2!=null) {
			return null;

		}
		Pokemons2 p = pokemons2.get(0);
		for (int i = 0; i < pokemons2.size(); i++) {
			if (pokemons2.get(i).getAtaque()>p.getAtaque()) {
				p = pokemons2.get(i);
			}
		}
		return p;
	}

	private static ArrayList<Pokemons2> importar(String nombre) {
		FileReader fr = null;
		File f = new File(nombre);
		
		ArrayList<Pokemons2>pokemons2 = null;
		pokemons2 = new ArrayList<Pokemons2>();
		
		try {
			fr = new FileReader(f);
			BufferedReader bfr = new BufferedReader(fr);
			String linea;
			while ((linea=bfr.readLine())!=null) {
				String[] partes= linea.split(",");
				Pokemons2 p = new Pokemons2(partes[0],
						partes[1],Double.parseDouble(partes[2]),
						Integer.parseInt(partes[3]),
						Double.parseDouble(partes[4]),partes[5],partes[6]);
				pokemons2.add(p);
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
		
		
		return pokemons2;
		
	}

}
