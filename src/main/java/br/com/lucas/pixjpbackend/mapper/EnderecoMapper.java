package br.com.lucas.pixjpbackend.mapper;

import br.com.lucas.pixjpbackend.dtos.BilheteCriadoResponse;
import br.com.lucas.pixjpbackend.dtos.CriarBilheteRequest;
import br.com.lucas.pixjpbackend.dtos.EnderecoDTO;
import br.com.lucas.pixjpbackend.model.Bilhete;
import br.com.lucas.pixjpbackend.model.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    @Mapping(target = "id", ignore = true)
    Endereco toEntity(EnderecoDTO dto);

   EnderecoDTO toDTO(Endereco endereco);
}
