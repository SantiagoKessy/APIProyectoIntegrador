package com.example.Proyecto_Integrador.repository.impl;

import com.example.Proyecto_Integrador.dto.CategoriaDTO;
import com.example.Proyecto_Integrador.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
