package br.com.lucas.pixjp_backend.service;

import br.com.lucas.pixjp_backend.dtos.BilheteCriadoResponse;
import br.com.lucas.pixjp_backend.dtos.CriarBilheteRequest;
import br.com.lucas.pixjp_backend.model.Bilhete;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BilheteService {

    BilheteCriadoResponse comprarBilhete(CriarBilheteRequest criarBilheteRequest);

    List<BilheteCriadoResponse> listarBilhetePremiadoDoUsuario(Long idUsuario);

}
