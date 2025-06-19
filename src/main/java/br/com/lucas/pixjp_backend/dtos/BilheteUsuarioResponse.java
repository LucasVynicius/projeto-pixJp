package br.com.lucas.pixjp_backend.dtos;

import java.time.LocalDate;

public record BilheteUsuarioResponse(
        Long id,
        String numero,
        LocalDate dataCompra,
        Boolean premiado,
        Long sorteioId
) {
}
