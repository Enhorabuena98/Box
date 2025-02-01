package cp3;

import java.io.BufferedReader;
import java.io.IOException;

public class Leer {
    private final static BufferedReader entradaConsola = 
        new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

/*
//Llig un text del teclat.
//@param mensaje Text que es passa a l'usuaro
@return el texto en caso de error
*/
public static String leerTexto(String mensaje) {
    String respuesta=null;
    do{
        try {
            System.out.print(mensaje);
            respuesta= entradaConsola.readLine();
        } // ()
        catch (IOException ex) {
            return "";
        }
    } while(respuesta ==null);
    return respuesta;

} // ()


/*
Introducció de numeros enters
@param mensaje Missatge que es dona a l'usuari
@return un enter amb el valor
*/
public static int leerEntero(String mensaje) {
    int n=0;
    boolean conseguido=false;
    while(!conseguido){
        try{
            n= Integer.parseInt(leerTexto(mensaje));
            conseguido=true;
        }
        catch(NumberFormatException ex){
            System.out.println("debes poner un numero correcto");
        }
    }
    return n;
}

/*
Introducció de numeros enters
@param mensaje Missatge que es dona a l'usuari
@return un enter amb el valor
*/
public static double leerDouble(String mensaje) {
    double n=0.0;
    boolean conseguido=false;
    while(!conseguido){
        try{
            n= Double.parseDouble(leerTexto(mensaje));
            conseguido=true;
        }
        catch(NumberFormatException ex){
            System.out.println("debes poner un numero correcto");
        }
    }
    return n;
}

}
