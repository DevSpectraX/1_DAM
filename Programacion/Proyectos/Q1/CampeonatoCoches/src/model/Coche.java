package model;
/*Contiene atributos como marca, modelo, km*/
public class Coche {
    private String marca;
    private String modelo;
    private int dorsal;
    private int km;

    private int puntos;


    public Coche(String marca, String modelo, int dorsal) {
        this.marca = marca;
        this.modelo = modelo;
        this.dorsal = dorsal;
        km = 0;
        puntos = 0;

    }
}