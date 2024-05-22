package org.example.javafxbbdd;

import java.time.LocalDate;

public class Servicio {
    private Integer id_servicios;
    private String matricula_vehiculo;
    private String nif_cliente;
    private LocalDate fecha_alquiler;
    private LocalDate fecha_entrega;
    private Integer total;

    public Servicio() {
    }

    public Servicio(Integer id_servicios, String matricula_vehiculo, String nif_cliente, LocalDate fecha_alquiler, LocalDate fecha_entrega, Integer total) {
        this.id_servicios = id_servicios;
        this.matricula_vehiculo = matricula_vehiculo;
        this.nif_cliente = nif_cliente;
        this.fecha_alquiler = fecha_alquiler;
        this.fecha_entrega = fecha_entrega;
        this.total = total;
    }

    public Integer getId_servicios() {
        return id_servicios;
    }

    public void setId_servicios(Integer id_servicios) {
        this.id_servicios = id_servicios;
    }

    public String getMatricula_vehiculo() {
        return matricula_vehiculo;
    }

    public void setMatricula_vehiculo(String matricula_vehiculo) {
        this.matricula_vehiculo = matricula_vehiculo;
    }

    public String getNif_cliente() {
        return nif_cliente;
    }

    public void setNif_cliente(String nif_cliente) {
        this.nif_cliente = nif_cliente;
    }

    public LocalDate getFecha_alquiler() {
        return fecha_alquiler;
    }

    public void setFecha_alquiler(LocalDate fecha_alquiler) {
        this.fecha_alquiler = fecha_alquiler;
    }

    public LocalDate getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(LocalDate fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
