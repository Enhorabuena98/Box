package primerproceso;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class proceso3teclado {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		String[]fileNames = new String[3];
		
		for (int i = 0; i < 3; i++) {
			System.out.println("ruta del ejecutable " + (i + 1) + ":");
			fileNames[i] = sc.nextLine();
		}
		
		ProcessBuilder pb = new ProcessBuilder();
		for (int index = 0; index < 3; index++) {
			try {
				pb.command(fileNames[index]);
				Process p = pb.start();
				System.out.println("Lanzando el proceso " + fileNames[index] + "con PID " +p.pid() + " en " + p.info().startInstant().toString());
				TimeUnit.SECONDS.sleep(3);
				p.destroy();
			} catch (IOException e) {
					e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sc.close();
		
	}

}
