package com.example.Proyecto_Integrador.model;

import javax.persistence.*;

@Entity
@Table (name="politicas")
public class Politica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column (name = "casa")
    private String casa;
    @Column (name = "salud")
    private String salud;
    @Column (name = "cancelacion")
    private String cancelacion;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public Politica(){}

    public Politica(Integer id, String casa, String salud, String cancelacion, Producto producto) {
        this.id = id;
        this.casa = casa;
        this.salud = salud;
        this.cancelacion = cancelacion;
        this.producto = producto;
    }

    public Politica(String casa, String salud, String cancelacion, Producto producto) {
        this.casa = casa;
        this.salud = salud;
        this.cancelacion = cancelacion;
        this.producto = producto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getSalud() {
        return salud;
    }

    public void setSalud(String salud) {
        this.salud = salud;
    }

    public String getCancelacion() {
        return cancelacion;
    }

    public void setCancelacion(String cancelacion) {
        this.cancelacion = cancelacion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
