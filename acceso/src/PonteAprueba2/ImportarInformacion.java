package PonteAprueba2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import PonteAprueba2.Alumno;

public class ImportarInformacion {
		private static final String nombreFicheroIn = "./alumnos.csv";
		private static final String nombreFicheroOUT =  "alumnos aprovados.csv";
		private static final String nombreFicheroSuspensos = "alumnos Suspensos.csv";
		
		
	public static void main(String[] args) {
		ArrayList<Alumno> alumnos;
		alumnos = importar(nombreFicheroIn);
		for (Alumno alumno : alumnos) {
			System.out.println(alumno);
		}
		Alumno elMejor = buscarMejorAlumno(alumnos);
		System.out.println("El mejor alumno es " + elMejor);
		exportarAprobados(nombreFicheroOUT, alumnos);
		exportarSuspensos(nombreFicheroSuspensos, alumnos);
	}

	private static Alumno buscarMejorAlumno(ArrayList<Alumno> alumnos) {
		if(alumnos==null) {
			return null;
		}
		Alumno a = alumnos.get(0);
		for (int i = 1; i < alumnos.size(); i++) {
			if(alumnos.get(i).getNotaMedia()> a.getNotaMedia()) {
				a = alumnos.get(i);
			}
		}
		return a;
	}

	private static ArrayList<Alumno> importar(String nombre) {
		FileReader fr = null;
		ArrayList<Alumno>alumnos = null;
	
			alumnos = new ArrayList<>();
			File f = new File(nombre);
			try {
				fr = new FileReader(f);
			
			BufferedReader bfr = new BufferedReader(fr);
			String linea;
			while((linea = bfr.readLine()) !=null) {
				String[] partes = linea.split(",");
				Alumno a = new Alumno(partes[0],
						Integer.parseInt(partes[1]),
						partes[2],
						Double.parseDouble(partes[3]));
				alumnos.add(a);
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
			return alumnos;
		   
	}
	public static void exportarAprobados(String nom, ArrayList<Alumno> alumnos) {
		FileWriter fw = null;
		File f = new File(nom);
		try {
			fw = new FileWriter(f);
		
		BufferedWriter bfw = new BufferedWriter(fw);
		for (Alumno alumno : alumnos) {
			if (alumno.aprobado()) {
				bfw.write(alumno.toCSV());
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
	public static void exportarSuspensos(String nom, ArrayList<Alumno> alumnos) {
		FileWriter fw = null;
		File f = new File(nom);
		try {
			fw = new FileWriter(f);
		
		BufferedWriter bfw = new BufferedWriter(fw);
		for (Alumno alumno : alumnos) {
			if (alumno.suspenso()) {
				bfw.write(alumno.toCSV());
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
	
}
