package Apartado4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class CasoPractico4 {

    public static void main(String[] args) {
        try {
            // Crear el primer proceso: ipconfig
            ProcessBuilder pb1 = new ProcessBuilder("ipconfig");
            Process p1 = pb1.start();
            
            // Crear el segundo proceso: findstr Ethernet
            ProcessBuilder pb2 = new ProcessBuilder("findstr", "Ethernet");
            Process p2 = pb2.start();

            // Leer la salida del primer proceso
            BufferedReader br = new BufferedReader(new InputStreamReader(p1.getInputStream()));
            OutputStream p2Out = p2.getOutputStream();

            String linea = "";
            while ((linea = br.readLine()) != null) {
                // Escribir la salida del primer proceso en la entrada del segundo
                p2Out.write((linea + System.lineSeparator()).getBytes());
            //    p2Out.flush(); // Asegurarse de que los datos se envíen inmediatamente

                System.out.println("Redirigiendo a findstr: " + linea);
            }

            // Cerrar la salida del segundo proceso para indicar que no hay más datos
            p2Out.close();

            // Leer la salida del segundo proceso y mostrarla en la consola
            BufferedReader br2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
            while ((linea = br2.readLine()) != null) {
                System.out.println("Resultado del filtro findstr: " + linea);
            }

            // Esperar a que ambos procesos terminen
            p1.waitFor();
            p2.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
