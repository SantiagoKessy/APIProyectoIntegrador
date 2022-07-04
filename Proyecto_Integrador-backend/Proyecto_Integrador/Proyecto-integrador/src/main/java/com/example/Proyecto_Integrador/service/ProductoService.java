package com.example.Proyecto_Integrador.service;

import com.example.Proyecto_Integrador.dto.ProductoDTO;
import com.example.Proyecto_Integrador.dto.ReservaDTO;
import com.example.Proyecto_Integrador.model.*;
import com.example.Proyecto_Integrador.repository.impl.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductoService {
    private ReservaRepository reservaRepository;
    private final ProductoRepository productoRepository;
    private final ImagenProductoRepository imagenProductoRepository;
    private final PoliticaRepository politicaRepository;
    private final CaracteristicaRepository caracteristicaRepository;
    private static final ModelMapper modelMapper;

    @Autowired
    public ProductoService(ReservaRepository reservaRepository, ProductoRepository productoRepository, ImagenProductoRepository imagenProductoRepository, PoliticaRepository politicaRepository, CaracteristicaRepository caracteristicaRepository) {
        this.reservaRepository = reservaRepository;
        this.productoRepository = productoRepository;
        this.imagenProductoRepository = imagenProductoRepository;
        this.politicaRepository = politicaRepository;
        this.caracteristicaRepository = caracteristicaRepository;
    }



    static {
        modelMapper = new ModelMapper();
    }

    private Producto convertirDTO(ProductoDTO productoDTO){
        Producto producto = new Producto(
                productoDTO.getId(),productoDTO.getTitulo(),productoDTO.getCategoria(),productoDTO.getCiudad(), productoDTO.getImagenes(), productoDTO.getCaracteristicas(),productoDTO.getDescripcion(),productoDTO.getPoliticas(), (Date) productoDTO.getFechasDisponibles(), (Set<Reserva>) productoDTO.getReservas());
        return producto;
    }

    public ProductoDTO crearProducto(ProductoDTO productoDTO){
        System.out.println(productoDTO);
        List<ImagenProducto> imagenes= productoDTO.getImagenes();
        List<Politica> politicas = productoDTO.getPoliticas();
        List<Caracteristica> caracteristicas=productoDTO.getCaracteristicas();
        ProductoDTO producto = modelMapper.map(productoRepository.save(this.convertirDTO(productoDTO)),ProductoDTO.class);
        if (producto != null) {
            System.out.println(producto);
            for (ImagenProducto img:imagenes){
                img.setProducto(this.convertirDTO(producto));
                imagenProductoRepository.save(img);
            }
            for (Politica pol:politicas){
                pol.setProducto(this.convertirDTO(producto));
                politicaRepository.save(pol);
            }
            for (Caracteristica car:caracteristicas){
                car.setProducto(this.convertirDTO(producto));
                caracteristicaRepository.save(car);
            }
            return producto;
        }else {
            return producto;
        }
    }

    public Optional<ProductoDTO> buscarPorID(Integer id){
        Optional<ProductoDTO> productoDTO = Optional.of(modelMapper.map(productoRepository.findById(id),ProductoDTO.class));
        return productoDTO;
    }

    public List<ProductoDTO> listarProductos(){
        List<ProductoDTO> productos = modelMapper.map(productoRepository.findAll(),new TypeToken<List<ProductoDTO>>(){}.getType());
        return productos;
    }

   public List<ProductoDTO> productosPorCiudad(Integer id){
        List<ProductoDTO> productos = modelMapper.map(productoRepository.productosPorCiudad(id),new TypeToken<List<ProductoDTO>>(){}.getType());
        return productos;
    }
    public List<ProductoDTO> productosPorCategoria(Integer id){
        List<ProductoDTO> productos = modelMapper.map(productoRepository.productosPorCategoria(id),new TypeToken<List<ProductoDTO>>(){}.getType());
        return productos;
    }
    public List<ProductoDTO> productosPorFecha(String fecha1,String fecha2){
        List<ProductoDTO> productos = modelMapper.map(productoRepository.productosPorFecha(fecha1,fecha2),new TypeToken<List<ProductoDTO>>(){}.getType());
        return productos;
    }
    public List<ProductoDTO> productosPorFechaYCiudad(String fecha1,String fecha2,Integer id){
        List<ProductoDTO> productos = modelMapper.map(productoRepository.productosPorFechaYCiudad(fecha1,fecha2,id),new TypeToken<List<ProductoDTO>>(){}.getType());
        return productos;
    }
    public List<ReservaDTO> reservaDeProducto(Integer id){
        List<ReservaDTO> reserva = modelMapper.map(reservaRepository.reservasDeProducto(id),new TypeToken<List<ReservaDTO>>(){}.getType());
        return reserva;
    }
}
