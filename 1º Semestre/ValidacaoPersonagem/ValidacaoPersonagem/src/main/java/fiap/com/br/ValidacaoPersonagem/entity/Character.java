package fiap.com.br.ValidacaoPersonagem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "characters")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "class", nullable = false)
    private CharacterClass characterClass;

    @Column(nullable = false)
    private Integer level;

    @Column(nullable = false)
    private Double hp;

    @Column(nullable = false)
    private LocalDate createdAt;

    @Column(nullable = false, unique = true)
    private String characterCode;
}
