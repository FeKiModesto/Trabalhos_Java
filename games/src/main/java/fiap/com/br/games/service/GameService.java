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

    public List<Game> findByGenre(String genre) {
        return gameRepository.findByGenre(genre);
    }

    public List<Game> findByPlatform(String platform) {
        return gameRepository.findByPlatform(platform);
    }

    public List<Game> findByDeveloper(String developer) {
        return gameRepository.findByDeveloper(developer);
    }
}
