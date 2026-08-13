package fiap.com.br.ValidacaoPersonagem.repository;

import fiap.com.br.ValidacaoPersonagem.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}
