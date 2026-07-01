package model;

import java.util.List;
import java.util.StringJoiner;

public class Arquero extends Personaje{
    private int flechas;


    public Arquero(String nombre) {
        super(nombre);
        this.flechas = 4;
    }

    //Ataca a un enemigo y le provoca 20 de daño
    public void atacar(Personaje enemigo){
        if (!estaVivo())return;
        if(!enemigo.estaVivo())return;

        enemigo.recibirDanio(20);
        agregarPuntosProvocados(20);

    }

    //Hace 30 da daño a todos los enemigo y Resta una flecha
    public void ataqueGrupal(List<Personaje> enemigos){
        if (!estaVivo())return;
        int dañoAcc = 0;
        for (Personaje personaje : enemigos){
            if (!personaje.estaVivo())continue;
            personaje.recibirDanio(30);
            dañoAcc += 30;
        }
        if (dañoAcc > 0) flechas--;
        agregarPuntosProvocados(dañoAcc);
    }

    public int getFlechas() {
        return flechas;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Arquero.class.getSimpleName() + "[", "]")
                .add("flechas=" + flechas)
                .add("nombre='" + nombre + "'")
                .add("vida=" + vida)
                .add("rango=" + rango)
                .add("puntosProvocados=" + puntosProvocados)
                .toString();
    }
}
