package fiap.com.br.brewery.service;

import fiap.com.br.brewery.entity.Estilo;
import fiap.com.br.brewery.repository.EstiloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstiloService {

    private final EstiloRepository estiloRepository;

    @Cacheable(value = "estilos", key = "#root.methodName")
    public List<Estilo> getAllEstilos() {
        return estiloRepository.findAll();
    }

    @Cacheable(value = "estilos", key = "#id")
    public Estilo getEstiloById(Long id) {
        return estiloRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Estilo não encontrado com id: " + id
                ));
    }

    @CacheEvict(value = "estilos", allEntries = true)
    public Estilo addEstilo(Estilo estilo) {
        return estiloRepository.save(estilo);
    }

    @CacheEvict(value = "estilos", key = "#id", allEntries = true)
    public Estilo updateEstilo(Long id, Estilo estiloAtualizado) {
        Estilo estiloExistente = getEstiloById(id);
        if (estiloAtualizado.getNome() != null) {
            estiloExistente.setNome(estiloAtualizado.getNome());
        }
        if (estiloAtualizado.getDescricao() != null) {
            estiloExistente.setDescricao(estiloAtualizado.getDescricao());
        }
        return estiloRepository.save(estiloExistente);
    }

    @CacheEvict(value = "estilos", key = "#id", allEntries = true)
    public void deleteEstilo(Long id) {
        Estilo estilo = getEstiloById(id);
        estiloRepository.delete(estilo);
    }
}