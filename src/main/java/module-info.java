module org.example.javafxbbdd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens org.example.javafxbbdd to javafx.fxml;
    exports org.example.javafxbbdd;
}