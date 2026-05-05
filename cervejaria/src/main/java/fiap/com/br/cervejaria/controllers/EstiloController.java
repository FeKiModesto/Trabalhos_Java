package fiap.com.br.cervejaria.controllers;

import fiap.com.br.cervejaria.entity.Estilo;
import fiap.com.br.cervejaria.service.EstiloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estilos")
@RequiredArgsConstructor
public class EstiloController {

    private final EstiloService estiloService;

    public record EstiloRequest(String nome, String descricao) {}

    @GetMapping
    @Operation(summary = "Listar todos os estilos", description = "Retorna uma lista com todos os estilos de cerveja cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    public List<Estilo> getAllEstilos() {
        return estiloService.getAllEstilos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar estilo por ID", description = "Retorna um estilo específico pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estilo encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Estilo não encontrado")
    })
    public Estilo getEstiloById(@PathVariable Long id) {
        return estiloService.getEstiloById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar novo estilo", description = "Adiciona um novo estilo de cerveja ao catálogo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Estilo criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public Estilo createEstilo(@RequestBody EstiloRequest request) {
        return estiloService.addEstilo(Estilo.builder()
                .nome(request.nome())
                .descricao(request.descricao())
                .build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um estilo", description = "Atualiza os dados de um estilo existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estilo atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Estilo não encontrado")
    })
    public Estilo updateEstilo(@PathVariable Long id, @RequestBody EstiloRequest request) {
        Estilo estiloAtualizado = Estilo.builder()
                .nome(request.nome())
                .descricao(request.descricao())
                .build();
        return estiloService.updateEstilo(id, estiloAtualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar um estilo", description = "Remove um estilo do catálogo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Estilo removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Estilo não encontrado")
    })
    public void deleteEstilo(@PathVariable Long id) {
        estiloService.deleteEstilo(id);
    }
}