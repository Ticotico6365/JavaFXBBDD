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

    public static List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM clientes";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setDirecion(resultSet.getString("Direccion"));
                    cliente.setNif(resultSet.getString("NIF"));
                    cliente.setNya(resultSet.getString("NyA"));
                    cliente.setPoblacion(resultSet.getString("Poblacion"));
                    clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public static List<Vehiculo> getVehiculos() {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String query = "SELECT * FROM vehiculos";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                    Vehiculo vehiculo = new Vehiculo();
                    vehiculo.setMatricula(resultSet.getString("matricula"));
                    vehiculo.setMarca(resultSet.getString("marca"));
                    vehiculo.setPrecio(resultSet.getInt("precio"));
                    vehiculo.setKilometros(resultSet.getInt("kilometros"));
                    vehiculo.setDescripcion(resultSet.getString("descripcion"));
                    vehiculos.add(vehiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }

    public static List<Servicio> getServicios() {
        List<Servicio> servicios = new ArrayList<>();
        String query = "SELECT * FROM servicios";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                    Servicio servicio = new Servicio();
                    servicio.setId_servicios(resultSet.getInt("id_servicios"));
                    servicio.setMatricula_vehiculo(resultSet.getString("matricula_vehiculo"));
                    servicio.setNif_cliente(resultSet.getString("nif_cliente"));
                    servicio.setFecha_alquiler(resultSet.getDate("fecha_alquiler").toLocalDate());
                    servicio.setFecha_entrega(resultSet.getDate("fecha_entrega").toLocalDate());
                    servicio.setTotal(resultSet.getInt("total"));
                    servicios.add(servicio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return servicios;
    }

    public static void insertCliente(Cliente cliente) {
        String query = "INSERT INTO clientes (NIF, NyA, Direccion, Poblacion) VALUES ('" + cliente.getNif() + "', '" + cliente.getNya() + "', '" + cliente.getDirecion() + "', '" + cliente.getPoblacion() + "')";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertVehiculo(Vehiculo vehiculo) {
        String query = "INSERT INTO vehiculos (matricula, marca, precio, kilometros, descripcion) VALUES ('" + vehiculo.getMatricula() + "', '" + vehiculo.getMarca() + "', " + vehiculo.getPrecio() + ", " + vehiculo.getKilometros() + ", '" + vehiculo.getDescripcion() + "')";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertServicio(Servicio servicio) {
        String query = "INSERT INTO servicios (id_servicios, matricula_vehiculo, nif_cliente, fecha_alquiler, fecha_entrega, total) VALUES (" + servicio.getId_servicios() + ", '" + servicio.getMatricula_vehiculo() + "', '" + servicio.getNif_cliente() + "', '" + servicio.getFecha_alquiler() + "', '" + servicio.getFecha_entrega() + "', " + servicio.getTotal() + ")";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
