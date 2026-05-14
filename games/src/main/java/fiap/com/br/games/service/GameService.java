package fiap.com.br.games.service;

import fiap.com.br.games.model.Game;
import fiap.com.br.games.repository.GameRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Page<Game> findAll(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }

    public Game findById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found with id: " + id));
    }

    public Page<Game> findByGenreId(Long genreId, Pageable pageable) {
        return gameRepository.findByGenreId(genreId, pageable);
    }

    public Page<Game> findByPlatformId(Long platformId, Pageable pageable) {
        return gameRepository.findByPlatformId(platformId, pageable);
    }
}