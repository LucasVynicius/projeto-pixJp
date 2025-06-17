package br.com.lucas.pixjp_backend.service;

import br.com.lucas.pixjp_backend.dtos.CriarUsuarioRequest;
import br.com.lucas.pixjp_backend.dtos.UsuarioCriadoResponse;
import br.com.lucas.pixjp_backend.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {

    List<Usuario> listarUsuarios();

    UsuarioCriadoResponse criarUsuario(CriarUsuarioRequest criarUsuarioRequest);
}
