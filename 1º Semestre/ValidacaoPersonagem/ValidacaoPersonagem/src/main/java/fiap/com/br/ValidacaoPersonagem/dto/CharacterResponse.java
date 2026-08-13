package fiap.com.br.ValidacaoPersonagem.dto;

import fiap.com.br.ValidacaoPersonagem.entity.Character;
import fiap.com.br.ValidacaoPersonagem.entity.CharacterClass;

import java.time.LocalDate;

public record CharacterResponse(
        Long id,
        String name,
        String email,
        Integer age,
        CharacterClass characterClass,
        Integer level,
        Double hp,
        LocalDate createdAt,
        String characterCode
) {
    public static CharacterResponse fromEntity(Character character) {
        return new CharacterResponse(
                character.getId(),
                character.getName(),
                character.getEmail(),
                character.getAge(),
                character.getCharacterClass(),
                character.getLevel(),
                character.getHp(),
                character.getCreatedAt(),
                character.getCharacterCode()
        );
    }
}
