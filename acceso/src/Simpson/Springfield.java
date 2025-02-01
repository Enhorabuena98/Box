package Simpson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Springfield {
    private static final String nombreFicheroIn = "./simpsons.csv";
    private static final String nombreFicheroOut1 = "./simpsonsAltos.csv";
    private static final String nombreFicheroOut2 = "./simpsonsBajos.csv";

    public static void main(String[] args) {
        ArrayList<Simpsons> simpsons;
        simpsons = importar(nombreFicheroIn);
        for (Simpsons simpson : simpsons) {
            System.out.println(simpson);
        }
        exportarAltos(nombreFicheroOut1, simpsons);
        exportarBajos(nombreFicheroOut2, simpsons);
    }

    private static ArrayList<Simpsons> importar(String nombre) {
        ArrayList<Simpsons> simpsons = new ArrayList<>();
        File f = new File(nombre);

        try (BufferedReader bfr = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = bfr.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 6) {
                    Simpsons s = new Simpsons(
                        partes[0],                          // nombre
                        partes[1],                          // apellido
                        partes[5],                          // familia
                        Integer.parseInt(partes[2]),        // numCap
                        Integer.parseInt(partes[3]),        // edad
                        Double.parseDouble(partes[4])       // altura
                    );
                    simpsons.add(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return simpsons;
    }

    private static void exportarAltos(String nom, ArrayList<Simpsons> simpsons) {
        try (BufferedWriter bfw = new BufferedWriter(new FileWriter(new File(nom)))) {
            for (Simpsons simpson : simpsons) {
                if (simpson.simpsonsAltos()) {
                    bfw.write(simpson.toCSV());
                    bfw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void exportarBajos(String nom, ArrayList<Simpsons> simpsons) {
        try (BufferedWriter bfw = new BufferedWriter(new FileWriter(new File(nom)))) {
            for (Simpsons simpson : simpsons) {
                if (simpson.simpsonsBajos()) {
                    bfw.write(simpson.toCSV());
                    bfw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
