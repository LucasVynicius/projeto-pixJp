package br.com.lucas.pixjpbackend.dtos;

public record UsuarioCriadoResponse(
        Long id,
        String nome,
        String telefone,
        String email,
        EnderecoDTO endereco
) {
}
