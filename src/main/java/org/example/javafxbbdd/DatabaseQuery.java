package org.example.javafxbbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQuery {
    public static void getData() {
        String query = "SELECT * FROM myTable";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String data = resultSet.getString("columnName");
                // Procesa los datos como sea necesario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getClientes() {
        List<String> clientes = new ArrayList<>();
        String query = "SELECT nombre FROM clientes";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String cliente = resultSet.getString("nombre");
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public static void main(String[] args) {
        List<String> clientes = getClientes();
        for (String cliente : clientes) {
            System.out.println(cliente);
        }
    }

}
