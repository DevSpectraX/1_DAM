package model;

public class Gerente extends Empleado{
    private int bonus;

    public Gerente(String nombre, int salarioBase, int bonus) {
        super(nombre, salarioBase);
        this.bonus = bonus;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Puesto: Gerente");
        System.out.println("Bonus: "+bonus);

    }

    @Override
    public void calcularSalarioTotal() {
        System.out.println("Salario Total: "+(getSalarioBase()+bonus));
        System.out.println();
    }
}
