package br.com.lucas.pixjpbackend.repositories;

import br.com.lucas.pixjpbackend.dtos.BilheteCriadoResponse;
import br.com.lucas.pixjpbackend.model.Bilhete;
import br.com.lucas.pixjpbackend.model.Sorteio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BilheteRepository extends JpaRepository<Bilhete, Long> {

    List<Bilhete> findBySorteio(Sorteio sorteio);

    List<BilheteCriadoResponse> findByUsuarioIdAndPremiado(Long id);
}
