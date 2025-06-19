package br.com.lucas.pixjp_backend.service;

import br.com.lucas.pixjp_backend.dtos.*;
import br.com.lucas.pixjp_backend.model.Bilhete;
import br.com.lucas.pixjp_backend.model.Sorteio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface BilheteService {

    BilheteCriadoResponse comprarBilhete(CriarBilheteRequest criarBilheteRequest);

    SorteioProcessadoResponse processarSorteio(Sorteio sorteio);

}
