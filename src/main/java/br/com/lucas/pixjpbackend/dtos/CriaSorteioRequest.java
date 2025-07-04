package br.com.lucas.pixjpbackend.dtos;

import java.time.LocalDate;

public record CriaSorteioRequest(
        LocalDate dataSorteio,
        LocalDate dataInicio,
        LocalDate dataFinal
) {
}
