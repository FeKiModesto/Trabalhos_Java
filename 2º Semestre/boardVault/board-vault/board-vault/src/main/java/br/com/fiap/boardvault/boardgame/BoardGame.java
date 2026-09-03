package br.com.fiap.boardvault.boardgame;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "board_game")
public class BoardGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer minPlayers;
    private Integer maxPlayers;
    private BigDecimal rating;
    private String imageUrl;

}
