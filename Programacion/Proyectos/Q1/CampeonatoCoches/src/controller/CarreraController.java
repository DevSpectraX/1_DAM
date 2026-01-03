package controller;

import model.Carrera;
import model.Coche;


/*Lógica de simulacion de carreras*/
public class CarreraController {


    public static void simularCarrera(Carrera carrera){
        boolean carreraTerminada = false;
        int kmRecorridos = 0;

        for (Coche coche : carrera.getParticipantes())
        {
            coche.setKm(0);
        }

        do {
            for (Coche coche : carrera.getParticipantes())
            {
                kmRecorridos =(int) (Math.random() * (50 - 20 +1)+ 20);
                coche.setKm(coche.getKm() + kmRecorridos);
            }

            for (Coche coche : carrera.getParticipantes())
            {
                if (coche.getKm() >= carrera.getKmCarrera()){
                    carreraTerminada = true;
                    break;
                }
            }

        }while (!carreraTerminada);

        //Gestionar desempate por número de dorsal
        carrera.getParticipantes().sort((coche1, coche2) -> {
            int diffKm = coche2.getKm() - coche1.getKm();
            if (diffKm == 0){
                return coche1.getDorsal() - coche2.getDorsal();
            }
            return diffKm;
        });


        //Asignar puntos segun su orden
        carrera.getParticipantes().get(0).setPuntos(
                carrera.getParticipantes().get(0).getPuntos() + 10
        );

        carrera.getParticipantes().get(1).setPuntos(
                carrera.getParticipantes().get(1).getPuntos() + 8
        );

        carrera.getParticipantes().get(2).setPuntos(
                carrera.getParticipantes().get(2).getPuntos() + 6
        );

    };
}
