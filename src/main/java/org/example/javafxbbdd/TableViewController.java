package org.example.javafxbbdd;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.List;

public class TableViewController {
    public TableColumn col_matricula;
    public TableView tab_vehiculo;
    public TableColumn col_marca;
    public TableColumn col_precio;
    public TableColumn col_fecha_alquiler;
    public TableColumn col_fecha_entrega;
    public TableColumn col_total;
    public DatePicker date_fecha_inicial;
    public DatePicker date_fecha_final;
    public MenuButton selec_cliente;

    public void initialize() {
        // Configure the columns
        col_matricula.setCellValueFactory(new PropertyValueFactory<Servicio, String>("matricula_vehiculo"));
        col_fecha_alquiler.setCellValueFactory(new PropertyValueFactory<Servicio, LocalDate>("fecha_alquiler"));
        col_fecha_entrega.setCellValueFactory(new PropertyValueFactory<Servicio, LocalDate>("fecha_entrega"));
        col_total.setCellValueFactory(new PropertyValueFactory<Servicio, Integer>("total"));

        // Get the data from the database
        List<Servicio> servicios = DatabaseQuery.getServicios();

        // Assign the data to the TableView
        tab_vehiculo.setItems(FXCollections.observableArrayList(servicios));
    }
}
