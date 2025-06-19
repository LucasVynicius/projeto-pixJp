package br.com.lucas.pixjp_backend.service;

import br.com.lucas.pixjp_backend.dtos.CriaSorteioRequest;
import br.com.lucas.pixjp_backend.model.Sorteio;
import org.springframework.stereotype.Service;

@Service
public interface SorteioService {

    Sorteio criarSorteio(CriaSorteioRequest criaSorteioRequest);

    Sorteio buscarPorId(Long id);
}
