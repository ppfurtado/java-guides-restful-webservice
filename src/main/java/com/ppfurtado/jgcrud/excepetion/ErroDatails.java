package com.ppfurtado.jgcrud.excepetion;

import java.time.LocalDateTime;

public record ErroDatails(
        LocalDateTime timestamp,
        String message,
        String path,
        String errorCode
) {
}
