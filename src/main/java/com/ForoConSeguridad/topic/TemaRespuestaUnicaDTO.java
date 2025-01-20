package com.ForoConSeguridad.topic;

public record TemaRespuestaUnicaDTO(
        Long idTema,
        String autor,
        String asunto,
        String asignatura,
        String mensaje,
        String fechaCreacion
) {
    public TemaRespuestaUnicaDTO(Tema tema){
        this(
                tema.getIdTema(),
                tema.getUsuario().getAlias(),
                tema.getAsunto(),
                tema.getAsignaturaEnum().toString(), //Si se niega a funcionar, cambiar toString a name
                tema.getMensaje(),
                tema.getFechaCreacion().toString()

        );
    }
}
