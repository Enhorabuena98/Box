package EntregableHilos;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CalculadoraFactorial {

    public static BigInteger calcularFactorial(int numero) throws InterruptedException, ExecutionException {
        // Determinar el número de procesadores disponibles
        int numeroProcesadores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numeroProcesadores);

        // Dividir el cálculo del factorial entre los hilos
        int tamanioPorHilo = numero / numeroProcesadores;
        List<Future<BigInteger>> resultados = new ArrayList<>();

        // Crear y enviar las tareas
        for (int i = 0; i < numeroProcesadores; i++) {
            int inicio = i * tamanioPorHilo + 1;
            int fin = (i == numeroProcesadores - 1) ? numero : inicio + tamanioPorHilo - 1;

            resultados.add(executor.submit(new TareaFactorial(inicio, fin)));
        }

        // Recolectar los resultados y calcular el factorial total
        BigInteger factorial = BigInteger.ONE;
        for (Future<BigInteger> resultado : resultados) {
            factorial = factorial.multiply(resultado.get());
        }

        executor.shutdown();
        return factorial;
    }
}

class TareaFactorial implements Callable<BigInteger> {
    private final int inicio;
    private final int fin;

    public TareaFactorial(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public BigInteger call() {
        BigInteger resultado = BigInteger.ONE;
        for (int i = inicio; i <= fin; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
        return resultado;
    }
}
