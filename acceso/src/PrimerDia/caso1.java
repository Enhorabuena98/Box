package PrimerDia;

import  java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class caso1 {

	public static void main(String[] args) {
		
		int a, e, i, o, u;
		a = e = i = o = u = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Por favor , ingrese una ruta: ");
		String ruta = sc.nextLine();
		
		System.out.println("La ruta que ingresaste es :" + ruta);
		
		sc.close();
		
		if(ruta.length()==0) {
			
			System.out.println("No se proporcionó la ruta del archivo");
			System.exit(1);
		}
		
		
			FileReader fr = null;
			File f = new File(ruta);
			if(!f.exists()) {
				System.out.println("El archivo no existe");
				System.exit(1);
			
			}
			try {
				fr = new FileReader(f);
			
			
		int c;
		while((c=fr.read())!= -1) {
			//System.out.println("la c es : " + c);
			
			char letra =(char) c;
			//System.out.println("la c es : " + letra);
			if(letra == 'a' || letra =='A') {
				a++;
			}
			if(letra == 'e' || letra =='E') {
				e++;
			}
			if(letra == 'i' || letra =='I') {
				i++;
			}
			if(letra == 'o' || letra =='O') {
				o++;
			}
			if(letra == 'u' || letra =='U') {
				u++;
			}
		
			
		}
		System.out.println("El numero de aes es " +a);
		System.out.println("El numero de es es " +e);
		System.out.println("El numero de ies es " +i);
		System.out.println("El numero de oes es " +o);
		
		
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}

}
