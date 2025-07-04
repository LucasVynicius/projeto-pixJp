package br.com.lucas.pixjpbackend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EnderecoDTO(
        @NotBlank(message = "Logradouro é obrigatório")
        @Size(max = 150)
        String logradouro,

        @NotBlank(message = "número é obrigátorio")
        @Size(max = 10)
        String numero,

        @Size(max = 50)
        String complemento,

        @NotBlank(message = "Bairro é obrigátorio")
        @Size(max = 50)
        String bairro,

        @NotBlank(message = "Cidade é obrigátorio")
        @Size(max = 50)
        String cidade,

        @NotBlank(message = "Estado é obrigátorio")
        @Size(max = 50)
        String estado,

        @NotBlank(message = "Pais é obrigátorio")
        @Size(max = 50)
        String pais,

        @NotBlank(message = "CEP é obrigátorio")
        @Size(max = 20)
        String cep

) {
}
