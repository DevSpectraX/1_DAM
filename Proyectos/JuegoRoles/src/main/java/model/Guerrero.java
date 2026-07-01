package model;

import java.util.List;
import java.util.StringJoiner;

public class Guerrero extends Personaje{
    private int potenciador;


    public Guerrero(String nombre) {
        super(nombre);
        this.potenciador = 2;
    }

    //Ataca a un enemigo y le provoca 50 de daño
    public void atacar(Personaje enemigo){
        if (!estaVivo())return;
        if (!enemigo.estaVivo())return;

        enemigo.recibirDanio(50);
        agregarPuntosProvocados(50);
    }

    //Ataca a todos los enemigos y le quita 50% de vida y consume un potenciador
    public void ataqueGrupal(List<Personaje> enemigos){
        if (!estaVivo())return;
        if (potenciador <= 0) return;
        int dañoAcc = 0;
        for (Personaje personaje : enemigos){
            if (!personaje.estaVivo())continue;
            int daño = personaje.getVida()/2;

            personaje.recibirDanio(daño);
            dañoAcc += daño;

        }
        potenciador --;
        agregarPuntosProvocados(dañoAcc);

    }

    public int getPotenciador() {
        return potenciador;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Guerrero.class.getSimpleName() + "[", "]")
                .add("potenciador=" + potenciador)
                .add("nombre='" + nombre + "'")
                .add("vida=" + vida)
                .add("rango=" + rango)
                .add("puntosProvocados=" + puntosProvocados)
                .toString();
    }
}
