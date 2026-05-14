package fiap.com.br.games.controllers;

import fiap.com.br.games.model.Game;
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
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public Map<String, Object> findAll(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "6") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Game> gamePage = gameService.findAll(pageable);

        // 🔧 FORÇA a criação dos links same-genre e same-platform para cada jogo
        List<EntityModel<Game>> games = gamePage.getContent()
                .stream()
                .map(game -> {
                    EntityModel<Game> model = game.toEntityModel(); // self + all-games
                    if (game.getGenre() != null) {
                        var linkByGenre = linkTo(methodOn(GameController.class)
                                .findByGenre(game.getGenre().getId(), 0, size))
                                .withRel("same-genre")
                                .withTitle("Games in " + game.getGenre().getName() + " genre");
                        model.add(linkByGenre);
                    }
                    if (game.getPlatform() != null) {
                        var linkByPlatform = linkTo(methodOn(GameController.class)
                                .findByPlatform(game.getPlatform().getId(), 0, size))
                                .withRel("same-platform")
                                .withTitle("Games on " + game.getPlatform().getName());
                        model.add(linkByPlatform);
                    }
                    return model;
                })
                .collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("_embedded", Map.of("gameList", games));

        Map<String, Object> pageInfo = new HashMap<>();
        pageInfo.put("size", gamePage.getSize());
        pageInfo.put("totalElements", gamePage.getTotalElements());
        pageInfo.put("totalPages", gamePage.getTotalPages());
        pageInfo.put("number", gamePage.getNumber());
        response.put("page", pageInfo);

        // Links de navegação da página
        Map<String, Object> links = new HashMap<>();
        links.put("self", Map.of("href", linkTo(methodOn(GameController.class).findAll(page, size)).withSelfRel().getHref()));
        links.put("first", Map.of("href", linkTo(methodOn(GameController.class).findAll(0, size)).withSelfRel().getHref()));
        if (gamePage.getTotalPages() > 0) {
            links.put("last", Map.of("href", linkTo(methodOn(GameController.class).findAll(gamePage.getTotalPages() - 1, size)).withSelfRel().getHref()));
        }
        if (gamePage.hasPrevious()) {
            links.put("prev", Map.of("href", linkTo(methodOn(GameController.class).findAll(page - 1, size)).withSelfRel().getHref()));
        }
        if (gamePage.hasNext()) {
            links.put("next", Map.of("href", linkTo(methodOn(GameController.class).findAll(page + 1, size)).withSelfRel().getHref()));
        }
        response.put("_links", links);

        return response;
    }

    @GetMapping("/{id}")
    public EntityModel<Game> findById(@PathVariable Long id) {
        return gameService.findById(id).toEntityModel();
    }

    @GetMapping("/genres/{genreId}")
    public Map<String, Object> findByGenre(@PathVariable Long genreId,
                                           @RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "6") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Game> gamePage = gameService.findByGenreId(genreId, pageable);

        List<EntityModel<Game>> games = gamePage.getContent()
                .stream()
                .map(Game::toEntityModel)
                .collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("_embedded", Map.of("gameList", games));

        Map<String, Object> pageInfo = new HashMap<>();
        pageInfo.put("size", gamePage.getSize());
        pageInfo.put("totalElements", gamePage.getTotalElements());
        pageInfo.put("totalPages", gamePage.getTotalPages());
        pageInfo.put("number", gamePage.getNumber());
        response.put("page", pageInfo);

        Map<String, Object> links = new HashMap<>();
        links.put("self", Map.of("href", linkTo(methodOn(GameController.class).findByGenre(genreId, page, size)).withSelfRel().getHref()));
        links.put("first", Map.of("href", linkTo(methodOn(GameController.class).findByGenre(genreId, 0, size)).withSelfRel().getHref()));
        if (gamePage.getTotalPages() > 0) {
            links.put("last", Map.of("href", linkTo(methodOn(GameController.class).findByGenre(genreId, gamePage.getTotalPages() - 1, size)).withSelfRel().getHref()));
        }
        if (gamePage.hasPrevious()) {
            links.put("prev", Map.of("href", linkTo(methodOn(GameController.class).findByGenre(genreId, page - 1, size)).withSelfRel().getHref()));
        }
        if (gamePage.hasNext()) {
            links.put("next", Map.of("href", linkTo(methodOn(GameController.class).findByGenre(genreId, page + 1, size)).withSelfRel().getHref()));
        }
        response.put("_links", links);

        return response;
    }

    @GetMapping("/platforms/{platformId}")
    public Map<String, Object> findByPlatform(@PathVariable Long platformId,
                                              @RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "6") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Game> gamePage = gameService.findByPlatformId(platformId, pageable);

        List<EntityModel<Game>> games = gamePage.getContent()
                .stream()
                .map(Game::toEntityModel)
                .collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("_embedded", Map.of("gameList", games));

        Map<String, Object> pageInfo = new HashMap<>();
        pageInfo.put("size", gamePage.getSize());
        pageInfo.put("totalElements", gamePage.getTotalElements());
        pageInfo.put("totalPages", gamePage.getTotalPages());
        pageInfo.put("number", gamePage.getNumber());
        response.put("page", pageInfo);

        Map<String, Object> links = new HashMap<>();
        links.put("self", Map.of("href", linkTo(methodOn(GameController.class).findByPlatform(platformId, page, size)).withSelfRel().getHref()));
        links.put("first", Map.of("href", linkTo(methodOn(GameController.class).findByPlatform(platformId, 0, size)).withSelfRel().getHref()));
        if (gamePage.getTotalPages() > 0) {
            links.put("last", Map.of("href", linkTo(methodOn(GameController.class).findByPlatform(platformId, gamePage.getTotalPages() - 1, size)).withSelfRel().getHref()));
        }
        if (gamePage.hasPrevious()) {
            links.put("prev", Map.of("href", linkTo(methodOn(GameController.class).findByPlatform(platformId, page - 1, size)).withSelfRel().getHref()));
        }
        if (gamePage.hasNext()) {
            links.put("next", Map.of("href", linkTo(methodOn(GameController.class).findByPlatform(platformId, page + 1, size)).withSelfRel().getHref()));
        }
        response.put("_links", links);

        return response;
    }
}