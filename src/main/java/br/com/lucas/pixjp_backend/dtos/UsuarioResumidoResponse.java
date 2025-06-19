package br.com.lucas.pixjp_backend.dtos;

public record UsuarioResumidoResponse(
        Long id,
        String nome,
        String email
) {
}
