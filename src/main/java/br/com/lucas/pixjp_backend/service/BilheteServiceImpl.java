package br.com.lucas.pixjp_backend.service;

import br.com.lucas.pixjp_backend.dtos.*;
import br.com.lucas.pixjp_backend.model.Bilhete;
import br.com.lucas.pixjp_backend.model.Sorteio;
import br.com.lucas.pixjp_backend.model.Usuario;
import br.com.lucas.pixjp_backend.repositories.BilheteRepository;
import br.com.lucas.pixjp_backend.repositories.SorteioRepository;
import br.com.lucas.pixjp_backend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BilheteServiceImpl implements BilheteService {

    private final BilheteRepository bilheteRepository;

    private final UsuarioRepository usuarioRepository;

    private final SorteioRepository sorteioRepository;


    @Override
    public BilheteCriadoResponse comprarBilhete(CriarBilheteRequest criarBilheteRequest) {

        Long usuarioId = criarBilheteRequest.idUsuario();
        Long sorteioId = criarBilheteRequest.idSorteio();

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Sorteio sorteio = sorteioRepository.findById(sorteioId).orElseThrow(() -> new RuntimeException("Sorteio não encontrado"));

        LocalDate dataHoje = LocalDate.now();

        if(dataHoje.isBefore(sorteio.getDataInicio()) || dataHoje.isAfter(sorteio.getDataFinal())){
            throw new RuntimeException("Compra não permitida fora do período do sorteio.");
        }

        String numeroGerado = UUID.randomUUID().toString().substring(0, 8);

        Bilhete bilhete = new Bilhete();
        bilhete.setNumero(numeroGerado);
        bilhete.setPremiado(false);
        bilhete.setDataCompra(dataHoje);
        bilhete.setUsuario(usuario);
        bilhete.setSorteio(sorteio);

        bilheteRepository.save(bilhete);

        return new BilheteCriadoResponse("Bilhete criado com sucesso.", usuario.getId());
    }

    @Override
    public List<BilheteCriadoResponse> listarBilhetePremiadoDoUsuario(Long idUsuario) {
        return bilheteRepository.findByUsuarioIdAndPremiado(idUsuario);
    }


}
