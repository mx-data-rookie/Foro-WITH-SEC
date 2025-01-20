package com.ForoConSeguridad.controller;

import com.ForoConSeguridad.topic.*;
import com.ForoConSeguridad.user.Usuario;
import com.ForoConSeguridad.user.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tema")
public class TemaController {

    private final TemaRepository temaRepository;
    private final UsuarioRepository usuarioRepository;

    public TemaController(TemaRepository temaRepository, UsuarioRepository usuarioRepository) {
        this.temaRepository = temaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<TemaRespuestaDTO> registrarTema(@RequestBody @Valid TemaDTO temaDTO, UriComponentsBuilder uri){
        Usuario usuario = usuarioRepository.getReferenceById(temaDTO.idUsuario());
        Tema tema = temaRepository.save(new Tema(temaDTO, usuario));
        TemaRespuestaDTO temaRespuestaDTO = new TemaRespuestaDTO(tema);
        URI url = uri.path("/tema/{id}").buildAndExpand(tema.getIdTema()).toUri();
        return ResponseEntity.created(url).body(temaRespuestaDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ListaDeTemasDTO>> enlistarTemas(@PageableDefault(size = 3)Pageable paginar){
        return ResponseEntity.ok(temaRepository.findAll(paginar).map(ListaDeTemasDTO::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemaRespuestaUnicaDTO> mostrarUnTema(@PathVariable Long id){
        Tema tema = temaRepository.getReferenceById(id);
        return ResponseEntity.ok(new TemaRespuestaUnicaDTO(tema));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<TemaRespuestaDTO> actualizarTema(@RequestBody @Valid TemaActualizadoDTO temaActualizadoDTO){
        Usuario usuario = usuarioRepository.getReferenceById(temaActualizadoDTO.idUsuario());
        Tema tema = temaRepository.getReferenceById(temaActualizadoDTO.idTema());
        tema.actualizarTema(temaActualizadoDTO, usuario);
        return ResponseEntity.ok(new TemaRespuestaDTO(tema));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarLogicamenteTema(@PathVariable Long id){
        Tema tema = temaRepository.getReferenceById(id);
        tema.desactivarTema();
        return ResponseEntity.noContent().build();
    }

}
