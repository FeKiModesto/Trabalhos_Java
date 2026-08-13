package fiap.com.br.ValidacaoPersonagem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fiap.com.br.ValidacaoPersonagem.entity.Character;
import fiap.com.br.ValidacaoPersonagem.entity.CharacterClass;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record CharacterRequest(

        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres")
        String name,

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato de email inválido")
        String email,

        @NotNull(message = "Idade é obrigatória")
        @Min(value = 12, message = "Idade mínima é 12")
        @Max(value = 120, message = "Idade máxima é 120")
        Integer age,

        @NotNull(message = "Classe é obrigatória")
        @JsonProperty("class")
        CharacterClass characterClass,

        @NotNull(message = "Nível é obrigatório")
        @Min(value = 1, message = "Nível mínimo é 1")
        @Max(value = 100, message = "Nível máximo é 100")
        Integer level,

        @NotNull(message = "HP é obrigatório")
        @DecimalMin(value = "0.0", message = "HP não pode ser negativo")
        Double hp,

        @NotNull(message = "Data de criação é obrigatória")
        @PastOrPresent(message = "Data de criação não pode ser futura")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate createdAt,

        @NotBlank(message = "Character code é obrigatório")
        @Pattern(regexp = "^CHAR-\\d{4}$", message = "Formato deve ser CHAR- seguido de 4 dígitos (ex: CHAR-1234)")
        String characterCode

) {
    public Character toEntity() {
        return Character.builder()
                .name(name)
                .email(email)
                .age(age)
                .characterClass(characterClass)
                .level(level)
                .hp(hp)
                .createdAt(createdAt)
                .characterCode(characterCode)
                .build();
    }
}