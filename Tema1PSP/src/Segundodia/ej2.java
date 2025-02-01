package Segundodia;

import java.io.File;

public class ej2 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Debe especificar una ruta.");
            return;
        }

        String ruta = args[0];
        String extensionFiltro = args.length > 1 ? args[1] : null;
        
        File f = new File(ruta);
        
        if (!f.exists()) {
            System.out.println("La ruta especificada no existe.");
            return;
        }

        if (f.isFile()) {
            System.out.println("Es un archivo y su tamaño es " + f.length() + " bytes.");
        } else {
            System.out.println("Es un directorio, listando contenido...");
            listarElementos(f, extensionFiltro);
        }
    }

    public static void listarElementos(File directorio, String extensionFiltro) {
        File[] elementos = directorio.listFiles();

        if (elementos == null || elementos.length == 0) {
            System.out.println("El directorio está vacío.");
            return;
        }

        for (File elemento : elementos) {
            if (elemento.isFile()) {
                if (extensionFiltro == null || elemento.getName().toLowerCase().endsWith(extensionFiltro.toLowerCase())) {
                    System.out.println("Archivo: " + elemento.getName() + " (" + elemento.length() + " bytes)");
                }
            } else if (elemento.isDirectory()) {
                System.out.println("Directorio: " + elemento.getName());
                listarElementos(elemento, extensionFiltro);
            }
        }
    }
}
