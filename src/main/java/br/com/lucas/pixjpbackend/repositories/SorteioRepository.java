package br.com.lucas.pixjpbackend.repositories;

import br.com.lucas.pixjpbackend.model.Sorteio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SorteioRepository extends JpaRepository<Sorteio, Long> {


}
