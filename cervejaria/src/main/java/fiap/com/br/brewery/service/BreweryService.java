package fiap.com.br.brewery.service;

import fiap.com.br.brewery.entity.Brewery;
import fiap.com.br.brewery.repository.BreweryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BreweryService {

    private final BreweryRepository breweryRepository;

    @Cacheable(value = "breweries", key = "#root.methodName")
    public List<Brewery> getAllBreweries() {
        return breweryRepository.findAll();
    }

    @Cacheable(value = "breweries", key = "#id")
    public Brewery getBreweryById(Long id) {
        return breweryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Cervejaria não encontrada com id: " + id
                ));
    }

    @CacheEvict(value = "breweries", allEntries = true)
    public Brewery addBrewery(Brewery brewery) {
        return breweryRepository.save(brewery);
    }

    @CacheEvict(value = "breweries", allEntries = true)
    public Brewery updateBrewery(Long id, Brewery breweryAtualizada) {
        Brewery breweryExistente = getBreweryById(id);

        if (breweryAtualizada.getName() != null) {
            breweryExistente.setName(breweryAtualizada.getName());
        }
        if (breweryAtualizada.getCountry() != null) {
            breweryExistente.setCountry(breweryAtualizada.getCountry());
        }

        return breweryRepository.save(breweryExistente);
    }

    @CacheEvict(value = "breweries", allEntries = true)
    public void deleteBrewery(Long id) {
        Brewery brewery = getBreweryById(id);
        breweryRepository.delete(brewery);
    }
}