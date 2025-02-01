package PrimerDia;

import java.io.File;
import java.util.Iterator;

public class PrimeraClase {

	public static void main(String[] args) {
		String ruta = args[0];
		File f = new File(ruta);
		
		
		if (f.exists()) {
			if(f.isFile()) {
			
			System.out.println("El Tamaño es de " + f.length());
			System.out.println("Pruede ejecutarse: " + f.canExecute());
			System.out.println("Puede leerse: " + f.canRead());
			System.out.println("Puede escribirse " + f.canWrite());
		
		} else {
			
			String[] losArchivos = f.list();
			System.out.println("El directorio " + ruta + " contiene:");
			for(String archivo : losArchivos) {
				System.out.println("\t" + archivo);
			}
		}
		
		
	} else {
		
		System.out.println("El fichero o ruta no existe");
	}

}
}
