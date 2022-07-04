package com.example.Proyecto_Integrador.repository.impl;


import com.example.Proyecto_Integrador.model.Producto;
import com.example.Proyecto_Integrador.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Integer> {
    @Query(value = "SELECT * FROM reservas WHERE reservas.producto_id =?1",nativeQuery = true)
    List<Reserva> reservasDeProducto(Integer id);
    @Query(value = "SELECT * FROM reservas inner join usuarios on reservas.usuario_id= usuarios.id",nativeQuery = true)
    List<Reserva> reservasPorIdUsuario(Integer id);
}
