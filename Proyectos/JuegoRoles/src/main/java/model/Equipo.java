package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Equipo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private List<Personaje> integrantes;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.integrantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Personaje> getIntegrantes() {
        return integrantes;
    }

    public void agregar(Personaje personaje) {
        integrantes.add(personaje);
    }

    public boolean estaVacio() {
        return integrantes.isEmpty();
    }

    // Devuelve el tipo de personaje del equipo (o null si está vacío)
    public String getTipoPersonaje() {
        if (estaVacio()) return null;
        return integrantes.get(0).getClass().getSimpleName();
    }

    // Valida si se puede agregar un personaje de cierto tipo
    public boolean puedeAgregar(String tipoNuevo) {
        for (Personaje personaje : integrantes) {
            if (personaje.getClass().getSimpleName().equals(tipoNuevo)) {
                return false;
            }
        }
        return true;
    }

    // Verifica si todos los integrantes están muertos
    public boolean todosMuertos() {
        for (Personaje p : integrantes) {
            if (p.estaVivo()) return false;
        }
        return true;
    }

    public void mostrar() {
        System.out.println("\n=== Equipo " + nombre + " ===");
        if (estaVacio()) {
            System.out.println("(vacío)");
            return;
        }
        for (Personaje p : integrantes) {
            System.out.println(" - " + p);
        }
    }
}