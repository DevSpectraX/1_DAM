package model;

import java.util.ArrayList;

/*Representa un conjunto de carreras con acumulacion
de puntos y clasificacion general*/
public class Campeonato {
    private ArrayList<Coche> participantes;
    private int nCarreras;

    public Campeonato(ArrayList<Coche> participantes, int nCarreras){
        this.participantes = participantes;
        this.nCarreras = nCarreras;
    }


    public ArrayList<Coche> getParticipantes() {
        return participantes;
    }



    public int getnCarreras() {
        return nCarreras;
    }


}
