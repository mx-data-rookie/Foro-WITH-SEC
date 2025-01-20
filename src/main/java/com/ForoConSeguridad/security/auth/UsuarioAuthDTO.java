package com.ForoConSeguridad.security.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioAuthDTO(
        @NotBlank @Email String email,
        @NotBlank String password
) {
}
