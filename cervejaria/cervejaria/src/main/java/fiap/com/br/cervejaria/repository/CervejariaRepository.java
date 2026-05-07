package fiap.com.br.brewery.repository;

import fiap.com.br.brewery.entity.Cervejaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CervejariaRepository extends JpaRepository<Cervejaria, Long> {
}