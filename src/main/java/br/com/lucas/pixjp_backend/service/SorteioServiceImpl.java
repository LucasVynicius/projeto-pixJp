package br.com.lucas.pixjp_backend.service;

import br.com.lucas.pixjp_backend.dtos.CriaSorteioRequest;
import br.com.lucas.pixjp_backend.model.Sorteio;
import br.com.lucas.pixjp_backend.repositories.SorteioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SorteioServiceImpl implements SorteioService {

    private final SorteioRepository sorteioRepository;

    @Override
    public Sorteio criarSorteio(CriaSorteioRequest criaSorteioRequest) {
        Sorteio sorteio = new Sorteio();

        sorteio.setDataInicio(criaSorteioRequest.dataInicio());
        sorteio.setDataFinal(criaSorteioRequest.dataFinal());
        sorteio.setDataSorteio(criaSorteioRequest.dataSorteio());
        sorteio.setNumero(null);

        return sorteioRepository.save(sorteio);
    }

    @Override
    public Sorteio buscarPorId(Long id) {
        return sorteioRepository.findById(id).orElseThrow(() -> new RuntimeException("Sorteio não encontrado"));
    }
}
