package com.ForoConSeguridad.controller;
import com.ForoConSeguridad.security.ServicioToken;
import com.ForoConSeguridad.security.auth.JwtTokenDTO;
import com.ForoConSeguridad.security.auth.UsuarioAuthDTO;
import com.ForoConSeguridad.user.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ServicioToken servicioToken;



    @PostMapping
    public ResponseEntity autenticarUsuario(
            @RequestBody @Valid UsuarioAuthDTO usuarioAuthDTO){
        Authentication tokenAuth = new UsernamePasswordAuthenticationToken(
                usuarioAuthDTO.email(), usuarioAuthDTO.password());
        var usuarioAutenticado = authenticationManager.authenticate(tokenAuth);
        var tokenJWT = servicioToken.generarToken(
                (Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new JwtTokenDTO(tokenJWT));
    }
}
