package br.com.lucas.pixjp_backend.controller;

import br.com.lucas.pixjp_backend.model.Usuario;
import br.com.lucas.pixjp_backend.service.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;

    @GetMapping()
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @PutMapping
    public void criarUsuario(Usuario usuario){
        usuarioService.salvarUsuario(usuario);
    }
}
