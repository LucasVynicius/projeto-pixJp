package br.com.lucas.pixjpbackend.service;

import br.com.lucas.pixjpbackend.dtos.CriarUsuarioRequest;
import br.com.lucas.pixjpbackend.dtos.UsuarioCriadoResponse;
import br.com.lucas.pixjpbackend.mapper.EnderecoMapper;
import br.com.lucas.pixjpbackend.mapper.UsuarioMapper;
import br.com.lucas.pixjpbackend.model.Endereco;
import br.com.lucas.pixjpbackend.model.Usuario;
import br.com.lucas.pixjpbackend.repositories.BilheteRepository;
import br.com.lucas.pixjpbackend.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
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

    private final EnderecoMapper enderecoMapper;

    private final BilheteRepository bilheteRepository;

    @Override
    public UsuarioCriadoResponse criarUsuario(CriarUsuarioRequest dto) {

       Usuario usuario =  usuarioMapper.toEntity(dto);

        return usuarioMapper.toDTO(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioCriadoResponse buscarUsuarioPeloId(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Usuario não encontrado"));

        return usuarioMapper.toDTO(usuario);
    }

    @Override
    public List<UsuarioCriadoResponse> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDTO)
                .toList();
    }

    @Transactional
    @Override
    public UsuarioCriadoResponse atualizarUsuario(Long id, CriarUsuarioRequest dto) {
        Usuario usuario= usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Usuario não encontrado"));

        usuario.setNome(dto.nome());
        usuario.setCpf(dto.cpf());
        usuario.setDataNascimento(dto.dataNascimento());
        usuario.setTelefone(dto.telefone());
        usuario.setEmail(dto.email());
        usuario.setEndereco(enderecoMapper.toEntity(dto.endereco()));

        usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuario);
    }


    @Override
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }


}
