package com.ForoConSeguridad.controller;

import com.ForoConSeguridad.user.Usuario;
import com.ForoConSeguridad.user.UsuarioDTO;
import com.ForoConSeguridad.user.UsuarioRespuestaDTO;
import com.ForoConSeguridad.user.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<UsuarioRespuestaDTO> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO, UriComponentsBuilder uri){
        Usuario usuario = usuarioRepository.save(new Usuario(usuarioDTO));
        UsuarioRespuestaDTO usuarioRespuestaDTO = new UsuarioRespuestaDTO(usuario);
        URI url = uri.path("/usuario/{id}").buildAndExpand(usuario.getIdUsuario()).toUri();
        return ResponseEntity.created(url).body(usuarioRespuestaDTO);
    }

}