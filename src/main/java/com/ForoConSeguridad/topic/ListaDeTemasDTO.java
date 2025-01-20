package com.ForoConSeguridad.topic;

public record ListaDeTemasDTO(
        Long idTema,
        String asunto,
        String mensaje,
        String autor
) {
    public ListaDeTemasDTO(Tema tema){
        this(
                tema.getIdTema(),
                tema.getAsunto(),
                tema.getMensaje(),
                tema.getUsuario().getAlias()
        );
    }
}
