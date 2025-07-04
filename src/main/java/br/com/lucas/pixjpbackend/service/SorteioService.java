package br.com.lucas.pixjpbackend.service;

import br.com.lucas.pixjpbackend.dtos.CriaSorteioRequest;
import br.com.lucas.pixjpbackend.model.Sorteio;
import org.springframework.stereotype.Service;

@Service
public interface SorteioService {

    Sorteio criarSorteio(CriaSorteioRequest criaSorteioRequest);

    Sorteio buscarPorId(Long id);
}
