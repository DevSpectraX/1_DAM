package Ejercicio1_ClaseLibro;

public class Libro {
    private String titulo;
    private String autor;
    private int numPaginas;
    private double precio;
    //Añadido 2 atributos para hacer Ejercicio10_SistemaDeBiblioteca
    private String isbn;
    private boolean prestado;

    public Libro(String titulo, String autor, int numPaginas, double precio,
    String isbn){
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.precio = precio;
        this.isbn = isbn;
        this.prestado = false;


    }

    public void mostrarInfo(){
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Número de páginas: " + numPaginas);
        System.out.println("Precio: " + precio);
        System.out.println("¿Es un libro largo? " + esLibroLargo());
    }

    public boolean esLibroLargo(){
        if (numPaginas > 300){
        return true;
        }
        return false;
    }

    public void aplicarDescuento(double porcentaje){
        System.out.println("Aplcando descuento del "+ (int)porcentaje + "%...");
        setPrecio((precio - (precio * porcentaje / 100)));
        System.out.println("Precio nuevo: " +getPrecio()+ " €");
    }
    //Añadidos metodos nuevos para Ejercicio10_SistemaDeBiblioteca
    public boolean prestar(){
        if(!prestado) {
            prestado = true;
            return true;
        }
        System.out.println("El libro ya ha sido prestado");
        return false;
    }
    public boolean devolver(){
        System.out.println("Devolucion del libro "+isbn+"...");
        if (!prestado){
            System.out.println("No se puede devolver un libro que no tienes");
            return false;
        }
        prestado = false;
        System.out.println("Libro devuelto correctamente");

        return true;
    }







    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getIsbn(){
        return isbn;
    }
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
    public boolean getPrestado(){
        return prestado;
    }
}
