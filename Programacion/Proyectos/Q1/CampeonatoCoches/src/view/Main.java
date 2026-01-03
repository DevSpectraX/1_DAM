package view;

import model.Campeonato;
import model.Coche;

import java.util.ArrayList;
import java.util.Scanner;

import static controller.CampeonatoController.ejecutarCampeonato;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Bienvenido al campeonato de carreras de DTM");
        System.out.println("Introduzca el número de coches que van a participar");
        int nCoches = scanner.nextInt();
        scanner.nextLine();

        //Crear la lista de coches
        ArrayList<Coche> listaCoches = new ArrayList<>();

        for (int i = 0; i < nCoches; i++) {
            String marca = pedirMarca(i);
            String modelo = pedirModelo(i);
            int dorsal = i + 1;
            Coche coche = new Coche(marca, modelo ,dorsal);
                    listaCoches.add(coche);

        }

        //Pedir número de carreras
        int nCarreras = pedirNumeroCarreras();

        //Hacer carreras

        Campeonato campeonato = new Campeonato(listaCoches, nCarreras);
        ejecutarCampeonato(campeonato);
    }

//Metodos de entrada de datos
    public static String pedirMarca(int i) {
        String marca = "";
        while (marca.isEmpty()) {
            System.out.println("Introduce la marca para el coche " + (i + 1) + ": ");
            marca = scanner.nextLine();
        }
        return marca;
    };
    public static String pedirModelo(int i){
        String modelo = "";
        while (modelo.isEmpty()){
        System.out.println("Introduce el modelo para el coche "+ (i + 1)+ ": ");
        modelo = scanner.nextLine();
        }
        return modelo;

    };

    public static int pedirNumeroCarreras(){
        int nCarreras = 0;
        do {
            System.out.println("Introduce cuantas carreras quieres que tenga el campeonato: ");
            nCarreras = scanner.nextInt();
            scanner.nextLine();
            if (nCarreras < 1){
                System.out.println("Debes de introducir más cantidad de carreras.");
            };

        }while (nCarreras < 1);
        return nCarreras;
    };
    public static int pedirKmCarrera() {
        int kmCarrera = 0;
        do {
            System.out.println("Introduce los km para esta carrera: ");
            kmCarrera = scanner.nextInt();
            scanner.nextLine();
            if (kmCarrera < 20){
                System.out.println("Debes introducir unos km válidos");
            }
        }
        while (kmCarrera < 20);



        return kmCarrera;
    }
}
