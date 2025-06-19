package br.com.lucas.pixjp_backend.controller;

import br.com.lucas.pixjp_backend.dtos.BilheteUsuarioResponse;
import br.com.lucas.pixjp_backend.dtos.CriarUsuarioRequest;
import br.com.lucas.pixjp_backend.dtos.UsuarioCriadoResponse;
import br.com.lucas.pixjp_backend.model.Usuario;
import br.com.lucas.pixjp_backend.service.BilheteService;
import br.com.lucas.pixjp_backend.service.UsuarioService;
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

    @GetMapping("/{id}/bilhetes")
    public List<BilheteUsuarioResponse> listarBilhetes(@PathVariable Long id){
        return usuarioService.listarBilhetesDoUsuario(id);
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
