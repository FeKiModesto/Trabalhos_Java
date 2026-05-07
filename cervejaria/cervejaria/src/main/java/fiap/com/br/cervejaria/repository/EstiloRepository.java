package fiap.com.br.brewery.repository;

import fiap.com.br.brewery.entity.Estilo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstiloRepository extends JpaRepository<Estilo, Long> {
}