package Ejercicio1_ClaseLibro;

public class Libro {
    private String titulo;
    private String autor;
    private int numPaginas;
    private double precio;

    public Libro(String titulo, String autor, int numPaginas, double precio){
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.precio = precio;


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
        setPrecio((getPrecio() * ((100 - porcentaje)/100)));
        System.out.println("Precio nuevo: " +getPrecio()+ " €");
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
}
