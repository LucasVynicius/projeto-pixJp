package br.com.lucas.pixjp_backend.repositories;

import br.com.lucas.pixjp_backend.model.Sorteio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface SorteioRepository extends JpaRepository<Sorteio, Long> {


}
