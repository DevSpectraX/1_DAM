package model;

import java.util.ArrayList;

/*Representa una carrera individual
Contiene una lista de coches que participan*/
public class Carrera {
    public ArrayList<Coche> participantes;
    public int kmCarrera;


    public Carrera(ArrayList<Coche> participantes, int kmCarrera){
        this.participantes = participantes;
        this.kmCarrera = kmCarrera;
    };


    public ArrayList<Coche> getParticipantes() {
        return participantes;
    }


    public int getKmCarrera() {
        return kmCarrera;
    }

}

