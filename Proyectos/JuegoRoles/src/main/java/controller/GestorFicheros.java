package controller;

import model.Equipo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorFicheros {

    String path = "src/main/java/recursos/partida.obj";

    public void escribirEquipos(List<Equipo> equipos){
        File file = new File(path);

        //Crear carpeta si no existe
        file.getParentFile().mkdirs();

        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(equipos);
        }catch (IOException e){
            System.out.println("Error al guardar la partida");
        }finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            }catch (IOException e){
                System.out.println("Error al cerrar el proceso de guardado");
            }
        }
    }


    public List<Equipo> leerEquipos() {
        File file = new File(path);
        ObjectInputStream objectInputStream = null;
        List<Equipo> listaEquipo = new ArrayList<>();

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            listaEquipo = (List<Equipo>) objectInputStream.readObject();
        } catch (Exception e) {

            System.out.println("Error al cargar el archivo");
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Error al terminar el proceso de carga");
            }
            return listaEquipo;
        }
    }
}