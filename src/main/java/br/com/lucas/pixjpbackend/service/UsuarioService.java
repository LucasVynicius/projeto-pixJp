package br.com.lucas.pixjpbackend.service;

import br.com.lucas.pixjpbackend.dtos.CriarUsuarioRequest;
import br.com.lucas.pixjpbackend.dtos.UsuarioCriadoResponse;
import br.com.lucas.pixjpbackend.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {

    UsuarioCriadoResponse criarUsuario(CriarUsuarioRequest criarUsuarioRequest);

    Usuario buscarUsuarioPeloId(Long id);

    List<Usuario> listarUsuarios();


    Usuario atualizarUsuario(Long id, CriarUsuarioRequest criarUsuarioRequest);

    void deletarUsuario(Long id);

}
