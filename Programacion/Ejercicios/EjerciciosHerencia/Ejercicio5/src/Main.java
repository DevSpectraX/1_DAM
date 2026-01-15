import model.Desarrollador;
import model.Empleado;
import model.Gerente;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Desarrollador desarrollador1 = new Desarrollador("jose", 25000, "Java");
        Desarrollador desarrollador2 = new Desarrollador("Ana", 28000, "Python");
        Desarrollador desarrollador3 = new Desarrollador("Luis", 26000, "JavaScript");
        Desarrollador desarrollador4 = new Desarrollador("Maria", 30000, "C#");

        Gerente gerente1 = new Gerente("Fran", 43000,8854);
        Gerente gerente2 = new Gerente("Sergio", 47000, 9021);
        Gerente gerente3 = new Gerente("Elena", 45000, 7765);
        Gerente gerente4 = new Gerente("Clara", 49000, 8123);

        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(desarrollador1);
        listaEmpleados.add(desarrollador2);
        listaEmpleados.add(desarrollador3);
        listaEmpleados.add(desarrollador4);

        listaEmpleados.add(gerente1);
        listaEmpleados.add(gerente2);
        listaEmpleados.add(gerente3);
        listaEmpleados.add(gerente4);

        for (Empleado empleado : listaEmpleados) {
            empleado.mostrarInfo();
            empleado.calcularSalarioTotal();
    }
}
}
