package br.com.lucas.pixjpbackend.service;

import br.com.lucas.pixjpbackend.dtos.CriarUsuarioRequest;
import br.com.lucas.pixjpbackend.dtos.UsuarioCriadoResponse;
import br.com.lucas.pixjpbackend.model.Endereco;
import br.com.lucas.pixjpbackend.model.Usuario;
import br.com.lucas.pixjpbackend.repositories.BilheteRepository;
import br.com.lucas.pixjpbackend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final BilheteRepository bilheteRepository;

    @Override
    public UsuarioCriadoResponse criarUsuario(CriarUsuarioRequest criarUsuarioRequest) {

        Endereco endereco = new Endereco(
                null,
                criarUsuarioRequest.endereco().logradouro(),
                criarUsuarioRequest.endereco().numero(),
                criarUsuarioRequest.endereco().complemento(),
                criarUsuarioRequest.endereco().bairro(),
                criarUsuarioRequest.endereco().cidade(),
                criarUsuarioRequest.endereco().estado(),
                criarUsuarioRequest.endereco().pais(),
                criarUsuarioRequest.endereco().cep()
        );

        Usuario usuario = new Usuario();

        usuario.setNome(criarUsuarioRequest.nome());
        usuario.setCpf(criarUsuarioRequest.cpf());
        usuario.setDataNascimento(criarUsuarioRequest.dataNascimento());
        usuario.setTelefone(criarUsuarioRequest.telefone());
        usuario.setEmail(criarUsuarioRequest.email());
        usuario.setEndereco(endereco);

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
    public Usuario atualizarUsuario(Long id, CriarUsuarioRequest criarUsuarioRequest) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Usuario não encontrado"));

        Endereco endereco = usuarioExistente.getEndereco();

        if(endereco == null){
            endereco =new Endereco();
        }

        endereco.setLogradouro(criarUsuarioRequest.endereco().logradouro());
        endereco.setNumero(criarUsuarioRequest.endereco().numero());
        endereco.setComplemento(criarUsuarioRequest.endereco().complemento());
        endereco.setBairro(criarUsuarioRequest.endereco().bairro());
        endereco.setCidade(criarUsuarioRequest.endereco().cidade());
        endereco.setEstado(criarUsuarioRequest.endereco().estado());
        endereco.setPais(criarUsuarioRequest.endereco().pais());
        endereco.setCep(criarUsuarioRequest.endereco().cep());

        usuarioExistente.setNome(criarUsuarioRequest.nome());
        usuarioExistente.setCpf(criarUsuarioRequest.cpf());
        usuarioExistente.setDataNascimento(criarUsuarioRequest.dataNascimento());
        usuarioExistente.setTelefone(criarUsuarioRequest.telefone());
        usuarioExistente.setEmail(criarUsuarioRequest.email());
        usuarioExistente.setEndereco(endereco);

        return usuarioRepository.save(usuarioExistente);
    }


    @Override
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }


}
