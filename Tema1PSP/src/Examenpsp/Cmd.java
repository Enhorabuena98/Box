package Examenpsp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Cmd {

	public static void main(String[] args) {
		try {
			ProcessBuilder pb1 = new ProcessBuilder("ipconfig");
			Process p1 = pb1.start();
			
			ProcessBuilder pb2 = new ProcessBuilder("findstr","Ethernet");
			Process p2 = pb2.start();
			
			BufferedReader br1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
			OutputStream p2Out = p2.getOutputStream();
			
			String linea = "";
			while ((linea = br1.readLine())!= null) {
				p2Out.write((linea + System.lineSeparator()).getBytes());
				System.out.println("Mandando a findstr: " + linea);
			}
			p2Out.close();
			
			BufferedReader br2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
			while ((linea = br2.readLine())!= null) {
				System.out.println("Findstr: " + linea);
			}
			p1.waitFor();
			p2.waitFor();
		} catch (Exception e) {
		System.out.println(e);}
	}

}
