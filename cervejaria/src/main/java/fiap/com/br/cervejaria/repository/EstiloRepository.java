package fiap.com.br.cervejaria.repository;

import fiap.com.br.cervejaria.entity.Estilo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstiloRepository extends JpaRepository<Estilo, Long> {
}