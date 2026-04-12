package org.example.fichador.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.fichador.HelloApplication;
import org.example.fichador.model.Jornada;
import org.example.fichador.model.Usuario;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML private TextField altaNombre, altaApellido, altaDni, altaCorreo;
    @FXML private PasswordField altaPassword;
    @FXML private ComboBox<String> altaRol;
    @FXML private Button btnAlta;
    @FXML private TextField bajaDni;
    @FXML private Button btnBaja;
    @FXML private TextField verDni;
    @FXML private Label verNombre, verApellido, verCorreo, verRol;
    @FXML private Button btnBuscar;
    @FXML private TextField passDni;
    @FXML private PasswordField passNueva;
    @FXML private Button btnCambiarPass;
    @FXML private MenuItem menuAlta, menuBaja, menuVerTrabajador,
            menuVerTodos, menuCambiarPass, menuJornada, menuCerrarSesion;
    @FXML private StackPane contenedor;
    @FXML private VBox panelAlta, panelBaja, panelVerTrabajador,
            panelVerTodos, panelCambiarPassword, panelJornada, panelBienvenida;
    @FXML private TableView<Jornada> tablaJornada;
    @FXML private TableColumn<Jornada, String> jornadaDni, jornadaNombre;
    @FXML private TableColumn<Jornada, LocalDateTime> jornadaEntrada, jornadaSalida;
    @FXML private TableView<Usuario> tablaTrabajadores;
    @FXML private TableColumn<Usuario, String> colNombre, colApellido, colDni, colCorreo, colRol;

    private ObservableList<Usuario> listaTrabajadores;
    private ObservableList<Jornada> listaJornadas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instances();
        initGUI();
        actions();
    }

    private void instances() {
        listaTrabajadores = FXCollections.observableArrayList(Usuario.mostrarTodos());
        listaJornadas = FXCollections.observableArrayList(Jornada.mostrarTodas());
    }

    private void initGUI() {
        altaRol.getItems().addAll("ADMIN", "TRABAJADOR");

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colRol.setCellValueFactory(new PropertyValueFactory<>("rol"));
        tablaTrabajadores.setItems(listaTrabajadores);

        jornadaDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        jornadaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        jornadaEntrada.setCellValueFactory(new PropertyValueFactory<>("entrada"));
        jornadaSalida.setCellValueFactory(new PropertyValueFactory<>("salida"));
        tablaJornada.setItems(listaJornadas);

        ocultarTodos();
        panelBienvenida.setVisible(true);
    }

    private void actions() {
        btnAlta.setOnAction(e -> altaTrabajador());
        btnBaja.setOnAction(e -> bajaTrabajador());
        btnBuscar.setOnAction(e -> buscarTrabajador());
        btnCambiarPass.setOnAction(e -> cambiarPassword());

        menuAlta.setOnAction(e -> mostrarPanel(panelAlta));
        menuBaja.setOnAction(e -> mostrarPanel(panelBaja));
        menuVerTrabajador.setOnAction(e -> mostrarPanel(panelVerTrabajador));
        menuCambiarPass.setOnAction(e -> mostrarPanel(panelCambiarPassword));
        menuCerrarSesion.setOnAction(e -> cerrarSesion());

        menuVerTodos.setOnAction(e -> {
            listaTrabajadores.setAll(Usuario.mostrarTodos());
            mostrarPanel(panelVerTodos);
        });

        menuJornada.setOnAction(e -> {
            Jornada.leerFichaje();
            listaJornadas.setAll(Jornada.mostrarTodas());
            mostrarPanel(panelJornada);
        });
    }

    private void altaTrabajador() {
        if (altaNombre.getText().isEmpty()
                || altaApellido.getText().isEmpty()
                || altaDni.getText().isEmpty()
                || altaCorreo.getText().isEmpty()
                || altaPassword.getText().isEmpty()
                || altaRol.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Rellena todos los campos");
            alert.show();
            return;
        }

        if (Usuario.buscarPorDni(altaDni.getText()) != null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Ya existe ese usuario");
            alert.show();
            return;
        }

        Usuario usuario = new Usuario(
                altaNombre.getText(),
                altaApellido.getText(),
                altaDni.getText(),
                altaCorreo.getText(),
                altaPassword.getText(),
                altaRol.getValue()
        );
        Usuario.alta(usuario);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setContentText("Usuario añadido correctamente");
        alert.show();

        altaNombre.clear();
        altaApellido.clear();
        altaDni.clear();
        altaCorreo.clear();
        altaPassword.clear();
        altaRol.setValue(null);
    }

    private void bajaTrabajador() {
        if (bajaDni.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Introduce un DNI");
            alert.show();
            return;
        }

        if (Usuario.buscarPorDni(bajaDni.getText()) == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Usuario no encontrado");
            alert.show();
            return;
        }

        Usuario.baja(bajaDni.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setContentText("Usuario eliminado");
        alert.show();

        bajaDni.clear();
    }

    private void buscarTrabajador() {
        if (verDni.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Introduce un DNI");
            alert.show();
            return;
        }

        Usuario usuario = Usuario.buscarPorDni(verDni.getText());

        if (usuario == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("No existe ese usuario");
            alert.show();
            return;
        }

        verNombre.setText("Nombre: " + usuario.getNombre());
        verApellido.setText("Apellido: " + usuario.getApellido());
        verCorreo.setText("Correo: " + usuario.getCorreo());
        verRol.setText("Rol: " + usuario.getRol());
    }

    private void cambiarPassword() {
        if (passDni.getText().isEmpty() || passNueva.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Rellena todos los campos");
            alert.show();
            return;
        }

        if (Usuario.buscarPorDni(passDni.getText()) == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Usuario no encontrado");
            alert.show();
            return;
        }

        Usuario.cambiarPass(passDni.getText(), passNueva.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setContentText("Contraseña actualizada");
        alert.show();

        passDni.clear();
        passNueva.clear();
    }

    private void cerrarSesion() {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Fichador");
            stage.show();
            ((Stage) contenedor.getScene().getWindow()).close();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("No se pudo cerrar sesión");
            alert.show();
        }
    }

    private void mostrarPanel(VBox panel) {
        ocultarTodos();
        panel.setVisible(true);
    }

    private void ocultarTodos() {
        panelAlta.setVisible(false);
        panelBaja.setVisible(false);
        panelVerTrabajador.setVisible(false);
        panelVerTodos.setVisible(false);
        panelCambiarPassword.setVisible(false);
        panelJornada.setVisible(false);
        panelBienvenida.setVisible(false);
    }
}