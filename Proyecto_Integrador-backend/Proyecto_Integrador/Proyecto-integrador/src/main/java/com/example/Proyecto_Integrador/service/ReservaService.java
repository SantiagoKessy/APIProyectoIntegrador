package com.example.Proyecto_Integrador.service;

import com.example.Proyecto_Integrador.dto.ProductoDTO;
import com.example.Proyecto_Integrador.dto.ReservaDTO;
import com.example.Proyecto_Integrador.model.*;
import com.example.Proyecto_Integrador.repository.impl.ReservaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ReservaService {

    private ReservaRepository reservaRepository;
    private static ModelMapper modelMapper;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    static {
        modelMapper = new ModelMapper();
    }
    private Reserva convertirDTO(ReservaDTO reservaDTO){
        Reserva reserva = new Reserva(
                reservaDTO.getId(),reservaDTO.getHoraInicioReserva(),reservaDTO.getFechaInicioReserva(),reservaDTO.getFechaFinReserva(), reservaDTO.getProducto(), reservaDTO.getUsuario());
        return reserva;
    }
    public ReservaDTO crearReserva(ReservaDTO reservaDTO){
        ReservaDTO reserva = modelMapper.map(reservaRepository.save(this.convertirDTO(reservaDTO)),ReservaDTO.class);
        return reserva;
    }

    public Optional<ReservaDTO> buscarPorId(Integer id){
        Optional<ReservaDTO> reservaDTO = Optional.of(modelMapper.map(reservaRepository.findById(id),ReservaDTO.class));
        return reservaDTO;
    }
    public List<ReservaDTO> reservasPorIdUsuario(Integer id){
        List<ReservaDTO> reserva = modelMapper.map(reservaRepository.reservasPorIdUsuario(id),new TypeToken<List<ReservaDTO>>(){}.getType());
        return reserva;
    }


}
