package br.com.lucas.pixjpbackend.controller;

import br.com.lucas.pixjpbackend.dtos.CriarUsuarioRequest;
import br.com.lucas.pixjpbackend.dtos.UsuarioCriadoResponse;
import br.com.lucas.pixjpbackend.model.Usuario;
import br.com.lucas.pixjpbackend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioCriadoResponse criarUsuario(@RequestBody CriarUsuarioRequest criarUsuarioRequest){
        return usuarioService.criarUsuario(criarUsuarioRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscarPeloId(@PathVariable Long id){
        return usuarioService.buscarUsuarioPeloId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> buscarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody CriarUsuarioRequest criarUsuarioRequest){
        return usuarioService.atualizarUsuario(id, criarUsuarioRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
    }
}
