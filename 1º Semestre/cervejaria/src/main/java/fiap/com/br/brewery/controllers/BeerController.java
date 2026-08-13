package fiap.com.br.brewery.controllers;

import fiap.com.br.brewery.entity.Beer;
import fiap.com.br.brewery.entity.Brewery;
import fiap.com.br.brewery.service.BeerService;
import fiap.com.br.brewery.service.BreweryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beers")
@RequiredArgsConstructor
@Tag(name = "Beer", description = "Endpoints para gerenciamento de cervejas")
public class BeerController {

    private final BeerService beerService;
    private final BreweryService breweryService;

    public record BeerRequest(String name, String description, Double alcoholContent, String harmonization, Long breweryId) {}
    public record BeerUpdateRequest(String name, String description, Double alcoholContent, String harmonization, Long breweryId) {}

    @GetMapping
    @Operation(summary = "Listar todas as cervejas", description = "Retorna uma lista com todas as cervejas cadastradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    public List<Beer> getAllBeers() {
        return beerService.getAllBeers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cerveja por ID", description = "Retorna uma cerveja específica pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cerveja encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cerveja não encontrada")
    })
    public Beer getBeerById(@PathVariable Long id) {
        return beerService.getBeerById(id);
    }

    @GetMapping("/brewery/{id}")
    @Operation(summary = "Listar cervejas por cervejaria", description = "Retorna uma lista de cervejas de uma determinada cervejaria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cervejaria não encontrada")
    })
    public List<Beer> getBeersByBreweryId(@PathVariable Long id) {
        return beerService.getBeersByBreweryId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar nova cerveja", description = "Adiciona uma nova cerveja ao catálogo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cerveja criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Cervejaria não encontrada")
    })
    public Beer createBeer(@RequestBody BeerRequest request) {
        Brewery brewery = breweryService.getBreweryById(request.breweryId());

        return beerService.addBeer(Beer.builder()
                .name(request.name())
                .description(request.description())
                .alcoholContent(request.alcoholContent())
                .harmonization(request.harmonization())
                .brewery(brewery)
                .build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma cerveja", description = "Atualiza os dados de uma cerveja existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cerveja atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cerveja não encontrada")
    })
    public Beer updateBeer(@PathVariable Long id, @RequestBody BeerUpdateRequest request) {
        Brewery brewery = null;
        if (request.breweryId() != null) {
            brewery = breweryService.getBreweryById(request.breweryId());
        }

        Beer beerAtualizada = Beer.builder()
                .name(request.name())
                .description(request.description())
                .alcoholContent(request.alcoholContent())
                .harmonization(request.harmonization())
                .brewery(brewery)
                .build();

        return beerService.updateBeer(id, beerAtualizada);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar uma cerveja", description = "Remove uma cerveja do catálogo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cerveja removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cerveja não encontrada")
    })
    public void deleteBeer(@PathVariable Long id) {
        beerService.deleteBeer(id);
    }
}