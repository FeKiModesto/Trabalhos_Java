package fiap.com.br.cervejaria.controllers;

import fiap.com.br.cervejaria.entity.Cervejaria;
import fiap.com.br.cervejaria.entity.Estilo;
import fiap.com.br.cervejaria.service.CervejariaService;
import fiap.com.br.cervejaria.service.EstiloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cervejarias")
@RequiredArgsConstructor
public class CervejariaController {

    private final CervejariaService cervejariaService;
    private final EstiloService estiloService;

    public record CervejariaRequest(String nome, String endereco, Long estiloPrincipalId) {}
    public record CervejariaUpdateRequest(String nome, String endereco, Long estiloPrincipalId) {}

    @GetMapping
    @Operation(summary = "Listar todas as cervejarias", description = "Retorna uma lista com todas as cervejarias cadastradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    public List<Cervejaria> getAllCervejarias() {
        return cervejariaService.getAllCervejarias();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cervejaria por ID", description = "Retorna uma cervejaria específica pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cervejaria encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cervejaria não encontrada")
    })
    public Cervejaria getCervejariaById(@PathVariable Long id) {
        return cervejariaService.getCervejariaById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar nova cervejaria", description = "Adiciona uma nova cervejaria ao catálogo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cervejaria criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Estilo principal não encontrado")
    })
    public Cervejaria createCervejaria(@RequestBody CervejariaRequest request) {
        Estilo estilo = estiloService.getEstiloById(request.estiloPrincipalId());

        return cervejariaService.addCervejaria(Cervejaria.builder()
                .nome(request.nome())
                .endereco(request.endereco())
                .estiloPrincipal(estilo)
                .build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma cervejaria", description = "Atualiza os dados de uma cervejaria existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cervejaria atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cervejaria não encontrada")
    })
    public Cervejaria updateCervejaria(@PathVariable Long id, @RequestBody CervejariaUpdateRequest request) {
        Estilo estilo = null;
        if (request.estiloPrincipalId() != null) {
            estilo = estiloService.getEstiloById(request.estiloPrincipalId());
        }

        Cervejaria cervejariaAtualizada = Cervejaria.builder()
                .nome(request.nome())
                .endereco(request.endereco())
                .build();

        return cervejariaService.updateCervejaria(id, cervejariaAtualizada, estilo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar uma cervejaria", description = "Remove uma cervejaria do catálogo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cervejaria removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cervejaria não encontrada")
    })
    public void deleteCervejaria(@PathVariable Long id) {
        cervejariaService.deleteCervejaria(id);
    }
}