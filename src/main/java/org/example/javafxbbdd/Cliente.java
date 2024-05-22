package org.example.javafxbbdd;

public class Cliente {
    private String nif;
    private String nya;
    private String direcion;
    private String poblacion;

    public Cliente() {
    }

    public Cliente(String nif, String nya, String direcion, String poblacion) {
        this.nif = nif;
        this.nya = nya;
        this.direcion = direcion;
        this.poblacion = poblacion;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNya() {
        return nya;
    }

    public void setNya(String nya) {
        this.nya = nya;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }
}
