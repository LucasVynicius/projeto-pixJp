package br.com.lucas.pixjp_backend.dtos;

import java.time.LocalDate;

public record BilhetePremiadoResponse(
        Long id,
        String numero,
        LocalDate dataCompra,
        UsuarioResumidoResponse usuario
) {
}
