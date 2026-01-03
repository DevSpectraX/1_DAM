package controller;

import model.Campeonato;
import model.Carrera;
import model.Coche;

import java.util.ArrayList;

import static view.Main.pedirKmCarrera;

/*Coordina múltiples carreras y acumula puntos*/
public class CampeonatoController {

    public static void mostrarClasificacionGeneral(ArrayList<Coche> coches){
        //Ordenar coches por puntos
        coches.sort((coche1, coche2) -> coche2.getPuntos() - coche1.getPuntos());

        System.out.println("===CLASIFICACIÓN GENERAL===");
        for (int i = 0; i < coches.size(); i++) {
            Coche coche = coches.get(i);
            System.out.println((i + 1) + "º" + "\t" + coche.getMarca() + " " + coche.getModelo() + "\tDorsal: " + coche.getDorsal() + "\tPuntos: " + coche.getPuntos());
            System.out.println();
        }

    }
    public static void mostrarPodio(ArrayList<Coche> podio){
        System.out.println("===PODIO DE LA CARRERA===");
        for (int i = 0; i < 3; i++) {
            Coche coche = podio.get(i);
            System.out.println((i+1) + "º" + "\t" + coche.getMarca() + " " + coche.getModelo() + "\tDorsal: " + coche.getDorsal() + "\tPuntos: " + coche.getPuntos());
            System.out.println();
        }
    };
    public static void ejecutarCampeonato(Campeonato campeonato) {
        ArrayList<Coche> participantes = campeonato.getParticipantes();
        int nCarreras = campeonato.getnCarreras();
        for (int i = 1; i <= nCarreras; i++) {
            System.out.println("===CARRERA " + i + "===");

            int kmCarrera = pedirKmCarrera();

            // Crear carrera y simular
            Carrera carrera = new Carrera(participantes, kmCarrera);
            CarreraController.simularCarrera(carrera);

            // Mostrar podio
            CampeonatoController.mostrarPodio(carrera.getParticipantes());

            // Mostrar clasificación provisional
            System.out.println("Puntos totales después de la carrera " + i + ":");
            mostrarClasificacionGeneral(participantes);
        }
    }
}
