package br.com.lucas.pixjpbackend.service;

import br.com.lucas.pixjpbackend.dtos.BilheteCriadoResponse;
import br.com.lucas.pixjpbackend.dtos.CriarBilheteRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BilheteService {

    BilheteCriadoResponse comprarBilhete(CriarBilheteRequest criarBilheteRequest);

    List<BilheteCriadoResponse> listarBilhetePremiadoDoUsuario(Long idUsuario);

}
