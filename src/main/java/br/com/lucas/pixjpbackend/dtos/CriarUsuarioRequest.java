package br.com.lucas.pixjpbackend.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record CriarUsuarioRequest(
        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 150)
        String nome,

        @CPF(message = "CPF inválido")
        String cpf,

        @Past(message = "Data de nascimento é obrigátorio")
        LocalDate dataNascimento,

        @NotBlank(message = "Telefone é obrigatório")
        String telefone,

        @Email(message = "Email é obrigatório")
        String email,

        @Valid
        EnderecoDTO endereco
) {
}
