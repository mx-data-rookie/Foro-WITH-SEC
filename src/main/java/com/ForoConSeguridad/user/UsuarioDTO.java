package com.ForoConSeguridad.user;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
        @NotBlank String alias,
        @NotBlank @Email String email,
        @NotBlank String password
) {
}
