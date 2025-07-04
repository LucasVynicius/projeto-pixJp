package br.com.lucas.pixjpbackend.mapper;

import br.com.lucas.pixjpbackend.dtos.CriaSorteioRequest;
import br.com.lucas.pixjpbackend.dtos.SorteioCriadoResponse;
import br.com.lucas.pixjpbackend.model.Sorteio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SorteioMapper {

    @Mapping(target = "id", ignore = true)
    Sorteio toEntity(CriaSorteioRequest dto);

    SorteioCriadoResponse toDTO(Sorteio sorteio);
}
