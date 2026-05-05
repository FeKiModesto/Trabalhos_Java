package fiap.com.br.ValidacaoPersonagem.service;

import fiap.com.br.ValidacaoPersonagem.entity.Character;
import fiap.com.br.ValidacaoPersonagem.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterService {
    private final CharacterRepository characterRepository;

    public Character create(Character character) {
        return characterRepository.save(character);
    }

    public List<Character> findAll() {
        return characterRepository.findAll();
    }
}
