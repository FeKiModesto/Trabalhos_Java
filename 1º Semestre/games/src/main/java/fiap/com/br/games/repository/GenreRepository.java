package fiap.com.br.games.repository;

import fiap.com.br.games.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}