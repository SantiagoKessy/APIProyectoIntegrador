package com.example.Proyecto_Integrador.repository.impl;

import com.example.Proyecto_Integrador.model.Caracteristica;
import com.example.Proyecto_Integrador.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaracteristicaRepository extends JpaRepository<Caracteristica,Integer> {
    @Query(value = "Select * From caracteristica group by icono_url",nativeQuery = true)
    List<Caracteristica> listarCaracteristica();
}
