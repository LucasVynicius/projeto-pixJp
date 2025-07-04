package br.com.lucas.pixjpbackend.mapper;

import br.com.lucas.pixjpbackend.dtos.BilheteCriadoResponse;
import br.com.lucas.pixjpbackend.dtos.CriarBilheteRequest;
import br.com.lucas.pixjpbackend.model.Bilhete;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BilheteMapper {

    Bilhete toEntity(CriarBilheteRequest dto);

    BilheteCriadoResponse toDTO(Bilhete bilhete);
}
