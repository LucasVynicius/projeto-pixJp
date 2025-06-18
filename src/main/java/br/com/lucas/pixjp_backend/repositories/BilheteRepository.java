package br.com.lucas.pixjp_backend.repositories;

import br.com.lucas.pixjp_backend.model.Bilhete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilheteRepository extends JpaRepository<Bilhete, Long> {
}
