package model;

public abstract class Empleado {
    private String nombre;
    private int salarioBase;


    public Empleado(String nombre, int salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public void mostrarInfo(){
        System.out.println("Empleado: "+nombre);
        System.out.println("Salario Base: "+salarioBase);
    }
    public abstract void calcularSalarioTotal();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(int salarioBase) {
        this.salarioBase = salarioBase;
    }
}
