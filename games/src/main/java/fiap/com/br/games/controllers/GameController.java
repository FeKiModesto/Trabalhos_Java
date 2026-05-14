package fiap.com.br.games.controllers;

import fiap.com.br.games.model.Game;
import fiap.com.br.games.model.GameResponse;
import fiap.com.br.games.service.GameService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/games")
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    private GameResponse toResponse(Game game) {
        Map<String, Object> links = new HashMap<>();
        links.put("self", Map.of("href", "http://localhost:8080/games/" + game.getId(), "title", "Game details"));
        links.put("all-games", Map.of("href", "http://localhost:8080/games?page=0&size=6", "title", "All games"));
        if (game.getGenre() != null) {
            links.put("same-genre", Map.of(
                    "href", "http://localhost:8080/games/genres/" + game.getGenre().getId() + "?page=0&size=6",
                    "title", "Games in " + game.getGenre().getName() + " genre"
            ));
        }
        if (game.getPlatform() != null) {
            links.put("same-platform", Map.of(
                    "href", "http://localhost:8080/games/platforms/" + game.getPlatform().getId() + "?page=0&size=6",
                    "title", "Games on " + game.getPlatform().getName()
            ));
        }
        return new GameResponse(game, links);
    }

    @GetMapping
    public Map<String, Object> findAll(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "6") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Game> gamePage = gameService.findAll(pageable);

        List<GameResponse> games = gamePage.getContent().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

        Map<String, Object> links = new HashMap<>();
        links.put("self", Map.of("href", "http://localhost:8080/games?page=" + page + "&size=" + size));
        links.put("first", Map.of("href", "http://localhost:8080/games?page=0&size=" + size));
        if (gamePage.getTotalPages() > 0)
            links.put("last", Map.of("href", "http://localhost:8080/games?page=" + (gamePage.getTotalPages() - 1) + "&size=" + size));
        if (gamePage.hasPrevious())
            links.put("prev", Map.of("href", "http://localhost:8080/games?page=" + (page - 1) + "&size=" + size));
        if (gamePage.hasNext())
            links.put("next", Map.of("href", "http://localhost:8080/games?page=" + (page + 1) + "&size=" + size));

        Map<String, Object> response = new HashMap<>();
        response.put("_embedded", Map.of("gameList", games));
        response.put("_links", links);
        response.put("page", Map.of("size", gamePage.getSize(), "totalElements", gamePage.getTotalElements(),
                "totalPages", gamePage.getTotalPages(), "number", gamePage.getNumber()));
        return response;
    }

    @GetMapping("/{id}")
    public GameResponse findById(@PathVariable Long id) {
        return toResponse(gameService.findById(id));
    }

    @GetMapping("/genres/{genreId}")
    public Map<String, Object> findByGenre(@PathVariable Long genreId,
                                           @RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "6") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Game> gamePage = gameService.findByGenreId(genreId, pageable);

        List<GameResponse> games = gamePage.getContent().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

        Map<String, Object> links = new HashMap<>();
        links.put("self", Map.of("href", "http://localhost:8080/games/genres/" + genreId + "?page=" + page + "&size=" + size));

        Map<String, Object> response = new HashMap<>();
        response.put("_embedded", Map.of("gameList", games));
        response.put("_links", links);
        response.put("page", Map.of("size", gamePage.getSize(), "totalElements", gamePage.getTotalElements(),
                "totalPages", gamePage.getTotalPages(), "number", gamePage.getNumber()));
        return response;
    }

    @GetMapping("/platforms/{platformId}")
    public Map<String, Object> findByPlatform(@PathVariable Long platformId,
                                              @RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "6") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Game> gamePage = gameService.findByPlatformId(platformId, pageable);

        List<GameResponse> games = gamePage.getContent().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

        Map<String, Object> links = new HashMap<>();
        links.put("self", Map.of("href", "http://localhost:8080/games/platforms/" + platformId + "?page=" + page + "&size=" + size));

        Map<String, Object> response = new HashMap<>();
        response.put("_embedded", Map.of("gameList", games));
        response.put("_links", links);
        response.put("page", Map.of("size", gamePage.getSize(), "totalElements", gamePage.getTotalElements(),
                "totalPages", gamePage.getTotalPages(), "number", gamePage.getNumber()));
        return response;
    }
}