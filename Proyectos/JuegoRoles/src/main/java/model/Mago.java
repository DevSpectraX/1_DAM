package model;

import enums.EspecialidadMagia;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;


//El mago blanco hara poco daño pero curará más, el negro viceversa

public class Mago extends Personaje{

    private EspecialidadMagia especialidadMagia;
    private int hechizosDisponibles;

    public Mago(String nombre, EspecialidadMagia especialidad) {
        super(nombre);
        this.especialidadMagia = especialidad;
        this.hechizosDisponibles = 4;
    }

    //Cura a un personaje elegido pts aleatorios(entre 70 y 100pts si es blanco y entre 40 y 70 si es negro)
    public void curar(Personaje personaje){
        if (estaVivo() && personaje.estaVivo()){
            int puntosCurar = 0;
            if (especialidadMagia == EspecialidadMagia.BLANCA){
                puntosCurar = ThreadLocalRandom.current().nextInt(70,101);
            } else if (especialidadMagia == EspecialidadMagia.NEGRA) {
                puntosCurar = ThreadLocalRandom.current().nextInt(40,71);
            }
            agregarPuntosProvocados(puntosCurar);
            personaje.sumarVida(puntosCurar);
        }
    }

    //Cura a todos los aliados
    public void conjuroSanacionMax(List<Personaje> aliado){
        if (!estaVivo()) return;
        if (hechizosDisponibles <= 0) return;

        int vidaCurada = 0;

        for (Personaje personaje : aliado) {
            if (personaje.estaVivo()) {
                 int vidaFalta = VIDA_MAXIMA - personaje.getVida();

                if (vidaFalta > 0) {


                    personaje.sumarVida(vidaFalta);
                    vidaCurada += vidaFalta;
                }
            }
        }
        agregarPuntosProvocados(vidaCurada);
            hechizosDisponibles--;

    }



    //Quita 25pts a todos los enemigos si el mago es blanco y 45 si es negro
    public void hechizo(List<Personaje> enemigo) {
        if (!estaVivo() || hechizosDisponibles == 0) return;
        int danioProvocado = 0;
        int danioHechizo = (especialidadMagia == EspecialidadMagia.BLANCA) ? 25 : 45;


        for (Personaje personaje : enemigo) {
            if (personaje.estaVivo()) {
                personaje.recibirDanio(danioHechizo);
                danioProvocado += danioHechizo;
            }
        }

        agregarPuntosProvocados(danioProvocado);

        hechizosDisponibles--;
    }

    public EspecialidadMagia getEspecialidadMagia() {
        return especialidadMagia;
    }

    public int getHechizosDisponibles() {
        return hechizosDisponibles;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Mago.class.getSimpleName() + "[", "]")
                .add("nombre='" + getNombre() + "'")
                .add("vida=" + getVida())
                .add("rango=" + getRango())
                .add("puntosProvocados=" + getPuntosProvocados())
                .add("especialidadMagia=" + especialidadMagia)
                .add("hechizosDisponibles=" + hechizosDisponibles)
                .toString();
    }

}


