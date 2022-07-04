package com.example.Proyecto_Integrador.dto;

import com.example.Proyecto_Integrador.model.Rol;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class UsuarioDTO {
    @JsonProperty("id")
    private long id;
    private String nombre;
    private String apellido;
    private String email;
    private String ciudad;
    private Rol rol;
    private String contrasenia;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String nombre, String apellido, String email, String ciudad, Rol rol, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.ciudad = ciudad;
        this.rol = rol;
        this.contrasenia = contrasenia;
    }

    public UsuarioDTO(long id, String nombre, String apellido, String email, String ciudad, Rol rol, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.ciudad = ciudad;
        this.rol = rol;
        this.contrasenia = contrasenia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String constrasenia) {
        this.contrasenia = constrasenia;
    }
}
