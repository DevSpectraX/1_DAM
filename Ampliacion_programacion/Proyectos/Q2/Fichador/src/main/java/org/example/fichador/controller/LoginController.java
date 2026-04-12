package org.example.fichador.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.fichador.HelloApplication;
import org.example.fichador.data.DataSet;
import org.example.fichador.model.Usuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML private Button btnLogin;
    @FXML private TextField inputUser;
    @FXML private TextField inputPass;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        actions();
    }

    private void actions() {

        btnLogin.setOnAction(event -> {
            String dni = inputUser.getText();
            String password = inputPass.getText();

            if (dni.isEmpty() || password.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Rellena todos los campos");
                alert.show();
                return;
            }

            Usuario usuario = Usuario.login(dni, password);

            if (usuario == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("DNI o contraseña incorrectos");
                alert.show();
                return;
            }

            DataSet.setUsuarioActual(usuario);

            String vista = usuario.getRol().equals("ADMIN") ? "admin-view.fxml" : "trabajador-view.fxml";

            Stage stage = new Stage();
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(vista));
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
                stage.setTitle("Fichador");
                stage.show();
                ((Stage) btnLogin.getScene().getWindow()).close();
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("La pantalla que se intenta cargar no esta disponible");
                alert.show();
            }
        });
    }
}