package com.example.Proyecto_Integrador.service;

import com.example.Proyecto_Integrador.dto.CategoriaDTO;
import com.example.Proyecto_Integrador.dto.CiudadDTO;
import com.example.Proyecto_Integrador.model.Categoria;
import com.example.Proyecto_Integrador.model.Ciudad;
import com.example.Proyecto_Integrador.repository.impl.CiudadRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadService {
    private final CiudadRepository ciudadRepository;
    private static final ModelMapper modelMapper;

    @Autowired
    public CiudadService(CiudadRepository ciudadRepository){
        this.ciudadRepository= ciudadRepository;
    }
    static {
        modelMapper = new ModelMapper();
    }

    private Ciudad convertirDto(CiudadDTO ciudadDTO){
        Ciudad ciudad= new Ciudad(
                ciudadDTO.getId(), ciudadDTO.getProvincia(), ciudadDTO.getNombre(), ciudadDTO.getPais(), ciudadDTO.getDistanciaAlCentro()
        );
        return ciudad;
    }


    public List<CiudadDTO> ListarCiudades(){
        List<CiudadDTO> ciudadDTOS = modelMapper.map(ciudadRepository.findAll(),new TypeToken<List<CiudadDTO>>(){}.getType());
        return ciudadDTOS;
    }

    public Optional<CiudadDTO> buscaPorId(Integer id) {
        Optional<CiudadDTO> ciudadDTO = Optional.of(modelMapper.map(ciudadRepository.findById(id),CiudadDTO.class));
        return ciudadDTO;}
    public CiudadDTO guardarCiudad(CiudadDTO ciudadDTO){
        CiudadDTO ciudad=modelMapper.map(ciudadRepository.save(this.convertirDto(ciudadDTO)),CiudadDTO.class);
        return ciudad;
    }
}
