package br.com.lucas.pixjp_backend.service;

import br.com.lucas.pixjp_backend.model.Usuario;
import br.com.lucas.pixjp_backend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public void salvarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
