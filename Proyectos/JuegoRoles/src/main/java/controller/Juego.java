package controller;

import enums.EspecialidadMagia;
import model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Juego {
    private Equipo equipoA;
    private Equipo equipoB;
    private Scanner scanner;
    private GestorFicheros gestorFicheros;

    public Juego() {
        this.equipoA = new Equipo("A");
        this.equipoB = new Equipo("B");
        this.scanner = new Scanner(System.in);
        this.gestorFicheros = new GestorFicheros();

    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Agregar personaje");
            System.out.println("2. Listar equipos");
            System.out.println("3. Buscar personaje");
            System.out.println("4. Comenzar juego");
            System.out.println("5. Guardar partida");
            System.out.println("6. Cargar partida");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");


            try {

                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1 -> agregarPersonaje();
                    case 2 -> listarEquipos();
                    case 3 -> buscarPersonaje();
                    case 4 -> comenzarJuego();
                    case 5 -> guardarPartida();
                    case 6 -> cargarPartida();
                    case 7 -> {
                        salir = true;
                        System.out.println("¡Hasta luego!");
                    }
                    default -> System.out.println("Opción no válida");
                }
            }catch (InputMismatchException e){
                System.out.println("No es un caracter válido, porfavor vuelve a elegir una opción");
                scanner.nextLine();
            }
        }
    }


    private void agregarPersonaje() {
        Equipo equipo = seleccionarEquipo();
        if (equipo == null) return;

        String tipo = seleccionarTipo(equipo);
        if (tipo == null) return;

        String nombre = pedirNombre();
        Personaje nuevo = crearPersonaje(tipo, nombre);
        if (nuevo == null) return;

        equipo.agregar(nuevo);
        System.out.println(tipo + " '" + nombre +
                "' agregado al equipo " + equipo.getNombre());
    }

    private void listarEquipos(){
        System.out.println("\n=== LISTADO DE EQUIPOS ===");
        equipoA.mostrar();
        equipoB.mostrar();
    }

    private void buscarPersonaje(){
        System.out.println("\n=== BUSCAR PERSONAJE ===");
        System.out.print("Nombre a buscar: ");
        String busqueda = scanner.nextLine().toLowerCase();
        System.out.println("\nResultados: ");
        boolean encontrado = false;

        //Buscar equipoA
        for (Personaje personaje : equipoA.getIntegrantes()){
            if (personaje.getNombre().toLowerCase().contains(busqueda)){
                System.out.println("[Equipo A] " + personaje);
                encontrado = true;
            }
        }

        //Buscar equipoB

        for (Personaje personaje : equipoB.getIntegrantes()){
            if (personaje.getNombre().toLowerCase().contains(busqueda)){
                System.out.println("[Equipo B] " + personaje);
                encontrado = true;
            }
        }

        if (!encontrado){
            System.out.println("No se encontraron personajes con '" + busqueda + "'");

        }
    }

    private void comenzarJuego() {
        // Validar que ambos equipos tengan personajes
        if (equipoA.estaVacio() || equipoB.estaVacio()) {
            System.out.println("¡Ambos equipos deben tener al menos 1 personaje!");
            return;
        }

        System.out.println("\n¡COMIENZA EL JUEGO!");
        boolean turnoEquipoA = true;

        while (!equipoA.todosMuertos() && !equipoB.todosMuertos()) {
            Equipo equipoActual = turnoEquipoA ? equipoA : equipoB;
            Equipo equipoRival = turnoEquipoA ? equipoB : equipoA;

            System.out.println("\n=== TURNO: Equipo " + equipoActual.getNombre() + " ===");
            jugarTurno(equipoActual, equipoRival);

            // Mostrar estado después del turno
            equipoA.mostrar();
            equipoB.mostrar();

            //Mostrar guardado
            System.out.println("\n¿Deseas guardar la partida? (s/n)");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")){
                guardarPartida();
            }

            //Hacer una pausa para que vean el estado
            System.out.print("Presion ENTER para continuar");
            scanner.nextLine();

            // Cambiar turno
            turnoEquipoA = !turnoEquipoA;
        }

        // Determinar ganador
        if (equipoA.todosMuertos()) {
            System.out.println("\n🏆 ¡El Equipo B gana!");
        } else {
            System.out.println("\n🏆 ¡El Equipo A gana!");
        }
    }


    private void jugarTurno(Equipo equipoActual, Equipo equipoRival){
        //Mostrar personajes vivos

        List<Personaje> vivos = new ArrayList<>();
        System.out.println("\nPersonajes disponibles:");
        int i = 1;
        for (Personaje personaje : equipoActual.getIntegrantes()){
            if (personaje.estaVivo()){
                System.out.println(
                        i + ". " +
                        personaje.getNombre() + " ("+
                        personaje.getClass().getSimpleName() + ") - Vida: " +
                        personaje.getVida());

                vivos.add(personaje);
                i++;
            }
        }

        //Seleccionar personaje

        System.out.println("Seleccionar un personaje: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine();

        if (seleccion < 1 || seleccion > vivos.size()){
            System.out.println("Selección no válida");
        }

        Personaje elegido = vivos.get(seleccion-1);
        System.out.println("\nHas elegio a " + elegido.getNombre());

        mostrarAcciones(elegido, equipoRival, equipoActual);
    }

    private void mostrarAcciones(Personaje elegido, Equipo equipoRival, Equipo equipoActual){
        if (elegido instanceof Mago mago){
            accionesMago(mago, equipoRival, equipoActual);
        } else if (elegido instanceof Soldado soldado) {
            accionesSoldado(soldado, equipoRival, equipoActual);
        } else if (elegido instanceof Arquero arquero) {
            accionesArquero(arquero, equipoRival);
        } else if (elegido instanceof Guerrero guerrero) {
            accionesGuerrero(guerrero, equipoRival);
        }
    }
    private void accionesMago(Mago mago, Equipo equipoRival, Equipo equipoActual){
        System.out.println("\nAcciones disponibles:");
        System.out.println("1. Curar personaje");
        System.out.println("2. Conjuro de sanación (curar todos)");
        System.out.println("3. Hechizo (dañar todos los enemigos)");
        System.out.print("Selecciona: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1 -> {
                Personaje objetivo = seleccionarObjetivo(equipoActual.getIntegrantes(), "aliado");
                if (objetivo != null) mago.curar(objetivo);
            }
            case 2 -> mago.conjuroSanacionMax(equipoActual.getIntegrantes());
            case 3 -> mago.hechizo(equipoRival.getIntegrantes());
            default -> System.out.println("Opción no válida");
        }

    }

    private void accionesSoldado(Soldado soldado, Equipo equipoRival, Equipo equipoActual){
        System.out.println("\nAcciones disponibles:");
        System.out.println("1. Atacar enemigo");
        System.out.println("2. Curar aliado");
        System.out.print("Selecciona: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1 -> {
                Personaje objetivo = seleccionarObjetivo(equipoRival.getIntegrantes(), "enemigo");
                if (objetivo != null) soldado.atacar(objetivo);
            }
            case 2 -> {
                Personaje objetivo = seleccionarObjetivo(equipoActual.getIntegrantes(), "aliado");
                if (objetivo != null) soldado.curar(objetivo);
            }
            default -> System.out.println("Opción no válida");
        }
    }

    private void accionesArquero(Arquero arquero, Equipo equipoRival) {
        System.out.println("\nAcciones disponibles:");
        System.out.println("1. Atacar enemigo");
        System.out.println("2. Ataque grupal");
        System.out.print("Selecciona: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1 -> {
                Personaje objetivo = seleccionarObjetivo(equipoRival.getIntegrantes(), "enemigo");
                if (objetivo != null) arquero.atacar(objetivo);
            }
            case 2 -> arquero.ataqueGrupal(equipoRival.getIntegrantes());
            default -> System.out.println("Opción no válida");
        }
    }

    private void accionesGuerrero(Guerrero guerrero, Equipo equipoRival){
        System.out.println("\nAcciones disponibles:");
        System.out.println("1. Atacar enemigo");
        System.out.println("2. Ataque mortal");
        System.out.print("Selecciona: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1 -> {
                Personaje objetivo = seleccionarObjetivo(equipoRival.getIntegrantes(), "enemigo");
                if (objetivo != null) guerrero.atacar(objetivo);
            }
            case 2 -> guerrero.ataqueGrupal(equipoRival.getIntegrantes());
            default -> System.out.println("Opción no válida");
        }

    }


    private Equipo seleccionarEquipo() {
        System.out.println("\n1. Equipo A");
        System.out.println("2. Equipo B");
        System.out.print("Selecciona el equipo: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        return switch (opcion) {
            case 1 -> equipoA;
            case 2 -> equipoB;
            default -> {
                System.out.println("Opción no válida");
                yield null;
            }
        };
    }

    private Personaje seleccionarObjetivo(List<Personaje> lista, String tipo){
        System.out.println("\nSelecciona un " + tipo + ":");
        List<Personaje> vivos = new ArrayList<>();
        int i = 1;
        for (Personaje personaje : lista){
            if (personaje.estaVivo()){
                System.out.println(
                        i+ ". " +
                        personaje.getNombre() +
                        " (Vida: "+
                        personaje.getVida() + ")");
                vivos.add(personaje);
                i++;
            }
        }
        if (vivos.isEmpty()){
            System.out.println("No quedan personajes "+tipo +"s vivos");
            return null;
        }
        System.out.print("Selecciona: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine();

        if (seleccion < 1 || seleccion > vivos.size()){
            System.out.println("Selección no válida");
            return null;
        }
        return vivos.get(seleccion-1);
    }

    private String seleccionarTipo(Equipo equipo) {
        System.out.println("\nTipo de personaje:");
        System.out.println("1. Mago");
        System.out.println("2. Soldado");
        System.out.println("3. Arquero");
        System.out.println("4. Guerrero");
        System.out.print("Selecciona el tipo: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        String tipo = obtenerNombreTipo(opcion);
        if (tipo.equals("Desconocido")) {
            System.out.println("Tipo no válido");
            return null;
        }

        if (!equipo.puedeAgregar(tipo)) {
            System.out.println("El equipo " + equipo.getNombre() +
                    " ya tiene " + equipo.getTipoPersonaje() +
                    ". No puedes agregar " + tipo);
            return null;
        }

        return tipo;
    }

    private String pedirNombre() {
        System.out.print("Nombre del personaje: ");
        return scanner.nextLine();
    }

    private Personaje crearPersonaje(String tipo, String nombre) {
        return switch (tipo) {
            case "Mago" -> {
                System.out.println("1. Magia Blanca");
                System.out.println("2. Magia Negra");
                System.out.print("Especialidad: ");
                int esp = scanner.nextInt();
                scanner.nextLine();
                EspecialidadMagia especialidad = (esp == 1) ?
                        EspecialidadMagia.BLANCA : EspecialidadMagia.NEGRA;
                yield new Mago(nombre, especialidad);
            }
            case "Soldado" -> new Soldado(nombre);
            case "Arquero" -> new Arquero(nombre);
            case "Guerrero" -> new Guerrero(nombre);
            default -> null;
        };
    }

    private String obtenerNombreTipo(int tipo) {
        return switch (tipo) {
            case 1 -> "Mago";
            case 2 -> "Soldado";
            case 3 -> "Arquero";
            case 4 -> "Guerrero";
            default -> "Desconocido";
        };
    }

    //Implementar guardar y cargar partida


    private void guardarPartida(){
        List<Equipo> equipos = new ArrayList<>();
        equipos.add(equipoA);
        equipos.add(equipoB);
        gestorFicheros.escribirEquipos(equipos);
    }

    private void cargarPartida(){
        List<Equipo> equipos = gestorFicheros.leerEquipos();
        if (equipos.size() >= 2){
            this.equipoA = equipos.get(0);
            this.equipoB = equipos.get(1);
            System.out.println("¡Partida cargada!");
        }else
            System.out.println("No hay ninguna partida guardada");
    }


}