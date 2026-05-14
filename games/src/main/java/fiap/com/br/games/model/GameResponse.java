package fiap.com.br.games.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.Map;

public class GameResponse {

    private Long id;
    private String title;
    private String description;
    private LocalDate releaseDate;
    private Double rating;
    private Genre genre;
    private Platform platform;
    private String coverUrl;
    private String backdropUrl;
    private boolean inWishlist;
    private Map<String, Object> links;

    public GameResponse(Game game, Map<String, Object> links) {
        this.id = game.getId();
        this.title = game.getTitle();
        this.description = game.getDescription();
        this.releaseDate = game.getReleaseDate();
        this.rating = game.getRating();
        this.genre = game.getGenre();
        this.platform = game.getPlatform();
        this.coverUrl = game.getCoverUrl();
        this.backdropUrl = game.getBackdropUrl();
        this.inWishlist = game.isInWishlist();
        this.links = links;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDate getReleaseDate() { return releaseDate; }
    public Double getRating() { return rating; }
    public Genre getGenre() { return genre; }
    public Platform getPlatform() { return platform; }
    public String getCoverUrl() { return coverUrl; }
    public String getBackdropUrl() { return backdropUrl; }
    public boolean isInWishlist() { return inWishlist; }

    @JsonProperty("_links")
    public Map<String, Object> getLinks() { return links; }
}