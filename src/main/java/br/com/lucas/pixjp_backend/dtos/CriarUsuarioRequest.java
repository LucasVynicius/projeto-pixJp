package br.com.lucas.pixjp_backend.dtos;

import br.com.lucas.pixjp_backend.model.Endereco;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record CriarUsuarioRequest(
        String nome,
        @CPF
        String cpf,
        LocalDate dataNascimento,
        String telefone,
        String email,
        EnderecoDTO endereco
) {
}
