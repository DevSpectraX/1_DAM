import controller.BibliotecaController;
import controller.FileController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BibliotecaController bibliotecaController = new BibliotecaController();
        FileController fileController = new FileController();
        int opcion = -1;

        do {
            System.out.println("Elige una opción:");
            System.out.println("1. Importar libros");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Buscar libro por id");
            System.out.println("4. Añadir favorito");
            System.out.println("5. Mostrar favoritos");
            System.out.println("6. Eliminar favorito");
            System.out.println("7. Exportar favoritos");
            System.out.println("8. Importar favoritos");
            System.out.println("0. Salir");
            opcion = scanner.nextInt();
            switch (opcion){
                case 0 -> {
                    System.out.println("Cerrando la aplicacion...");
                }
                case 1 -> bibliotecaController.importarLibros();
                case 2 -> bibliotecaController.mostrarLibros();
                case 3 -> {
                    System.out.println("¿Qué id quieres buscar?");
                    int id = scanner.nextInt();
                    bibliotecaController.buscarLibroId(id);
                }
                case 4 -> {
                    System.out.println("¿Qué id quieres guardar en favoritos?");
                    int id = scanner.nextInt();
                    bibliotecaController.agregarFavoritos(id);
                }
                case 5 -> bibliotecaController.mostrarFavoritos();

                case 6 -> {
                    System.out.println("¿Qué id quieres eliminar de favoritos?");
                    int id = scanner.nextInt();
                    bibliotecaController.eliminarFavoritos(id);}
                case 7 ->
                    fileController.exportarFavorito(bibliotecaController.listarFavoritos());
                case 8 -> {
                    System.out.println("Importando libros favoritos...");
                    bibliotecaController.importarFavoritos(fileController);
                    System.out.println("Libros importados");
                }

            }


        }while (opcion != 0);
        System.out.println("Cerrado con exito");

    }
}
