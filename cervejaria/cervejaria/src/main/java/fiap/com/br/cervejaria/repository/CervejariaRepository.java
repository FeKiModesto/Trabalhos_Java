package fiap.com.br.cervejaria.repository;

import fiap.com.br.cervejaria.entity.Cervejaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CervejariaRepository extends JpaRepository<Cervejaria, Long> {
}