package com.example.Proyecto_Integrador.controller;

import com.example.Proyecto_Integrador.dto.ProductoDTO;
import com.example.Proyecto_Integrador.dto.ReservaDTO;
import com.example.Proyecto_Integrador.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @PostMapping()
    public ResponseEntity<ReservaDTO> crearReserva(@RequestBody ReservaDTO reserva){
        return ResponseEntity.ok(reservaService.crearReserva(reserva));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> buscarPorId(@PathVariable Integer id){
        ReservaDTO reservaDTO = reservaService.buscarPorId(id).orElse(null);
        return ResponseEntity.ok(reservaDTO);
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<ReservaDTO>> reservasPorIdUsuario(@PathVariable Integer id){
        return ResponseEntity.ok(reservaService.reservasPorIdUsuario(id));
    }


}
