package com.example.Proyecto_Integrador.service;

import com.example.Proyecto_Integrador.dto.CategoriaDTO;
import com.example.Proyecto_Integrador.model.Categoria;
import com.example.Proyecto_Integrador.repository.impl.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;
    private static final ModelMapper modelMapper;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository= categoriaRepository;
    }
    static {
        modelMapper = new ModelMapper();
    }
    private Categoria convertirDto(CategoriaDTO categoriaDTO){
        Categoria categoria= new Categoria(
                categoriaDTO.getId(), categoriaDTO.getTitulo(),categoriaDTO.getDescripcion(),categoriaDTO.getUrlImagen()
        );
        return categoria;
    }


    public CategoriaDTO registrarCategoria(CategoriaDTO categoria){
        CategoriaDTO categoriaDTO=modelMapper.map(categoriaRepository.save(this.convertirDto(categoria)),CategoriaDTO.class);
        return categoriaDTO;
    }

    public void eliminar(Integer id){categoriaRepository.deleteById(id); }

    public Optional<CategoriaDTO> buscar(Integer id){
        Optional<CategoriaDTO> categoriaDTO = Optional.of(modelMapper.map(categoriaRepository.findById(id),CategoriaDTO.class));
        return categoriaDTO;}

    public List<CategoriaDTO> buscarTodas(){
        List<CategoriaDTO> categoriaDTOList = modelMapper.map(categoriaRepository.findAll(),new TypeToken<List<CategoriaDTO>>(){}.getType());
        return categoriaDTOList;}

    public CategoriaDTO actualizar(CategoriaDTO categoria){
        CategoriaDTO categoriaDTO=modelMapper.map(categoriaRepository.save(this.convertirDto(categoria)),CategoriaDTO.class);
        return categoriaDTO;
    }
}
