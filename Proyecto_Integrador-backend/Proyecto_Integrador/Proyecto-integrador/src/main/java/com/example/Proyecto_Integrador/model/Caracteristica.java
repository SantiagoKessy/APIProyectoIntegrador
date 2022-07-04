package com.example.Proyecto_Integrador.model;

import javax.persistence.*;

@Entity
@Table(name = "caracteristica")
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column (name = "nombre")
    private String nombre;
    @Basic
    @Column (name = "icono_url")
    private String iconoUrl;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public Caracteristica(){}

    public Caracteristica(Integer id, String nombre, String iconoUrl, Producto producto) {
        this.id = id;
        this.nombre = nombre;
        this.iconoUrl = iconoUrl;
        this.producto = producto;
    }

    public Caracteristica(String nombre, String iconoUrl, Producto producto) {
        this.nombre = nombre;
        this.iconoUrl = iconoUrl;
        this.producto = producto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIconoUrl() {
        return iconoUrl;
    }

    public void setIconoUrl(String iconoUrl) {
        this.iconoUrl = iconoUrl;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
