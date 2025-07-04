package br.com.lucas.pixjp_backend.dtos;

import java.time.LocalDate;

public record CriarBilheteRequest(
        String numero,
        Boolean premiado,
        LocalDate dataCompra,
        Long idUsuario,
        Long idSorteio
) {
}
