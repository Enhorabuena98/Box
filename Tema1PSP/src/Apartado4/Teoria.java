package Apartado4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Teoria {

	public static void main(String[] args) {
		try {
		
		ProcessBuilder pb = new ProcessBuilder("ping","192.168.200.97");	
		Process p = pb.start();
		
		//Primera manera en una sola linea
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		
		//Segunda manera en diferentes lineas
		InputStream is = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br2 = new BufferedReader(isr);
		
		String linea ="";
		while((linea = br.readLine()) !=null) {
			System.out.println(linea);
		}
		
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
