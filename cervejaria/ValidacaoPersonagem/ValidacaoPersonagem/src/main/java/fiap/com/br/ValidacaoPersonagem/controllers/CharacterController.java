package fiap.com.br.ValidacaoPersonagem.controller;

import fiap.com.br.ValidacaoPersonagem.dto.CharacterRequest;
import fiap.com.br.ValidacaoPersonagem.dto.CharacterResponse;
import fiap.com.br.ValidacaoPersonagem.entity.Character;
import fiap.com.br.ValidacaoPersonagem.service.CharacterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping
    public List<CharacterResponse> findAll() {
        return characterService.findAll()
                .stream()
                .map(CharacterResponse::fromEntity)
                .toList();
    }

    @PostMapping
    public Character create(@RequestBody @Valid CharacterRequest characterRequest) {
        return characterService.create(characterRequest.toEntity());
    }
}