package br.com.lucas.pixjpbackend.service;

import br.com.lucas.pixjpbackend.dtos.CriarUsuarioRequest;
import br.com.lucas.pixjpbackend.dtos.UsuarioCriadoResponse;
import br.com.lucas.pixjpbackend.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {

    UsuarioCriadoResponse criarUsuario(CriarUsuarioRequest criarUsuarioRequest);

    UsuarioCriadoResponse buscarUsuarioPeloId(Long id);

    List<UsuarioCriadoResponse> listarUsuarios();


    UsuarioCriadoResponse atualizarUsuario(Long id, CriarUsuarioRequest criarUsuarioRequest);

    void deletarUsuario(Long id);

}
