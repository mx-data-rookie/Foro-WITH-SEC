package com.ForoConSeguridad.topic;

public record TemaRespuestaDTO(
        String asunto,
        String mensaje,
        String autor

) {
    public TemaRespuestaDTO(Tema tema){
        this(
                tema.getAsunto(),
                tema.getMensaje(),
                tema.getUsuario().getAlias()
        );
    }
}
