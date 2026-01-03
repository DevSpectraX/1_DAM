package Ejercicio10_SistemaDeBiblioteca;

import Ejercicio1_ClaseLibro.Libro;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros;
    private int numLibros;





    public Biblioteca(String nombre){
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }




    public boolean agregarLibro(Libro libro){
        if (libro != null) {
            libros.add(libro);

            System.out.println("Libro agregado: " + libro.getTitulo());
            return true;
        }
        return false;

    }

    public Libro buscarLibroPorIsbn(String isbn){
        for (Libro libro : libros
             ) {
            if (libro.getIsbn().equals(isbn)){
                System.out.println("El ISBN "+isbn + " corresponde a: "+ libro.getTitulo());
                return libro;
            }

        }
        System.out.println("Libro no encontrado.");
        return null;
    }
    public boolean prestarLibro(String isbn){
        Libro libro = buscarLibroPorIsbn(isbn);
        if (libro != null){
            return libro.prestar();
        }
        System.out.println("Libro no encontrado.");
        return false;
    }
    public boolean devolverLibro(String isbn){
        Libro libro = buscarLibroPorIsbn(isbn);
        if (libro != null){
            return libro.devolver();
        }
        System.out.println("Libro no encontrado.");
        return false;
    }
    public void listarLibrosDisponibles(){
        System.out.println("Libros disponibles:");
        for (Libro libro : libros){
            if (libro.prestar() == false){
                System.out.println("> " + libro.getTitulo() + " ISBN: " + libro.getIsbn() + ")");
            }
        }

    }
    public void listarLibrosPrestados(){
        System.out.println("Libros prestados:");
        for (Libro libro : libros){
            if (libro.prestar()){
                System.out.println("> " + libro.getTitulo() + " ISBN: " + libro.getIsbn() + ")");
            }
        }
    }


}
