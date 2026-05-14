package fiap.com.br.games.controllers;

import fiap.com.br.games.model.Game;
import fiap.com.br.games.service.GameService;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<EntityModel<Game>> findAll() {
        return gameService.findAll()
                .stream()
                .map(Game::toEntityModel)
                .toList();
    }

    @GetMapping("/{id}")
    public EntityModel<Game> findById(@PathVariable Long id) {
        return gameService.findById(id).toEntityModel();
    }

    @GetMapping("/genres/{genreId}")
    public List<EntityModel<Game>> findByGenre(@PathVariable Long genreId) {
        return gameService.findByGenreId(genreId)
                .stream()
                .map(Game::toEntityModel)
                .toList();
    }

    @GetMapping("/platforms/{platformId}")
    public List<EntityModel<Game>> findByPlatform(@PathVariable Long platformId) {
        return gameService.findByPlatformId(platformId)
                .stream()
                .map(Game::toEntityModel)
                .toList();
    }
}