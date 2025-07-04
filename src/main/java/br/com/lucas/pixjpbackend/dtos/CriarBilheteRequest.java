package br.com.lucas.pixjpbackend.dtos;

public record CriarBilheteRequest(
        String numero,
        Long idUsuario,
        Long idSorteio
) {
}
