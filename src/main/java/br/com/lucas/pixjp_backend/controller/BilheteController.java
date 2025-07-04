package br.com.lucas.pixjp_backend.controller;

import br.com.lucas.pixjp_backend.dtos.BilheteCriadoResponse;
import br.com.lucas.pixjp_backend.dtos.CriarBilheteRequest;
import br.com.lucas.pixjp_backend.model.Bilhete;
import br.com.lucas.pixjp_backend.service.BilheteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bilhete")
@RequiredArgsConstructor
public class BilheteController {

    private final BilheteService bilheteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BilheteCriadoResponse salvarBilhete(@RequestBody CriarBilheteRequest criarBilheteRequest){
        return bilheteService.comprarBilhete(criarBilheteRequest);
    }

    @GetMapping("/bilhete-premiado/{idUsuario}")
    @ResponseStatus(HttpStatus.OK)
    public List<BilheteCriadoResponse> listarBilhetesPremiadosComUsuario(@PathVariable Long idUsuario){
        return bilheteService.listarBilhetePremiadoDoUsuario(idUsuario);
    }

}
