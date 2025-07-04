package br.com.lucas.pixjpbackend.controller;

import br.com.lucas.pixjpbackend.dtos.BilheteCriadoResponse;
import br.com.lucas.pixjpbackend.dtos.CriarBilheteRequest;
import br.com.lucas.pixjpbackend.service.BilheteService;
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
