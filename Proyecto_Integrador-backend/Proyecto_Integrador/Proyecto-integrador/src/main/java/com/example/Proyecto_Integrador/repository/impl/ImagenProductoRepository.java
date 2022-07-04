package com.example.Proyecto_Integrador.repository.impl;

import com.example.Proyecto_Integrador.model.Ciudad;
import com.example.Proyecto_Integrador.model.ImagenProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenProductoRepository extends JpaRepository<ImagenProducto,Integer> {
}
