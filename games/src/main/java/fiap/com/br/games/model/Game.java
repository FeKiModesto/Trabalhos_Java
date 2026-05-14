package fiap.com.br.games.model;

import fiap.com.br.games.controllers.GameController;
import jakarta.persistence.*;
import org.springframework.hateoas.EntityModel;

import java.time.LocalDate;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    private LocalDate releaseDate;

    private Double rating;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "platform_id")
    private Platform platform;

    private String coverUrl;
    private String backdropUrl;
    private boolean inWishlist;

    public Game() {
    }

    public Game(String title, String description, LocalDate releaseDate, Double rating, Genre genre, Platform platform, String coverUrl, String backdropUrl, boolean inWishlist) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.genre = genre;
        this.platform = platform;
        this.coverUrl = coverUrl;
        this.backdropUrl = backdropUrl;
        this.inWishlist = inWishlist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getBackdropUrl() {
        return backdropUrl;
    }

    public void setBackdropUrl(String backdropUrl) {
        this.backdropUrl = backdropUrl;
    }

    public boolean isInWishlist() {
        return inWishlist;
    }

    public void setInWishlist(boolean inWishlist) {
        this.inWishlist = inWishlist;
    }

    public EntityModel<Game> toEntityModel() {
        var linkSelf = linkTo(methodOn(GameController.class).findById(id)).withSelfRel().withTitle("Game details");
        var linkAll = linkTo(methodOn(GameController.class).findAll(0, 10)).withRel("all-games").withTitle("All games");

        EntityModel<Game> entityModel = EntityModel.of(this, linkSelf, linkAll);

        if (genre != null) {
            var linkByGenre = linkTo(methodOn(GameController.class).findByGenre(genre.getId(), 0, 10)).withRel("games-by-genre").withTitle("Same genre games");
            entityModel.add(linkByGenre);
        }

        if (platform != null) {
            var linkByPlatform = linkTo(methodOn(GameController.class).findByPlatform(platform.getId(), 0, 10)).withRel("games-by-platform").withTitle("Same platform games");
            entityModel.add(linkByPlatform);
        }

        return entityModel;
    }
}