module org.example.fichador {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens org.example.fichador to javafx.fxml;
    exports org.example.fichador;

    exports org.example.fichador.controller;
    opens org.example.fichador.controller to javafx.fxml;

    exports org.example.fichador.model;
    opens org.example.fichador.model to javafx.fxml;

    exports org.example.fichador.data;
    opens org.example.fichador.data to javafx.fxml;
}