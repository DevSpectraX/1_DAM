package model;

public class Desarrollador extends Empleado{
    private String lenguajePrincipal;

    public Desarrollador(String nombre, int salarioBase, String lenguajePrincipal) {
        super(nombre, salarioBase);
        this.lenguajePrincipal = lenguajePrincipal;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Puesto: Desarrollador");
        System.out.println("Lenguaje Principal: "+lenguajePrincipal);
    }

    @Override
    public void calcularSalarioTotal() {
        System.out.println("Salario Total: "+getSalarioBase());
        System.out.println();
    }
}
