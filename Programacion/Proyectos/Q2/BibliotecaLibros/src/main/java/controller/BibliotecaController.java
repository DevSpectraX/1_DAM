package controller;


import model.Biblioteca;
import model.Libro;

import java.util.List;

public class BibliotecaController {
    // Gestión de todos los libros importados desde API.
    private Biblioteca biblioteca = new Biblioteca();
    private APIController apiController = new APIController();

    public void importarLibros(){
        List<Libro> libros = apiController.getAllBooks();
        biblioteca.setLibros(libros);
        System.out.println("Han sido importados " + libros.size() + " libros.");
    }

    public void mostrarLibros(){
        for (Libro libro : biblioteca.getLibros()){
            System.out.println(libro);
            System.out.println();
        }
    }

    public void buscarLibroId(int id){
        System.out.println("Mostrando el libro "+id+"...");
        apiController.getBookId(id);
    }

    public void mostrarFavoritos(){
        System.out.println("Mostrando tus libros favoritos...");
        for (Libro libro : biblioteca.getFavoritos()) {
            System.out.println(libro);
            System.out.println();
        }

    }
    public List<Libro> listarFavoritos(){
        return biblioteca.getFavoritos();
    }

    public void agregarFavoritos(int id){
        System.out.println("Agregando el libro " + id + "...");
        for (Libro libro : biblioteca.getLibros()) {
            if (libro.getId() == id) {
                biblioteca.getFavoritos().add(libro);
                System.out.println("Libro agregado correctamente.");
                return;
            }
        }
        System.out.println("Lo sentimos, no ha sido encontrado el libro "+id);

    }

    public void eliminarFavoritos(int id){
        System.out.println("Eliminando el libro "+id+"...");
        for(Libro libro : biblioteca.getFavoritos()){
            if(libro.getId() == id){
                biblioteca.getFavoritos().remove(libro);
                System.out.println("Libro "+libro.getTitle()+" eliminado de favoritos");
                return;
            }
        }
        System.out.println("Lo sentimos, el libro "+id+" no esta en tus favoritos");

    }

    public void importarFavoritos(FileController fileController){
        List<Libro> favoritos = fileController.importarFavorito();
        biblioteca.setFavoritos(favoritos);
        System.out.println("Han sido importados "+favoritos.size()+" libros favoritos.");
    }

}
