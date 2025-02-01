package Tarea1;

import java.io.Serializable;

public class Pokemon implements Serializable {
    private String nombre;
    private String tipo;
    private int nivel;
    private double puntosDeVida;

    public Pokemon(String nombre, String tipo, int nivel, double puntosDeVida) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.puntosDeVida = puntosDeVida;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public double getPuntosDeVida() {
        return puntosDeVida;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nivel=" + nivel +
                ", puntos de vida=" + puntosDeVida +
                '}';
    }
}
