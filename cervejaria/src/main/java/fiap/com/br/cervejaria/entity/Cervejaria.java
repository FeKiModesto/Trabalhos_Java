package fiap.com.br.cervejaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cervejarias")
public class Cervejaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(length = 300)
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "estilo_principal_id")
    private Estilo estiloPrincipal;
}