package br.com.lucas.pixjpbackend.mapper;

import br.com.lucas.pixjpbackend.dtos.CriarUsuarioRequest;
import br.com.lucas.pixjpbackend.dtos.UsuarioCriadoResponse;
import br.com.lucas.pixjpbackend.model.Usuario;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    Usuario toEntity(CriarUsuarioRequest dto);

    UsuarioCriadoResponse toDTO(Usuario usuario);
}
