package com.example.Proyecto_Integrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column
    private Time horaInicioReserva;
    @Column
    private Date fechaInicioReserva;
    @Column
    private Date fechaFinReserva;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="producto_id")
    @JsonIgnore
    private Producto producto;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="usuario_id")
    @JsonIgnore
    private Usuario usuario;

    public Reserva() {
    }

    public Reserva(Time horaInicioReserva, Date fechaInicioReserva, Date fechaFinReserva, Producto producto, Usuario usuario) {
        this.horaInicioReserva = horaInicioReserva;
        this.fechaInicioReserva = fechaInicioReserva;
        this.fechaFinReserva = fechaFinReserva;
        this.producto = producto;
        this.usuario = usuario;
    }

    public Reserva(Integer id, Time horaInicioReserva, Date fechaInicioReserva, Date fechaFinReserva, Producto producto, Usuario usuario) {
        this.id = id;
        this.horaInicioReserva = horaInicioReserva;
        this.fechaInicioReserva = fechaInicioReserva;
        this.fechaFinReserva = fechaFinReserva;
        this.producto = producto;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
