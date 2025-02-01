package Ptenis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Pexamen.Pokemons;

public class AppTenis {

	private static final String nombreficheroIn = "./tenisdemesa.csv";
	private static final String nombreficheroOut1 = "./buenos.csv";
	private static final String nombreficheroOu2 = "./mataos.csv";
			
	public static void main(String[] args) {
		ArrayList <Tenis> tenis;
		tenis = importar(nombreficheroIn);
		for (Tenis teni : tenis) {
			System.out.println(teni);
		}
		Tenis salva = sacarSalva(tenis);
		System.out.println("Aquitaelmakina: " + salva);
		expBuenos(nombreficheroOut1,tenis);
		expMalos(nombreficheroOu2,tenis);
	}

	private static void expMalos(String nom, ArrayList<Tenis> tenis) {
		FileWriter fw = null;
		File f = new File(nom);
		
		try {
			fw = new FileWriter(f);
			BufferedWriter bfw = new BufferedWriter(fw);
			for (Tenis teni : tenis) {
				if (teni.getRanking()>1550) {
					bfw.write(teni.toCSV());
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

	private static void expBuenos(String nom, ArrayList<Tenis> tenis) {
		FileWriter fw = null;
		File f = new File(nom);
		
		try {
			fw = new FileWriter(f);
			BufferedWriter bfw = new BufferedWriter(fw);
			for (Tenis teni : tenis) {
				if (teni.getRanking()<1550) {
					bfw.write(teni.toCSV());
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

	private static Tenis sacarSalva(ArrayList<Tenis> tenis) {
		if (tenis ==null) {
			return null;
		}
		for (Tenis teni : tenis) {
			if (teni.getNombre().equals("Salvador")) {
				return teni;
			}
		}
		return null;
	}

	private static ArrayList<Tenis> importar(String nombre) {
		ArrayList<Tenis>tenis=null;
		tenis = new ArrayList<Tenis>();
		
		FileReader fr = null;
		File f = new File(nombre);
		
		try {
			fr = new FileReader(f);
			BufferedReader bfr = new BufferedReader(fr);
			String linea;
			while ((linea=bfr.readLine())!=null) {
				String[]partes = linea.split(",");
				Tenis t = new Tenis(Integer.parseInt(partes[0]),partes[1],
						partes[2],partes[3],Integer.parseInt(partes[4]),
						Double.parseDouble(partes[5]));
				tenis.add(t);
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
		
		return tenis;
	}

}
