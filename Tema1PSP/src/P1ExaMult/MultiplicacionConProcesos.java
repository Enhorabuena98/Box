package P1ExaMult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplicacionConProcesos {
    

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: java MultiplicacionConProcesos <inicio> <fin>");
            System.exit(1);
        }
        long inicio = Long.parseLong(args[0]);
        long fin = Long.parseLong(args[1]);
     
        if (inicio > fin) {
            long temp = inicio;
            inicio = fin;
            fin = temp;
        }

        
        
        
        int cantidadProcesos = Runtime.getRuntime().availableProcessors();
        

        long intervalo = (fin - inicio + 1) / cantidadProcesos;
        System.out.println("tamaño de la particion"+intervalo);
        BufferedReader[] bReaders = new BufferedReader[cantidadProcesos];
        int brpos = 0;

        try {
            for (int i = 0; i < cantidadProcesos; i++) {
                long subInicio = inicio + i * intervalo;
                long subFin = subInicio + intervalo - 1;
                if (i == cantidadProcesos - 1) {
                    subFin = fin;
                }
                System.out.println("Lanzando proceso " + i + ": " + subInicio + "-" + subFin);
                bReaders[brpos] = lanzarSubproceso(subInicio, subFin);
                brpos++;
                System.out.println("Iniciando proceso: " + (i + 1)+ " ");
            }

            long multiplicacionTotal = 1;
            for (BufferedReader br : bReaders) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    multiplicacionTotal *= Long.parseLong(linea);
                    System.out.println("Resultado del subproceso: " + multiplicacionTotal);

                }
            }

            System.out.println("Multiplicación total: " + multiplicacionTotal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static BufferedReader lanzarSubproceso(long inicio, long fin) {
        ProcessBuilder pb = new ProcessBuilder("java", "C:\\Users\\DELL\\eclipse-workspace\\Tema1PSP\\src\\P1ExaMult\\MultiplicacionSimple.java", Long.toString(inicio), Long.toString(fin));

        try {
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            return br;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
