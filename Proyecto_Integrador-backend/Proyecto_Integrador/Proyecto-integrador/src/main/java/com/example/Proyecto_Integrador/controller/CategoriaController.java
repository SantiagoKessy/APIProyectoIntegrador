package com.example.Proyecto_Integrador.controller;

import com.example.Proyecto_Integrador.dto.CategoriaDTO;
import com.example.Proyecto_Integrador.model.Categoria;
import com.example.Proyecto_Integrador.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @PostMapping()
    public ResponseEntity<CategoriaDTO> registrarCategoria(@RequestBody CategoriaDTO categoria) {

        return ResponseEntity.ok(categoriaService.registrarCategoria(categoria));

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscar(@PathVariable Integer id) {
        CategoriaDTO categoria = categoriaService.buscar(id).orElse(null);

        return ResponseEntity.ok(categoria);
    }
    @PutMapping()
    public ResponseEntity<CategoriaDTO> actualizar(@RequestBody CategoriaDTO categoria) {
        ResponseEntity<CategoriaDTO> response = null;

        if (categoria.getId() != null && categoriaService.buscar(categoria.getId()).isPresent())
            response = ResponseEntity.ok(categoriaService.actualizar(categoria));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if (categoriaService.buscar(id).isPresent()) {
            categoriaService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> buscarTodas(){
        return ResponseEntity.ok(categoriaService.buscarTodas());
    }


}
