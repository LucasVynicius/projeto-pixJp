package br.com.lucas.pixjp_backend.service;

import br.com.lucas.pixjp_backend.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {

    List<Usuario> listarUsuarios();

    Usuario salvarUsuario(Usuario usuario);
}
