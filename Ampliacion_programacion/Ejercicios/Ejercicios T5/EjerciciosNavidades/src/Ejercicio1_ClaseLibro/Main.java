package Ejercicio1_ClaseLibro;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArrayList<Libro> listaLibros = new ArrayList<>();
        Libro libro0 = new Libro("Cien años de soledad", "Gabriel García Márquez", 472, 18, "0000");
        Libro libro1 = new Libro("El principito", "Antoine de Saint-Exupéry", 96, 9, "0001");
        Libro libro2 = new Libro("1984", "George Orwell", 328, 14, "0002");
        Libro libro3 = new Libro("Fahrenheit 451", "Ray Bradbury", 256, 12, "0003");
        Libro libro4 = new Libro("Orgullo y prejuicio", "Jane Austen", 432, 15, "0004");
        Libro libro5 = new Libro("Hamlet", "William Shakespeare", 160, 10, "0005");
        Libro libro6 = new Libro("El nombre del viento", "Patrick Rothfuss", 662, 22, "0006");
        Libro libro7 = new Libro("Sapiens: De animales a dioses", "Yuval Noah Harari", 498, 21, "0007");
        Libro libro8 = new Libro("El código Da Vinci", "Dan Brown", 454, 16, "0008");
        Libro libro9 = new Libro("La sombra del viento", "Carlos Ruiz Zafón", 576, 19, "0009");

        Libro libro10 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 863, 25, "0010");
        Libro libro11 = new Libro("La Odisea", "Homero", 300, 12, "0011");
        Libro libro12 = new Libro("Crimen y castigo", "Fiódor Dostoyevski", 671, 20, "0012");
        Libro libro13 = new Libro("El gran Gatsby", "F. Scott Fitzgerald", 180, 11, "0013");
        Libro libro14 = new Libro("Matar a un ruiseñor", "Harper Lee", 336, 13, "0014");
        Libro libro15 = new Libro("Drácula", "Bram Stoker", 418, 14, "0015");
        Libro libro16 = new Libro("Frankenstein", "Mary Shelley", 280, 12, "0016");
        Libro libro17 = new Libro("El Hobbit", "J.R.R. Tolkien", 310, 15, "0017");
        Libro libro18 = new Libro("El Señor de los Anillos", "J.R.R. Tolkien", 1216, 30, "0018");
        Libro libro19 = new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", 309, 14, "0019");

        Libro libro20 = new Libro("Harry Potter y la cámara secreta", "J.K. Rowling", 341, 15, "0020");
        Libro libro21 = new Libro("Harry Potter y el prisionero de Azkaban", "J.K. Rowling", 435, 16, "0021");
        Libro libro22 = new Libro("Harry Potter y el cáliz de fuego", "J.K. Rowling", 636, 19, "0022");
        Libro libro23 = new Libro("Harry Potter y la Orden del Fénix", "J.K. Rowling", 870, 22, "0023");
        Libro libro24 = new Libro("Harry Potter y el misterio del príncipe", "J.K. Rowling", 652, 20, "0024");
        Libro libro25 = new Libro("Harry Potter y las reliquias de la muerte", "J.K. Rowling", 759, 23, "0025");

        Libro libro26 = new Libro("El alquimista", "Paulo Coelho", 208, 11, "0026");
        Libro libro27 = new Libro("Brida", "Paulo Coelho", 288, 12, "0027");
        Libro libro28 = new Libro("Veronika decide morir", "Paulo Coelho", 240, 12, "0028");
        Libro libro29 = new Libro("El peregrino de Compostela", "Paulo Coelho", 320, 13, "0029");

        Libro libro30 = new Libro("La catedral del mar", "Ildefonso Falcones", 879, 24, "0030");
        Libro libro31 = new Libro("La reina del sur", "Arturo Pérez-Reverte", 656, 20, "0031");
        Libro libro32 = new Libro("El club Dumas", "Arturo Pérez-Reverte", 368, 15, "0032");
        Libro libro33 = new Libro("La fiesta del chivo", "Mario Vargas Llosa", 720, 22, "0033");
        Libro libro34 = new Libro("Pantaleón y las visitadoras", "Mario Vargas Llosa", 264, 12, "0034");

        Libro libro35 = new Libro("Rayuela", "Julio Cortázar", 672, 20, "0035");
        Libro libro36 = new Libro("Final del juego", "Julio Cortázar", 192, 10, "0036");
        Libro libro37 = new Libro("El túnel", "Ernesto Sabato", 160, 10, "0037");
        Libro libro38 = new Libro("Sobre héroes y tumbas", "Ernesto Sabato", 672, 21, "0038");
        Libro libro39 = new Libro("Ensayo sobre la ceguera", "José Saramago", 352, 14, "0039");
        Libro libro40 = new Libro("El evangelio según Jesucristo", "José Saramago", 416, 15, "0040");

        listaLibros.add(libro0);
        listaLibros.add(libro1);
        listaLibros.add(libro2);
        listaLibros.add(libro3);
        listaLibros.add(libro4);
        listaLibros.add(libro5);
        listaLibros.add(libro6);
        listaLibros.add(libro7);
        listaLibros.add(libro8);
        listaLibros.add(libro9);
        listaLibros.add(libro10);
        listaLibros.add(libro11);
        listaLibros.add(libro12);
        listaLibros.add(libro13);
        listaLibros.add(libro14);
        listaLibros.add(libro15);
        listaLibros.add(libro16);
        listaLibros.add(libro17);
        listaLibros.add(libro18);
        listaLibros.add(libro19);
        listaLibros.add(libro20);
        listaLibros.add(libro21);
        listaLibros.add(libro22);
        listaLibros.add(libro23);
        listaLibros.add(libro24);
        listaLibros.add(libro25);
        listaLibros.add(libro26);
        listaLibros.add(libro27);
        listaLibros.add(libro28);
        listaLibros.add(libro29);
        listaLibros.add(libro30);
        listaLibros.add(libro31);
        listaLibros.add(libro32);
        listaLibros.add(libro33);
        listaLibros.add(libro34);
        listaLibros.add(libro35);
        listaLibros.add(libro36);
        listaLibros.add(libro37);
        listaLibros.add(libro38);
        listaLibros.add(libro39);
        listaLibros.add(libro40);

        for (Libro libro : listaLibros
             ) {
            libro.mostrarInfo();
            libro.getPrecio();
            libro.aplicarDescuento((int)(Math.random() * 58));
        }
    }

}
