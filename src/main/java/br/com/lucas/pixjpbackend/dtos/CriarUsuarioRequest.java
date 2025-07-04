package br.com.lucas.pixjpbackend.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record CriarUsuarioRequest(
        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 150)
        String nome,

        @CPF(message = "CPF inválido")
        String cpf,

        @NotBlank(message = "Telefone é obrigatório")
        String telefone,

        @Email(message = "Email é obrigatório")
        String email,

        @Valid
        EnderecoDTO endereco
) {
}
