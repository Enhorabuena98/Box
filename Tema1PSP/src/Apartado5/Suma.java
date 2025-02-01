package Apartado5;

public class Suma {

    public static void main(String[] args) {

        // Si no se proporcionan dos argumentos, cerramos la aplicación
        if (args.length != 2) {
            System.out.println("Debe proporcionar dos argumentos.");
            System.exit(-1);
        }

        Long num1, num2;
        Long suma = 0L;

        // Convertimos los argumentos a Long y los ordenamos correctamente
        if (Long.parseLong(args[0]) > Long.parseLong(args[1])) {
            num1 = Long.parseLong(args[1]);
            num2 = Long.parseLong(args[0]);
        } else {
            num1 = Long.parseLong(args[0]);
            num2 = Long.parseLong(args[1]);
        }

        // Sumamos los números desde num1 hasta num2
        for (Long i = num1; i <= num2; i++) {
            suma += i;

            // Si quieres agregar una pausa para simular un proceso más largo, descomenta el bloque siguiente:
            /*
            try {
                Thread.sleep(10); // Pausa de 10ms entre iteraciones
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            */
        }

        // Mostramos el resultado final
        System.out.println(suma);
    }
}
