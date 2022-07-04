package com.example.Proyecto_Integrador.controller;


import com.example.Proyecto_Integrador.dto.CategoriaDTO;
import com.example.Proyecto_Integrador.dto.CiudadDTO;
import com.example.Proyecto_Integrador.model.Ciudad;
import com.example.Proyecto_Integrador.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/ciudad")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    @PostMapping()
    public ResponseEntity<CiudadDTO> registrarCategoria(@RequestBody CiudadDTO ciudad) {

        return ResponseEntity.ok(ciudadService.guardarCiudad(ciudad));

    }
    @GetMapping("/{id}")
    public ResponseEntity<CiudadDTO> buscar(@PathVariable Integer id) {
        CiudadDTO ciudad = ciudadService.buscaPorId(id).orElse(null);

        return ResponseEntity.ok(ciudad);
    }
    @PutMapping()
    public ResponseEntity<CiudadDTO> actualizar(@RequestBody CiudadDTO ciudad) {
        ResponseEntity<CiudadDTO> response = null;

        if (ciudad.getId() != null && ciudadService.buscaPorId(ciudad.getId()).isPresent())
            response = ResponseEntity.ok(ciudadService.guardarCiudad(ciudad));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }
}
