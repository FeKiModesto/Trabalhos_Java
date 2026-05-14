package fiap.com.br.games.service;

import fiap.com.br.games.model.Game;
import fiap.com.br.games.repository.GameRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Game findById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found with id: " + id));
    }

    public List<Game> findByGenreId(Long genreId) {
        return gameRepository.findByGenreId(genreId);
    }

    public List<Game> findByPlatformId(Long platformId) {
        return gameRepository.findByPlatformId(platformId);
    }
}