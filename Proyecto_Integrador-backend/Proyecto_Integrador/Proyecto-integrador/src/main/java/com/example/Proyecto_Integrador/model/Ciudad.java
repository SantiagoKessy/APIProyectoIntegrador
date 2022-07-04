package com.example.Proyecto_Integrador.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ciudades")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column (name = "provincia")
    private String provincia;
    @Basic
    @Column (name = "nombre")
    private String nombre;
    @Basic
    @Column (name = "pais")
    private String pais;
    @Basic
    @Column (name = "distancia_al_centro")
    private String distanciaAlCentro;
    @OneToMany(mappedBy = "ciudades", cascade = CascadeType.ALL)
    private Set<Producto> productos= new HashSet<>();

    public Ciudad(){}

    public Ciudad(Integer id, String provincia, String nombre, String pais, String distanciaAlCentro) {
        this.id = id;
        this.provincia = provincia;
        this.nombre = nombre;
        this.pais = pais;
        this.distanciaAlCentro = distanciaAlCentro;
    }

    public Ciudad(String provincia, String nombre, String pais, String distanciaAlCentro) {
        this.provincia = provincia;
        this.nombre = nombre;
        this.pais = pais;
        this.distanciaAlCentro = distanciaAlCentro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDistanciaAlCentro() {
        return distanciaAlCentro;
    }

    public void setDistanciaAlCentro(String distanciaAlCentro) {
        this.distanciaAlCentro = distanciaAlCentro;
    }

}
