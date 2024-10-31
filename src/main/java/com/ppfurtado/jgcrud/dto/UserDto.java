package com.ppfurtado.jgcrud.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserDto(
        @Schema(
                description = "Id entity"
        )
        Long id,
        @Schema(
                description = "Fist Name User"
        )
        @NotEmpty
        String firstName,
        @Schema(
                description = "Last name User"
        )
        @NotEmpty
        String lastName,
        @Schema(
                description = "email User"
        )
        @NotEmpty
        @Email(message = "The email must be valid")
        String email
) {
}
