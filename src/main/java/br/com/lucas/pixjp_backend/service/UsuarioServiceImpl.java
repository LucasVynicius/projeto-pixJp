package br.com.lucas.pixjp_backend.service;

import br.com.lucas.pixjp_backend.dtos.BilheteUsuarioResponse;
import br.com.lucas.pixjp_backend.dtos.CriarUsuarioRequest;
import br.com.lucas.pixjp_backend.dtos.UsuarioCriadoResponse;
import br.com.lucas.pixjp_backend.model.Bilhete;
import br.com.lucas.pixjp_backend.model.Usuario;
import br.com.lucas.pixjp_backend.repositories.BilheteRepository;
import br.com.lucas.pixjp_backend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final BilheteRepository bilheteRepository;

    @Override
    public UsuarioCriadoResponse criarUsuario(CriarUsuarioRequest criarUsuarioRequest) {
        Usuario usuario = new Usuario();

        usuario.setNome(criarUsuarioRequest.nome());
        usuario.setCpf(criarUsuarioRequest.cpf());
        usuario.setDataNascimento(criarUsuarioRequest.dataNascimento());
        usuario.setTelefone(criarUsuarioRequest.telefone());
        usuario.setEmail(criarUsuarioRequest.email());
        usuario.setEndereco(criarUsuarioRequest.endereco());

        Usuario usuarioCriado = usuarioRepository.save(usuario);

        return new UsuarioCriadoResponse("Usuario criado com sucesso!", usuarioCriado.getId());
    }

    @Override
    public Usuario buscarUsuarioPeloId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Usuario não encontrado"));
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<BilheteUsuarioResponse> listarBilhetesDoUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        List<Bilhete> bilhetes = bilheteRepository.findByUsuario(usuario);

        return bilhetes.stream()
                .map(b -> new BilheteUsuarioResponse(
                        b.getId(),
                        b.getNumero(),
                        b.getDataCompra(),
                        b.getPremiado(),
                        b.getSorteio().getId()
                ))
                .toList();
    }

    @Override
    public Usuario atualizarUsuario(Long id, CriarUsuarioRequest criarUsuarioRequest) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Usuario não encontrado"));

        usuarioExistente.setNome(criarUsuarioRequest.nome());
        usuarioExistente.setCpf(criarUsuarioRequest.cpf());
        usuarioExistente.setDataNascimento(criarUsuarioRequest.dataNascimento());
        usuarioExistente.setTelefone(criarUsuarioRequest.telefone());
        usuarioExistente.setEmail(criarUsuarioRequest.email());
        usuarioExistente.setEndereco(criarUsuarioRequest.endereco());

        return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }


}
