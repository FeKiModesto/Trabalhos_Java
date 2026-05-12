package fiap.com.br.games.model;

import fiap.com.br.games.controllers.GameController;
import jakarta.persistence.*;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String genre;
    private String platform;
    private Double price;
    private String developer;

    public Game() {
    }

    public Game(String name, String genre, String platform, Double price, String developer) {
        this.name = name;
        this.genre = genre;
        this.platform = platform;
        this.price = price;
        this.developer = developer;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public EntityModel<Game> toEntityModel() {
        var linkSelf = linkTo(methodOn(GameController.class).findById(id)).withSelfRel().withTitle("Game details");
        var linkAll = linkTo(methodOn(GameController.class).findAll()).withRel("all-games").withTitle("All games");
        var linkByGenre = linkTo(methodOn(GameController.class).findByGenre(genre)).withRel("games-by-genre").withTitle("Same genre games");

        return EntityModel.of(this, linkSelf, linkAll, linkByGenre);
    }
}