package com.ppfurtado.jgcrud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserDto(
        Long id,
        @NotEmpty
        String firstName,
        @NotEmpty
        String lastName,
        @NotEmpty
        @Email(message = "The email must be valid")
        String email
) {
}
