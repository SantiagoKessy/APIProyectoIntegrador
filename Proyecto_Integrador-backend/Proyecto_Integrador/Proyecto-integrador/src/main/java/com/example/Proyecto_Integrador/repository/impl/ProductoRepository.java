package com.example.Proyecto_Integrador.repository.impl;

import com.example.Proyecto_Integrador.model.Ciudad;
import com.example.Proyecto_Integrador.model.Producto;
import com.example.Proyecto_Integrador.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    @Query(value = "SELECT * FROM productos WHERE productos.ciudad_id =?1",nativeQuery = true)
     List<Producto> productosPorCiudad(Integer id);

    @Query(value = "SELECT * FROM productos WHERE productos.categoria_id =?1",nativeQuery = true)
     List<Producto> productosPorCategoria(Integer id);

    @Query(value = "select * from productos " +
            "inner join reservas  " +
            "on reservas.producto_id = productos.id " +
            "where (reservas.fecha_fin_reserva < ?1 OR reservas.fecha_inicio_reserva > ?2) " +
            "And (productos.id NOT IN " +
            "(select productos.id from productos left join reservas on reservas.producto_id = productos.id " +
            "where reservas.fecha_fin_reserva >= ?1 and reservas.fecha_inicio_reserva <= ?2)) group by productos.id;",nativeQuery = true)
    List<Producto> productosPorFecha(String fecha1,String fecha2);


    @Query(value = "select * from productos " +
            "inner join reservas  " +
            "on reservas.producto_id = productos.id " +
            "where (reservas.fecha_fin_reserva < ?1 OR reservas.fecha_inicio_reserva > ?2) " +
            "And (productos.id NOT IN " +
            "(select productos.id from productos left join reservas on reservas.producto_id = productos.id " +
            "where reservas.fecha_fin_reserva >= ?1 and reservas.fecha_inicio_reserva <= ?2))  "+
            "AND (productos.ciudad_id= ?3) group by productos.id",nativeQuery = true)
    List<Producto> productosPorFechaYCiudad(String fecha1,String fecha2,Integer id);

}
