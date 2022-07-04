package com.example.Proyecto_Integrador.service;

import com.example.Proyecto_Integrador.model.Caracteristica;
import com.example.Proyecto_Integrador.repository.impl.CaracteristicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CaracteristicaService {
    private final CaracteristicaRepository caracteristicaRepository;

    @Autowired
    CaracteristicaService(CaracteristicaRepository caracteristicaRepository){this.caracteristicaRepository =caracteristicaRepository;}

    public List<Caracteristica> listarCaracteristicas(){
        return caracteristicaRepository.listarCaracteristica();
    }
}
