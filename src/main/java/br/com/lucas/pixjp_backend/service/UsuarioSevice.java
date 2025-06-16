package br.com.lucas.pixjp_backend.service;

import br.com.lucas.pixjp_backend.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioSevice {

    List<Usuario> listarUsuarios();

    void salvarUsuario(Usuario usuario);
}
