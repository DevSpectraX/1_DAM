package Ejercicio10_SistemaDeBiblioteca;

import Ejercicio1_ClaseLibro.Libro;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Local");
        Libro libro0 = new Libro("Cien años de soledad", "Gabriel García Márquez", 472, 18, "0000");
        Libro libro1 = new Libro("El principito", "Antoine de Saint-Exupéry", 96, 9, "0001");

        biblioteca.agregarLibro(libro0);
        biblioteca.agregarLibro(libro1);

        biblioteca.buscarLibroPorIsbn("0001");

    }
}
