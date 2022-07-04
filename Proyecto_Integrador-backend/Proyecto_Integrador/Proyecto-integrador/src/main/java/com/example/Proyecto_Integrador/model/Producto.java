package com.example.Proyecto_Integrador.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table (name="productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "titulo")
    private String titulo;

    @Basic
    @ManyToOne
    @JoinColumn(name="categoria_id")
    @JsonIgnore
    private Categoria categorias;

    @Basic
    @ManyToOne
    @JoinColumn(name="ciudad_id")
    @JsonIgnore
    private Ciudad ciudades;


    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ImagenProducto> imagenes;

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Caracteristica> caracteristicas ;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Politica> politicas ;
    @Basic
    @Column(name = "fechasDisponibles")
    private Date fechasDisponibles;
    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    private Set<Reserva> reserva = new HashSet<>();

    public Producto() {
    }

    public Producto(Integer id, String titulo, Categoria categoria, Ciudad ciudad, List<ImagenProducto> imagenes, List<Caracteristica> caracteristicas, String descripcion, List<Politica> politicas, Date fechasDisponibles, Set<Reserva> reserva) {
        this.id = id;
        this.titulo = titulo;
        this.categorias = categoria;
        this.ciudades = ciudad;
        this.imagenes = imagenes;
        this.caracteristicas = caracteristicas;
        this.descripcion = descripcion;
        this.politicas = politicas;
        this.fechasDisponibles = fechasDisponibles;
        this.reserva = reserva;
    }

    public Producto(String titulo, Categoria categoria, Ciudad ciudad, List<ImagenProducto> imagenes, List<Caracteristica> caracteristicas, String descripcion, List<Politica> politicas, Date fechasDisponibles, Set<Reserva> reserva) {
        this.titulo = titulo;
        this.categorias = categoria;
        this.ciudades = ciudad;
        this.imagenes = imagenes;
        this.caracteristicas = caracteristicas;
        this.descripcion = descripcion;
        this.politicas = politicas;
        this.fechasDisponibles = fechasDisponibles;
        this.reserva = reserva;
    }

    public Set<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(Set<Reserva> reserva) {
        this.reserva = reserva;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Categoria getCategoria() {
        return categorias;
    }

    public void setCategoria(Categoria categoria) {
        this.categorias = categoria;
    }

    public Ciudad getCiudad() {
        return ciudades;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudades = ciudad;
    }

    public List<ImagenProducto> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<ImagenProducto> imagenes) {
        this.imagenes = imagenes;
    }

    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Politica> getPoliticas() {
        return politicas;
    }

    public void setPoliticas(List<Politica> politicas) {
        this.politicas = politicas;
    }

    public Date getFechasDisponibles() {
        return fechasDisponibles;
    }

    public void setFechasDisponibles(Date fechasDisponibles) {
        this.fechasDisponibles = fechasDisponibles;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", categorias=" + categorias +
                ", ciudades=" + ciudades +
                ", caracteristicas=" + caracteristicas +
                ", descripcion='" + descripcion + '\'' +
                ", politicas=" + politicas +
                ", fechasDisponibles=" + fechasDisponibles +
                ", reserva=" + reserva +
                '}';
    }
}
