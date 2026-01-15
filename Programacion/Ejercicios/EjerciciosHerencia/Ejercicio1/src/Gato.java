public class Gato extends Animal{
    public Gato(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre()+" hace: Miau Miau");
    }
}
