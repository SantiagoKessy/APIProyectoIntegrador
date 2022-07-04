package com.example.Proyecto_Integrador.controller;

import com.example.Proyecto_Integrador.dto.CategoriaDTO;
import com.example.Proyecto_Integrador.dto.CiudadDTO;
import com.example.Proyecto_Integrador.dto.ProductoDTO;
import com.example.Proyecto_Integrador.dto.ReservaDTO;
import com.example.Proyecto_Integrador.model.Categoria;
import com.example.Proyecto_Integrador.model.Ciudad;
import com.example.Proyecto_Integrador.model.ImagenProducto;
import com.example.Proyecto_Integrador.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping()
    public ResponseEntity<ProductoDTO> crearProducto(@RequestBody ProductoDTO producto) {

        return ResponseEntity.ok(productoService.crearProducto(producto));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> buscarPorID(@PathVariable Integer id) {
        ProductoDTO productoDTO = productoService.buscarPorID(id).orElse(null);
        return ResponseEntity.ok(productoDTO);
    }
    @PutMapping()
    public ResponseEntity<ProductoDTO> actualizar(@RequestBody ProductoDTO productoDTO) {
        ResponseEntity<ProductoDTO> response = null;

        if (productoDTO.getId() != null && productoService.buscarPorID(productoDTO.getId()).isPresent())
            response = ResponseEntity.ok(productoService.crearProducto(productoDTO));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listarProductos(){
        return ResponseEntity.ok(productoService.listarProductos());
    }
    @GetMapping("/buscarPorProducto/{idProd}")
    public ResponseEntity<List<ReservaDTO>> buscarPorProducto(@PathVariable Integer idProd){
        return ResponseEntity.ok(productoService.reservaDeProducto(idProd));
    }


}
