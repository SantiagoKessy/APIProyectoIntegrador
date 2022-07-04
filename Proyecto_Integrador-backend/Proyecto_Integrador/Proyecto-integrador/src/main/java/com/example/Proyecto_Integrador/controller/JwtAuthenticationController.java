package com.example.Proyecto_Integrador.controller;

import com.example.Proyecto_Integrador.Exceptions.UsuarioRegistradoException;
import com.example.Proyecto_Integrador.config.JwtTokenUtil;
import com.example.Proyecto_Integrador.dto.ProductoDTO;
import com.example.Proyecto_Integrador.dto.UsuarioDTO;
import com.example.Proyecto_Integrador.model.JwtRequest;
import com.example.Proyecto_Integrador.model.JwtResponse;
import com.example.Proyecto_Integrador.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @CrossOrigin
    public class JwtAuthenticationController {

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private JwtTokenUtil jwtTokenUtil;

        @Autowired
        private JwtUserDetailsService userDetailsService;


        @PostMapping("/authenticate")
        public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

            final UserDetails userDetails = userDetailsService
                    .loadUserByUsername(authenticationRequest.getUsername());

            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new JwtResponse(token));
        }


        /*@RequestMapping(value = "/register", method = RequestMethod.POST)
        public ResponseEntity<?> saveUser(@RequestBody UsuarioDTO user) throws Exception {
            return ResponseEntity.ok(userDetailsService.save(user));
        }*/
        @PostMapping("/register")
        public ResponseEntity<?> saveUser(@RequestBody UsuarioDTO user) throws UsuarioRegistradoException {
            if (userDetailsService.usuarioPorEmail(user.getEmail()) != null ){
                throw new UsuarioRegistradoException("Ya existe un usuario con el email: " + user.getEmail());
            }else
            return ResponseEntity.ok(userDetailsService.save(user));
        }

        @GetMapping("/login/{email}/{contrasenia}")
        public ResponseEntity<UsuarioDTO> buscarUsuario(@PathVariable String email,@PathVariable String contrasenia) throws Exception{
            return ResponseEntity.ok(userDetailsService.buscarUsuarioNombreYContrasenia(email,contrasenia));
        }

        @PutMapping("/actualizar/usuario")
        public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioDTO user) throws Exception {
            ResponseEntity<?> response = null;
            if (user.getEmail() != null && userDetailsService.loadUserByUsername(user.getEmail()).isAccountNonExpired()) {
                response = ResponseEntity.ok(userDetailsService.actualizarUsuario(user));
            } else {
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return response;
        }

        private void authenticate(String email, String contrasenia) throws Exception {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, contrasenia));
            } catch (DisabledException e) {
                throw new Exception("USER_DISABLED", e);
            } catch (BadCredentialsException e) {
                throw new Exception("INVALID_CREDENTIALS", e);
            }
        }
    }

