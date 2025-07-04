package br.com.lucas.pixjp_backend.repositories;

import br.com.lucas.pixjp_backend.dtos.BilheteCriadoResponse;
import br.com.lucas.pixjp_backend.model.Bilhete;
import br.com.lucas.pixjp_backend.model.Sorteio;
import br.com.lucas.pixjp_backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BilheteRepository extends JpaRepository<Bilhete, Long> {

    List<Bilhete> findBySorteio(Sorteio sorteio);

    List<BilheteCriadoResponse> findByUsuarioIdAndPremiado(Long id);
}
