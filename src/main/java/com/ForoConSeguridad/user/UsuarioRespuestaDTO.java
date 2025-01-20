package com.ForoConSeguridad.user;

public record UsuarioRespuestaDTO(
        String alias,
        String email
) {
    public UsuarioRespuestaDTO(Usuario usuario){
        this(
                usuario.getAlias(),
                usuario.getEmail()
        );
    }
}
