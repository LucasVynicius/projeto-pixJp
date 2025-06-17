package br.com.lucas.pixjp_backend.service;

import br.com.lucas.pixjp_backend.dtos.CriarUsuarioRequest;
import br.com.lucas.pixjp_backend.dtos.UsuarioCriadoResponse;
import br.com.lucas.pixjp_backend.model.Usuario;
import br.com.lucas.pixjp_backend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listarUsuarios() {
        return List.of();
    }

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


}
