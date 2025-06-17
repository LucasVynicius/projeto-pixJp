package br.com.lucas.pixjp_backend.dtos;

import java.time.LocalDate;

public record CriarUsuarioRequest(
        String nome,
        String cpf,
        LocalDate dataNascimento,
        String telefone,
        String email,
        String endereco
) {
}
