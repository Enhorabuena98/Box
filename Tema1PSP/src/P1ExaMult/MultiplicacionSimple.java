package P1ExaMult;

public class MultiplicacionSimple {

	public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: java MultiplicacionSimple <inicio> <fin>");
            System.exit(1);
        }

        long inicio = Long.parseLong(args[0]);
        long fin = Long.parseLong(args[1]);

        long multiplicacion = 1;
        for (Long i=inicio; i<=fin; i++){
            multiplicacion *= i;
        }

        System.out.println(multiplicacion);
    }
}

