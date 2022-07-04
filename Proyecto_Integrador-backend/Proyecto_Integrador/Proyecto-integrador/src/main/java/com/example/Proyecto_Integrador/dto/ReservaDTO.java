package com.example.Proyecto_Integrador.dto;

import com.example.Proyecto_Integrador.model.Producto;
import com.example.Proyecto_Integrador.model.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Time;
import java.sql.Date;

public class ReservaDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("horaInicioReserva")
    private Time horaInicioReserva;
    @JsonProperty("fechaInicioReserva")
    private Date fechaInicioReserva;
    @JsonProperty("fechaFinReserva")
    private Date fechaFinReserva;
    @JsonProperty("producto")
    private Producto producto;
    @JsonProperty("usuario")
    private Usuario usuario;

    public ReservaDTO() {
    }

    public ReservaDTO(Time horaInicioReserva, Date fechaInicioReserva, Date fechaFinReserva, Producto producto, Usuario usuario) {
        this.horaInicioReserva = horaInicioReserva;
        this.fechaInicioReserva = fechaInicioReserva;
        this.fechaFinReserva = fechaFinReserva;
        this.producto = producto;
        this.usuario = usuario;
    }

    public ReservaDTO(int id, Time horaInicioReserva, Date fechaInicioReserva, Date fechaFinReserva, Producto producto, Usuario usuario) {
        this.id = id;
        this.horaInicioReserva = horaInicioReserva;
        this.fechaInicioReserva = fechaInicioReserva;
        this.fechaFinReserva = fechaFinReserva;
        this.producto = producto;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getHoraInicioReserva() {
        return horaInicioReserva;
    }

    public void setHoraInicioReserva(Time horaInicioReserva) {
        this.horaInicioReserva = horaInicioReserva;
    }

    public Date getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public void setFechaInicioReserva(Date fechaInicioReserva) {
        this.fechaInicioReserva = fechaInicioReserva;
    }

    public Date getFechaFinReserva() {
        return fechaFinReserva;
    }

    public void setFechaFinReserva(Date fechaFinReserva) {
        this.fechaFinReserva = fechaFinReserva;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



}
