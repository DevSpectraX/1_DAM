package controller;

import model.Libro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileController {
    // Gestiona todas las acciones con ficheros locales.

    public void exportarFavorito(List<Libro> lista) {
        File file = new File("src/main/java/ficheros/librosFavoritos.obj");
        ObjectOutputStream objectOutputStream = null;


        try {
            System.out.println("Exportando...");
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(lista);
        } catch (Exception e) {
            System.out.println("Algo ha salido mal al exportar tus libros favoritos.");
        }finally {
            try {
                objectOutputStream.close();
            }catch (Exception e){
                System.out.println("Error al cerrar la escritura.");
            }


        }
        System.out.println("Exportado correctamente");
    }

    public List<Libro> importarFavorito() {
        File file = new File("src/main/java/ficheros/librosFavoritos.obj");
        ObjectInputStream objectInputStream = null;
        List<Libro> lista = new ArrayList<>();

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            lista = (List<Libro>) objectInputStream.readObject();

        } catch (Exception e) {
            System.out.println("Error en la importación");
        } finally {
            try {
                objectInputStream.close();
            } catch (Exception e) {
                System.out.println("Error al terminar la importacion, no se ha podido cerrar");
            }
        }

        System.out.println("Importado correctamente");
        return lista;
    }
}
