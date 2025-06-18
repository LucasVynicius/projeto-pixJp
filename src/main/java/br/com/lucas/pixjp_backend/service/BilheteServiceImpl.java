package br.com.lucas.pixjp_backend.service;

import br.com.lucas.pixjp_backend.dtos.BilheteCriadoResponse;
import br.com.lucas.pixjp_backend.dtos.CriarBilheteRequest;
import br.com.lucas.pixjp_backend.model.Bilhete;
import br.com.lucas.pixjp_backend.repositories.BilheteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BilheteServiceImpl implements BilheteService {

    private final BilheteRepository bilheteRepository;


    @Override
    public BilheteCriadoResponse criarBilhete(CriarBilheteRequest criarBilheteRequest) {
        Bilhete bilhete = new Bilhete();

        bilhete.setNumero(criarBilheteRequest.numero());
    }

    @Override
    public Bilhete buscarBilhetePeloId(Long id) {
        return null;
    }

    @Override
    public List<Bilhete> buscarBilhetes() {
        return List.of();
    }

    @Override
    public Bilhete atualizarBilhete(Long id, CriarBilheteRequest criarBilheteRequest) {
        return null;
    }

    @Override
    public void deletarBilhetePeloId(Long id) {

    }
}
