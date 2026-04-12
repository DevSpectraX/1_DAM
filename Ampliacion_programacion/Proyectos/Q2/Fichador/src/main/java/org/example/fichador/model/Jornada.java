package org.example.fichador.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.File;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jornada {

    private String dni, nombre;
    private LocalDateTime entrada, salida;

    private static List<Jornada> jornadas = new ArrayList<>();

    public static void registrarEntrada(String dni, String nombre) {
        jornadas.add(new Jornada(dni, nombre, LocalDateTime.now(), null));
    }

    public static boolean registrarSalida(String dni) {
        Jornada jornada = buscarJornadaAbierta(dni);
        if (jornada != null) {
            jornada.setSalida(LocalDateTime.now());
            return true;
        }
        return false;
    }

    public static Jornada buscarJornadaAbierta(String dni) {
        return jornadas.stream()
                .filter(j -> j.getDni().equals(dni) && j.getSalida() == null)
                .findFirst()
                .orElse(null);
    }

    public static void escribirFichaje(String correo) {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
        String fechaHora = ahora.format(formato);
        String lineaFichaje = correo + " - " + fechaHora + "\n";

        try (FileWriter writer = new FileWriter("horas.txt", true)) {
            writer.write(lineaFichaje);
        } catch (Exception e) {
            System.out.println("Error al registrar fichaje");
        }
    }

    public static void leerFichaje() {
        try (Scanner scanner = new Scanner(new File("horas.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error al leer el fichero");
        }
    }

    public static List<Jornada> mostrarTodas() {
        return jornadas;
    }
}