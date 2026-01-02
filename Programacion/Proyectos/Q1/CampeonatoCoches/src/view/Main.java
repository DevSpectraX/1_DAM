package view;

import model.Coche;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Bienvenido al campeonato de carreras de Rally");
        System.out.println("Introduzca el número de coches que van a participar");
        int nCoches = scanner.nextInt();

        //Crear la lista de coches
        ArrayList<Coche> listaCoches = new ArrayList<>();

        for (int i = 0; i < nCoches; i++) {
            String marca = pedirMarca(i);
            String modelo = pedirModelo(i);
            int dorsal = i;
            Coche coche = new Coche(marca, modelo ,dorsal);
                    listaCoches.add(coche);

        }

        int nCarreras = pedirNumeroCarreras();

        for (int i = 0; i < nCarreras; i++) {
            System.out.println("===CARRERA " + i + " ===");
            int kmCarrera = pedirKmCarrera();

        }



/*Main (Vista)
  |
  |--> Pide número de coches
  |--> Pide datos de cada coche
  |--> Crea objetos Coche
  |--> Llama a CarreraController.simularCarrera(listaCoches, kmCarrera)
        |
        |--> CarreraController actualiza km y puntos
        |--> Devuelve resultados
  |--> Main muestra resultados en consola*/
    }

//Metodos de entrada de datos
    public static String pedirMarca(int i) {
        String marca = "";
        while (marca.isEmpty()) {
            System.out.println("Introduce la marca para el coche " + i + ": ");
            marca = scanner.nextLine();
        }
        return marca;
    };
    public static String pedirModelo(int i){
        String modelo = "";
        while (modelo.isEmpty()){
        System.out.println("Introduce el modelo para el coche "+ i + ": ");
        modelo = scanner.nextLine();
        }
        return modelo;

    };

    public static int pedirNumeroCarreras(){
        int nCarreras = 0;
        do {
            System.out.println("Introduce cuantas carreras quieres que tenga el campeonato: ");
            nCarreras = scanner.nextInt();
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
            if (kmCarrera < 1){
                System.out.println("Debes introducir unos km válidos");
            }
        }
        while (kmCarrera < 1);



        return kmCarrera;
    }


}
