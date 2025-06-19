package br.com.lucas.pixjp_backend.dtos;

import java.time.LocalDate;

public record CriaSorteioRequest(
        LocalDate dataSorteio,
        LocalDate dataInicio,
        LocalDate dataFinal
) {
}
