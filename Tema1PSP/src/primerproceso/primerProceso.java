package primerproceso;

import java.io.IOException;

public class primerProceso {

	
	public static void main(String[] args) throws IOException {
		
		ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", "http:\\www.google.es");
		
		Process p1=pb.start();
		Process p2=pb.start();
		
		System.out.println("PID del proceso 1:" +p1.pid());
		System.out.println("PID del proceso 2:" +p2.pid());

		}
}
