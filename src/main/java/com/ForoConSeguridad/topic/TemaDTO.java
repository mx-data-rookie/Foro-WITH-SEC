package com.ForoConSeguridad.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TemaDTO(
        @NotNull Long idUsuario,
        @NotBlank String asunto,
        @NotBlank String mensaje,
        @NotNull AsignaturaEnum asignaturaEnum
) {
}
