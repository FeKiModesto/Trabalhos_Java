package fiap.com.br.games.controllers;

import fiap.com.br.games.model.Game;
import fiap.com.br.games.service.GameService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public CollectionModel<EntityModel<Game>> findAll(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "6") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Game> gamePage = gameService.findAll(pageable);

        List<EntityModel<Game>> games = gamePage.getContent()
                .stream()
                .map(Game::toEntityModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<Game>> collectionModel = CollectionModel.of(games);

        // Links de paginação
        collectionModel.add(linkTo(methodOn(GameController.class).findAll(page, size)).withSelfRel());
        collectionModel.add(linkTo(methodOn(GameController.class).findAll(0, size)).withRel("first"));
        if (gamePage.getTotalPages() > 0) {
            collectionModel.add(linkTo(methodOn(GameController.class).findAll(gamePage.getTotalPages() - 1, size)).withRel("last"));
        }
        if (gamePage.hasPrevious()) {
            collectionModel.add(linkTo(methodOn(GameController.class).findAll(page - 1, size)).withRel("prev"));
        }
        if (gamePage.hasNext()) {
            collectionModel.add(linkTo(methodOn(GameController.class).findAll(page + 1, size)).withRel("next"));
        }

        return collectionModel;
    }

    @GetMapping("/{id}")
    public EntityModel<Game> findById(@PathVariable Long id) {
        return gameService.findById(id).toEntityModel();
    }

    @GetMapping("/genres/{genreId}")
    public CollectionModel<EntityModel<Game>> findByGenre(@PathVariable Long genreId,
                                                          @RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "6") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Game> gamePage = gameService.findByGenreId(genreId, pageable);

        List<EntityModel<Game>> games = gamePage.getContent()
                .stream()
                .map(Game::toEntityModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<Game>> collectionModel = CollectionModel.of(games);

        collectionModel.add(linkTo(methodOn(GameController.class).findByGenre(genreId, page, size)).withSelfRel());
        collectionModel.add(linkTo(methodOn(GameController.class).findByGenre(genreId, 0, size)).withRel("first"));
        if (gamePage.getTotalPages() > 0) {
            collectionModel.add(linkTo(methodOn(GameController.class).findByGenre(genreId, gamePage.getTotalPages() - 1, size)).withRel("last"));
        }
        if (gamePage.hasPrevious()) {
            collectionModel.add(linkTo(methodOn(GameController.class).findByGenre(genreId, page - 1, size)).withRel("prev"));
        }
        if (gamePage.hasNext()) {
            collectionModel.add(linkTo(methodOn(GameController.class).findByGenre(genreId, page + 1, size)).withRel("next"));
        }

        return collectionModel;
    }

    @GetMapping("/platforms/{platformId}")
    public CollectionModel<EntityModel<Game>> findByPlatform(@PathVariable Long platformId,
                                                             @RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "6") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Game> gamePage = gameService.findByPlatformId(platformId, pageable);

        List<EntityModel<Game>> games = gamePage.getContent()
                .stream()
                .map(Game::toEntityModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<Game>> collectionModel = CollectionModel.of(games);

        collectionModel.add(linkTo(methodOn(GameController.class).findByPlatform(platformId, page, size)).withSelfRel());
        collectionModel.add(linkTo(methodOn(GameController.class).findByPlatform(platformId, 0, size)).withRel("first"));
        if (gamePage.getTotalPages() > 0) {
            collectionModel.add(linkTo(methodOn(GameController.class).findByPlatform(platformId, gamePage.getTotalPages() - 1, size)).withRel("last"));
        }
        if (gamePage.hasPrevious()) {
            collectionModel.add(linkTo(methodOn(GameController.class).findByPlatform(platformId, page - 1, size)).withRel("prev"));
        }
        if (gamePage.hasNext()) {
            collectionModel.add(linkTo(methodOn(GameController.class).findByPlatform(platformId, page + 1, size)).withRel("next"));
        }

        return collectionModel;
    }
}