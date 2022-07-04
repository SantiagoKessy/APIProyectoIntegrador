package com.example.Proyecto_Integrador.dto;

import com.example.Proyecto_Integrador.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ProductoDTO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("categoria")
    private Categoria categoria;
    @JsonProperty("ciudad")
    private Ciudad ciudad;
    @JsonProperty("imagenes")
    private List<ImagenProducto> imagenes;
    @JsonProperty("caracteristicas")
    private List<Caracteristica> caracteristicas;
    @JsonProperty("reservas")
    private Set<Reserva> reservas;
    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("politicas")
    private List<Politica>  politicas;
    @JsonProperty("fechasDisponibles")
    private Date fechasDisponibles;

    public ProductoDTO(){}

    public ProductoDTO(Integer id, String titulo, Categoria categoria, Ciudad ciudad, List<ImagenProducto> imagenes, List<Caracteristica> caracteristicas, Set<Reserva> reservas, String descripcion, List<Politica> politicas, Date fechasDisponibles) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.ciudad = ciudad;
        this.imagenes = imagenes;
        this.caracteristicas = caracteristicas;
        this.reservas = reservas;
        this.descripcion = descripcion;
        this.politicas = politicas;
        this.fechasDisponibles = fechasDisponibles;
    }

    public ProductoDTO(String titulo, Categoria categoria, Ciudad ciudad, List<ImagenProducto> imagenes, List<Caracteristica> caracteristicas, Set<Reserva> reservas, String descripcion, List<Politica> politicas, Date fechasDisponibles) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.ciudad = ciudad;
        this.imagenes = imagenes;
        this.caracteristicas = caracteristicas;
        this.reservas = reservas;
        this.descripcion = descripcion;
        this.politicas = politicas;
        this.fechasDisponibles = fechasDisponibles;
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
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
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
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
        return "ProductoDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", categoria=" + categoria +
                ", ciudad=" + ciudad +
                ", imagenes=" + imagenes +
                ", caracteristicas=" + caracteristicas +
                ", reservas=" + reservas +
                ", descripcion='" + descripcion + '\'' +
                ", politicas=" + politicas +
                ", fechasDisponibles=" + fechasDisponibles +
                '}';
    }
}
