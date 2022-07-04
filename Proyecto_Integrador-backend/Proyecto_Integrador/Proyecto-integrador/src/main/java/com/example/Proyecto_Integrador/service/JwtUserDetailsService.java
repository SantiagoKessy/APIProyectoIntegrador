package com.example.Proyecto_Integrador.service;
import java.util.ArrayList;
import java.util.List;

import com.example.Proyecto_Integrador.dto.UsuarioDTO;
import com.example.Proyecto_Integrador.model.Usuario;
import com.example.Proyecto_Integrador.repository.impl.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService{
    private static final ModelMapper modelMapper;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;
    static {
        modelMapper = new ModelMapper();
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario= usuarioRepository.findByEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con el email de: " + email);
        }
        return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getContrasenia(),
                new ArrayList<>());
    }

    public UsuarioDTO buscarUsuarioNombreYContrasenia(String email, String contrasenia){
        List<Usuario> listaUsuarios= usuarioRepository.findAll();
        UsuarioDTO usuarioEncontrado = new UsuarioDTO();
        listaUsuarios.forEach(usuario -> {
            if (email.equalsIgnoreCase(usuario.getEmail()) && bcryptEncoder.matches(contrasenia,usuario.getContrasenia())){
                usuarioEncontrado.setId(usuario.getId());
                usuarioEncontrado.setEmail(usuario.getEmail());
                usuarioEncontrado.setNombre(usuario.getNombre());
                usuarioEncontrado.setApellido(usuario.getApellido());
                usuarioEncontrado.setRol(usuario.getRol());
                usuarioEncontrado.setContrasenia(usuario.getContrasenia());
            }
        });
        if (usuarioEncontrado.getEmail() == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con el email de: " + email);
        }
        return usuarioEncontrado;
    }
    public Usuario save(UsuarioDTO user) {
        Usuario newUser = new Usuario();
        newUser.setId(user.getId());
        newUser.setNombre(user.getNombre());
        newUser.setCiudad(user.getCiudad());
        newUser.setApellido(user.getApellido());
        newUser.setEmail(user.getEmail());
        newUser.setRol(user.getRol());
        newUser.setContrasenia(bcryptEncoder.encode(user.getContrasenia()));
        return usuarioRepository.save(newUser);
    }
    public Usuario usuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }
    public Usuario actualizarUsuario(UsuarioDTO user){
        Usuario newUser = new Usuario();
        newUser.setId(user.getId());
        newUser.setNombre(user.getNombre());
        newUser.setCiudad(user.getCiudad());
        newUser.setApellido(user.getApellido());
        newUser.setEmail(user.getEmail());
        newUser.setRol(user.getRol());
        newUser.setContrasenia(user.getContrasenia());
        return usuarioRepository.save(newUser);
    }
}