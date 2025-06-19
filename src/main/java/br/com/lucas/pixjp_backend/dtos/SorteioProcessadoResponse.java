package br.com.lucas.pixjp_backend.dtos;

public record SorteioProcessadoResponse(
        String mensagem,
        String numeroSorteado,
        BilhetePremiadoResponse bilhetePremiado
) {
}
