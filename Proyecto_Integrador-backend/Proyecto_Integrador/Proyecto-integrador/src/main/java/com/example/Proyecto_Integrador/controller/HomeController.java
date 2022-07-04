package com.example.Proyecto_Integrador.controller;

import com.example.Proyecto_Integrador.dto.CiudadDTO;
import com.example.Proyecto_Integrador.dto.ProductoDTO;
import com.example.Proyecto_Integrador.model.Categoria;
import com.example.Proyecto_Integrador.model.Ciudad;
import com.example.Proyecto_Integrador.service.CiudadService;
import com.example.Proyecto_Integrador.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/home")

public class HomeController {
    @Autowired
    private CiudadService ciudadService;
    @Autowired
    private ProductoService productoService;
    @GetMapping
    public ResponseEntity<List<CiudadDTO>> listarCiudades() {
        return ResponseEntity.ok(ciudadService.ListarCiudades());
    }

    @GetMapping("/ciudad/{id}")
    public ResponseEntity<List<ProductoDTO>> buscarPorCiudad(@PathVariable Integer id) {
        ResponseEntity respuesta=null;
        if(id!=null){
            respuesta= ResponseEntity.ok(productoService.productosPorCiudad(id));
        }
        return respuesta;
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<ProductoDTO>> buscarPorCategoria(@PathVariable Integer id) {
        ResponseEntity respuesta=null;
        if(id!=null){
            respuesta= ResponseEntity.ok(productoService.productosPorCategoria(id));
        }
        return respuesta;
    }


    @GetMapping("/fecha/{fecha1}/{fecha2}")
    public ResponseEntity<List<ProductoDTO>> buscarPorFecha(@PathVariable String fecha1, @PathVariable String fecha2) {
        ResponseEntity respuesta=null;
        if(fecha1!=null && fecha2!=null){
            respuesta= ResponseEntity.ok(productoService.productosPorFecha(fecha1,fecha2));
        }
        return respuesta;
    }

    @GetMapping("/ciudad/{id}/fecha/{fecha1}/{fecha2}")
    public ResponseEntity<List<ProductoDTO>> buscarPorFechaYCiudad(@PathVariable Integer id,@PathVariable String fecha1,@PathVariable String fecha2) {
        ResponseEntity respuesta=null;
        if(id!=null){
            respuesta= ResponseEntity.ok(productoService.productosPorFechaYCiudad(fecha1,fecha2,id));
        }
        return respuesta;
    }
}
