package fiap.com.br.games.controllers;

import fiap.com.br.games.model.Game;
import fiap.com.br.games.service.GameService;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
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

    @GetMapping("/genre/{genre}")
    public List<EntityModel<Game>> findByGenre(@PathVariable String genre) {
        return gameService.findByGenre(genre)
                .stream()
                .map(Game::toEntityModel)
                .toList();
    }

    @GetMapping("/platform/{platform}")
    public List<EntityModel<Game>> findByPlatform(@PathVariable String platform) {
        return gameService.findByPlatform(platform)
                .stream()
                .map(Game::toEntityModel)
                .toList();
    }

    @GetMapping("/developer/{developer}")
    public List<EntityModel<Game>> findByDeveloper(@PathVariable String developer) {
        return gameService.findByDeveloper(developer)
                .stream()
                .map(Game::toEntityModel)
                .toList();
    }
}
