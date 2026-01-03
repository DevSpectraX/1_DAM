package model;
/*Contiene atributos como marca, modelo, km*/
public class Coche {
    private String marca;
    private String modelo;
    private int dorsal;
    private int km;

    private int puntos = 0;


    public Coche(String marca, String modelo, int dorsal) {
        this.marca = marca;
        this.modelo = modelo;
        this.dorsal = dorsal;
        km = 0;
        puntos = 0;

    }


    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getDorsal() {
        return dorsal;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
}