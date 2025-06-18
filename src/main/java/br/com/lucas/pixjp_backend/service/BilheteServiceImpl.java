package br.com.lucas.pixjp_backend.service;

import br.com.lucas.pixjp_backend.repositories.BilheteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BilheteServiceImpl implements BilheteService {

    private final BilheteRepository bilheteRepository;


}
