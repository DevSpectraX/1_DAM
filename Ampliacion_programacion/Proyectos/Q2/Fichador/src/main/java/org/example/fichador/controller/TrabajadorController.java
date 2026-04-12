package org.example.fichador.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.fichador.HelloApplication;
import org.example.fichador.data.DataSet;
import org.example.fichador.model.Jornada;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TrabajadorController implements Initializable {

    @FXML private MenuItem menuCerrarSesion;
    @FXML private Button btnFichar;
    @FXML private Text lblBienvenida;
    @FXML private Label lblMensaje;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initGUI();
        actions();
    }

    private void initGUI() {
        lblBienvenida.setText("Bienvenido, " + DataSet.getUsuarioActual().getNombre());
    }

    private void actions() {
        menuCerrarSesion.setOnAction(event -> {
            Stage stage = new Stage();
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
                stage.setTitle("Fichador");
                stage.show();
                ((Stage) btnFichar.getScene().getWindow()).close();
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("La pantalla que se intenta cargar no esta disponible");
                alert.show();
            }
        });

        btnFichar.setOnAction(event -> {
            String dni = DataSet.getUsuarioActual().getDni();
            String nombre = DataSet.getUsuarioActual().getNombre();
            String correo = DataSet.getUsuarioActual().getCorreo();

            if (Jornada.buscarJornadaAbierta(dni) == null) {
                Jornada.registrarEntrada(dni, nombre);
                Jornada.escribirFichaje(correo);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Fichaje");
                alert.setContentText("Entrada registrada correctamente");
                alert.show();
                lblMensaje.setText("Entrada registrada");
            } else {
                Jornada.registrarSalida(dni);
                Jornada.escribirFichaje(correo);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Fichaje");
                alert.setContentText("Salida registrada correctamente");
                alert.show();
                lblMensaje.setText("Salida registrada");
            }
        });
    }
}