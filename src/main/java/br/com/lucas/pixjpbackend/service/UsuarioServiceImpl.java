package br.com.lucas.pixjpbackend.service;

import br.com.lucas.pixjpbackend.dtos.CriarUsuarioRequest;
import br.com.lucas.pixjpbackend.dtos.UsuarioCriadoResponse;
import br.com.lucas.pixjpbackend.mapper.UsuarioMapper;
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

    private final UsuarioMapper usuarioMapper;

    private final BilheteRepository bilheteRepository;

    @Override
    public UsuarioCriadoResponse criarUsuario(CriarUsuarioRequest dto) {

       Usuario usuario =  usuarioMapper.toEntity(dto);

        return usuarioMapper.toDTO(usuarioRepository.save(usuario));
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
