public class Perro extends Animal{

    public Perro(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre()+" hace: Guau Guau");
    }
}
