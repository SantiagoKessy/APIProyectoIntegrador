package com.example.Proyecto_Integrador.controller;

import com.example.Proyecto_Integrador.model.Caracteristica;
import com.example.Proyecto_Integrador.service.CaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/caracteristicas")
public class CaracteristicaController {
    @Autowired
    private CaracteristicaService caracteristicaService;

    @GetMapping
    public ResponseEntity<List<Caracteristica>> listaCaracteristicas(){
        return ResponseEntity.ok(caracteristicaService.listarCaracteristicas());
    }
}
