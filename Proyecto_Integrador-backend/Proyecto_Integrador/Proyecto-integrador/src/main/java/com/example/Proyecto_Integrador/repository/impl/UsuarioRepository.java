package com.example.Proyecto_Integrador.repository.impl;

import com.example.Proyecto_Integrador.model.Producto;
import com.example.Proyecto_Integrador.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    @Query(value = "SELECT * FROM usuario",nativeQuery = true)
    List<Usuario> findByNombreYContrasenia();
    @Query(value = "UPDATE usuario " +
            " SET " +
            " usuario.ciudad = ?1 " +
            " WHERE usuario.email = ?2",nativeQuery = true)
    void actualizarUsuario(String ciudad, String email);

    Usuario findByEmail(String email);
}
