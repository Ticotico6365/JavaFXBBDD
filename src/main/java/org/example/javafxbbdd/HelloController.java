package org.example.javafxbbdd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    public DatePicker date_fecha_alquiler;
    public MenuButton selec_vehiculo;
    public MenuButton select_cliente;
    public TextField txt_direccion;
    public TextField txt_marca;
    public TextField txt_kilometros;
    public TextField txt_precio;
    public TextField txt_nif;
    public TextField txt_direcion;
    public TextField txt_poblacion;
    public TextField txt_total_servicio;
    public Button bt_grabar;
    public DatePicker date_fecha_entrega;
    public Button bt_ver_tabla;

    public void initialize() {
        selec_vehiculo.getItems().clear();
        select_cliente.getItems().clear();
        for (Vehiculo vehiculo : DatabaseQuery.getVehiculos()) {
            MenuItem item = new MenuItem(vehiculo.getMatricula());
            item.setOnAction(event -> {
                txt_marca.setText(vehiculo.getMarca());
                txt_kilometros.setText(vehiculo.getKilometros().toString());
                txt_precio.setText(vehiculo.getPrecio().toString());
            });
            selec_vehiculo.getItems().add(item);
        }
        for (Cliente cliente : DatabaseQuery.getClientes()) {
            MenuItem item = new MenuItem(cliente.getNif());
            item.setOnAction(event -> {
                txt_direcion.setText(cliente.getDirecion());
                txt_poblacion.setText(cliente.getPoblacion());
            });
            select_cliente.getItems().add(item);
        }
    }

    public void click_grabar(ActionEvent actionEvent) {
        Servicio servicio = new Servicio();
        servicio.setMatricula_vehiculo(selec_vehiculo.getText());
        servicio.setNif_cliente(select_cliente.getText());
        servicio.setFecha_alquiler(date_fecha_alquiler.getValue());
        servicio.setFecha_entrega(date_fecha_entrega.getValue());
        servicio.setTotal(Integer.parseInt(txt_total_servicio.getText()));
        DatabaseQuery.insertServicio(servicio);
    }

    public void click_bt_ver_tabla(ActionEvent actionEvent) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/javafxbbdd/table-view.fxml"));
            Parent root = loader.load();

            // Create a new scene with the loaded root
            Scene scene = new Scene(root);

            // Create a new stage (window)
            Stage stage = new Stage();

            // Set the scene for the stage
            stage.setScene(scene);

            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}