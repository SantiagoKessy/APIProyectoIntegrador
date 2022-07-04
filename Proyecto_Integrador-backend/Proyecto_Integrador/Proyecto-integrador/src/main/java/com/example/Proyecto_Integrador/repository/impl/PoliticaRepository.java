package com.example.Proyecto_Integrador.repository.impl;

import com.example.Proyecto_Integrador.model.Politica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliticaRepository extends JpaRepository<Politica,Integer> {
}
