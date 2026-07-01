package model;

import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

public class Soldado extends Personaje{
    private int curacionesDisponibles;

    public Soldado(String nombre) {
        super(nombre);
        this.curacionesDisponibles = 4;
    }

    //Quita entre 10 y 20 puntos de daño a un enemigo
    public void atacar(Personaje enemigo){
        if(!estaVivo())return;
        int daño = ThreadLocalRandom.current().nextInt(10, 21);
        enemigo.recibirDanio(daño);
        agregarPuntosProvocados(daño);
    }
    public void curar (Personaje aliado){

        if (!estaVivo())return;
        if (!aliado.estaVivo())return;
        if (curacionesDisponibles <= 0)return;
        if (getVida() <= 10)return;

        aliado.sumarVida(20);
        recibirDanio(10);
        curacionesDisponibles --;
        agregarPuntosProvocados(20);

    }

    public int getCuracionesDisponibles() {
        return curacionesDisponibles;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Soldado.class.getSimpleName() + "[", "]")
                .add("curacionesDisponibles=" + curacionesDisponibles)
                .add("nombre='" + nombre + "'")
                .add("vida=" + vida)
                .add("rango=" + rango)
                .add("puntosProvocados=" + puntosProvocados)
                .toString();
    }
}
