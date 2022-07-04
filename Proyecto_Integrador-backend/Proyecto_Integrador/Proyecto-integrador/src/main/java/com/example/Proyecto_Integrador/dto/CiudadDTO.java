package com.example.Proyecto_Integrador.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Basic;
import javax.persistence.Column;

public class CiudadDTO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("provincia")
    private String provincia;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("pais")
    private String pais;
    @JsonProperty("distanciaAlCentro")
    private String distanciaAlCentro;

    public CiudadDTO() {
    }

    public CiudadDTO(Integer id, String provincia, String nombre, String pais, String distanciaAlCentro) {
        this.id = id;
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
