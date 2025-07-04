package br.com.lucas.pixjpbackend.controller;

import br.com.lucas.pixjpbackend.dtos.CriaSorteioRequest;
import br.com.lucas.pixjpbackend.model.Sorteio;
import br.com.lucas.pixjpbackend.service.BilheteService;
import br.com.lucas.pixjpbackend.service.SorteioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sorteio")
@RequiredArgsConstructor
public class SorteioController {

    private final SorteioService sorteioService;
    private final BilheteService bilheteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sorteio criarSorteio(@RequestBody CriaSorteioRequest criaSorteioRequest){
        return sorteioService.criarSorteio(criaSorteioRequest);
    }

    @PostMapping("/{id}/processar")
    @ResponseStatus(HttpStatus.OK)
    public String processarSorteio(@PathVariable Long id){
        Sorteio sorteio = sorteioService.buscarPorId(id);
        bilheteService.processarSorteio(sorteio);
        return "Sorteio processado com sucesso";
    }

}
