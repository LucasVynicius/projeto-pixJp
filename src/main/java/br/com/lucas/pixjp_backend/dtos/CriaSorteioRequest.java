package br.com.lucas.pixjp_backend.dtos;

import java.time.LocalDate;

public record CriaSorteioRequest(
        String numero,
        Boolean premiado,
        LocalDate dataCompra
) {
}
