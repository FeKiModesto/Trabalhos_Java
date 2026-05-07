package fiap.com.br.brewery.service;

import fiap.com.br.brewery.entity.Beer;
import fiap.com.br.brewery.entity.Brewery;
import fiap.com.br.brewery.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeerService {

    private final BeerRepository beerRepository;

    @Cacheable(value = "beers", key = "#root.methodName")
    public List<Beer> getAllBeers() {
        return beerRepository.findAll();
    }

    @Cacheable(value = "beers", key = "#id")
    public Beer getBeerById(Long id) {
        return beerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Cerveja não encontrada com id: " + id
                ));
    }

    @Cacheable(value = "beers", key = "#breweryId")
    public List<Beer> getBeersByBreweryId(Long breweryId) {
        return beerRepository.findByBreweryId(breweryId);
    }

    @CacheEvict(value = "beers", allEntries = true)
    public Beer addBeer(Beer beer) {
        return beerRepository.save(beer);
    }

    @CacheEvict(value = "beers", allEntries = true)
    public Beer updateBeer(Long id, Beer beerAtualizado) {
        Beer beerExistente = getBeerById(id);

        if (beerAtualizado.getName() != null) {
            beerExistente.setName(beerAtualizado.getName());
        }
        if (beerAtualizado.getDescription() != null) {
            beerExistente.setDescription(beerAtualizado.getDescription());
        }
        if (beerAtualizado.getAlcoholContent() != null) {
            beerExistente.setAlcoholContent(beerAtualizado.getAlcoholContent());
        }
        if (beerAtualizado.getHarmonization() != null) {
            beerExistente.setHarmonization(beerAtualizado.getHarmonization());
        }
        if (beerAtualizado.getBrewery() != null) {
            beerExistente.setBrewery(beerAtualizado.getBrewery());
        }

        return beerRepository.save(beerExistente);
    }

    @CacheEvict(value = "beers", allEntries = true)
    public void deleteBeer(Long id) {
        Beer beer = getBeerById(id);
        beerRepository.delete(beer);
    }
}