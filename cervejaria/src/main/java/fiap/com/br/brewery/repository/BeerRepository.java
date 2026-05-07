package fiap.com.br.brewery.repository;

import fiap.com.br.brewery.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeerRepository extends JpaRepository<Beer, Long> {
    List<Beer> findByBreweryId(Long breweryId);
}