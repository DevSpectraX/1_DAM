package model;

import java.io.Serializable;
import java.util.StringJoiner;

public abstract class Personaje implements Serializable {
    private static final long serialVersionUID = 1L;
    protected static final int VIDA_MAXIMA = 100;

    protected String nombre;
    protected int vida;
    protected int rango;
    protected int puntosProvocados;

    public Personaje(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }

        this.nombre = nombre;
        this.vida = VIDA_MAXIMA;
        this.rango = 1;
        this.puntosProvocados = 0;
    }


    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public int getVida(){
        return vida;
    }

    public int getRango(){
        return rango;
    }

    public int getPuntosProvocados(){
        return puntosProvocados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean estaVivo(){
        return vida > 0;
    }
    public int agregarPuntosProvocados(int puntos){
        puntosProvocados += puntos;
        while (puntosProvocados >= VIDA_MAXIMA){
            rango ++;
            puntosProvocados -= VIDA_MAXIMA;
        }
        return puntosProvocados;
    }
//Metodo sumar vida al curar
    public void sumarVida(int puntosCurar){
        if (!estaVivo())return;
        if (puntosCurar < 0)return;

        this.vida = Math.min(VIDA_MAXIMA, this.vida + puntosCurar);
    }

    public void recibirDanio(int cantidad){
        if (cantidad < 0) return;
        this.vida = Math.max(0, this.vida - cantidad);
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", Personaje.class.getSimpleName() + "[", "]")
                .add("nombre='" + nombre + "'")
                .add("vida=" + vida)
                .add("rango=" + rango)
                .add("puntosProvocados=" + puntosProvocados)
                .toString();
    }
}