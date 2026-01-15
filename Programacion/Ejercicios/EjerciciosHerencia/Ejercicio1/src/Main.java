import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Perro perro1 = new Perro("Paco", 5);
        Perro perro2 = new Perro("Rex", 3);
        Perro perro3 = new Perro("Toby", 7);

        Gato gato1 = new Gato("Orion", 2);
        Gato gato2 = new Gato("Mishi", 4);
        Gato gato3 = new Gato("Luna", 1);

        ArrayList<Animal> listaAnimales = new ArrayList<>();
        listaAnimales.add(perro1);
        listaAnimales.add(perro2);
        listaAnimales.add(perro3);
        listaAnimales.add(gato1);
        listaAnimales.add(gato2);
        listaAnimales.add(gato3);

        for (Animal item : listaAnimales) {
            item.mostrarInfo();
            item.hacerSonido();
        }
    }
}
