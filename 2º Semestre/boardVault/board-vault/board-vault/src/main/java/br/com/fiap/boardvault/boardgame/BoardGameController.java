package br.com.fiap.boardvault.boardgame;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boardgames")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BoardGameController {

    private final BoardGameRepository boardGameRepository;

    // lista todos os jogos
    @GetMapping
    public List<BoardGame> listar() {
        return boardGameRepository.findAll();
    }

    // busca um jogo pelo id
    @GetMapping("/{id}")
    public ResponseEntity<BoardGame> buscarPorId(@PathVariable Long id) {
        return boardGameRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
