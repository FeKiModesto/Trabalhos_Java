package fiap.com.br.games.controllers;

import fiap.com.br.games.model.Game;
import fiap.com.br.games.service.GameService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public Map<String, Object> findAll() {
        List<EntityModel<Game>> games = gameService.findAll()
                .stream()
                .map(Game::toEntityModel)
                .toList();

        Map<String, Object> response = new HashMap<>();
        response.put("_embedded", Map.of("gameList", games));
        response.put("_links", Map.of(
                "self", Map.of("href", linkTo(methodOn(GameController.class).findAll()).withSelfRel().getHref()),
                "games", Map.of("href", linkTo(methodOn(GameController.class).findAll()).withRel("games").getHref())
        ));

        return response;
    }

    @GetMapping("/{id}")
    public EntityModel<Game> findById(@PathVariable Long id) {
        return gameService.findById(id).toEntityModel();
    }

    @GetMapping("/genres/{genreId}")
    public Map<String, Object> findByGenre(@PathVariable Long genreId) {
        List<EntityModel<Game>> games = gameService.findByGenreId(genreId)
                .stream()
                .map(Game::toEntityModel)
                .toList();

        Map<String, Object> response = new HashMap<>();
        response.put("_embedded", Map.of("gameList", games));
        response.put("_links", Map.of(
                "self", Map.of("href", linkTo(methodOn(GameController.class).findByGenre(genreId)).withSelfRel().getHref())
        ));

        return response;
    }

    @GetMapping("/platforms/{platformId}")
    public Map<String, Object> findByPlatform(@PathVariable Long platformId) {
        List<EntityModel<Game>> games = gameService.findByPlatformId(platformId)
                .stream()
                .map(Game::toEntityModel)
                .toList();

        Map<String, Object> response = new HashMap<>();
        response.put("_embedded", Map.of("gameList", games));
        response.put("_links", Map.of(
                "self", Map.of("href", linkTo(methodOn(GameController.class).findByPlatform(platformId)).withSelfRel().getHref())
        ));

        return response;
    }
}