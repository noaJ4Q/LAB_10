package com.example.lab10.model.Beans;

public class Contratos {
    private String nroDeContrato;
    private int idCliente;
    private String divisa;
    private String estado;
    private int mesesEnEseEstado;

    public String getNroDeContrato() {
        return nroDeContrato;
    }

    public void setNroDeContrato(String nroDeContrato) {
        this.nroDeContrato = nroDeContrato;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getMesesEnEseEstado() {
        return mesesEnEseEstado;
    }

    public void setMesesEnEseEstado(int mesesEnEseEstado) {
        this.mesesEnEseEstado = mesesEnEseEstado;
    }
}
