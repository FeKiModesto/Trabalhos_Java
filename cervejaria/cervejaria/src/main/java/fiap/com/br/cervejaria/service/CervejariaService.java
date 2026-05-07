package fiap.com.br.brewery.service;

import fiap.com.br.brewery.entity.Cervejaria;
import fiap.com.br.brewery.entity.Estilo;
import fiap.com.br.brewery.repository.CervejariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CervejariaService {

    private final CervejariaRepository cervejariaRepository;

    @Cacheable(value = "cervejarias", key = "#root.methodName")
    public List<Cervejaria> getAllCervejarias() {
        return cervejariaRepository.findAll();
    }

    @Cacheable(value = "cervejarias", key = "#id")
    public Cervejaria getCervejariaById(Long id) {
        return cervejariaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Cervejaria não encontrada com id: " + id
                ));
    }

    @CacheEvict(value = "cervejarias", allEntries = true)
    public Cervejaria addCervejaria(Cervejaria cervejaria) {
        return cervejariaRepository.save(cervejaria);
    }

    @CacheEvict(value = "cervejarias", allEntries = true)
    public Cervejaria updateCervejaria(Long id, Cervejaria cervejariaAtualizada, Estilo novoEstilo) {
        Cervejaria cervejariaExistente = getCervejariaById(id);

        if (cervejariaAtualizada.getNome() != null) {
            cervejariaExistente.setNome(cervejariaAtualizada.getNome());
        }
        if (cervejariaAtualizada.getEndereco() != null) {
            cervejariaExistente.setEndereco(cervejariaAtualizada.getEndereco());
        }
        if (novoEstilo != null) {
            cervejariaExistente.setEstiloPrincipal(novoEstilo);
        }

        return cervejariaRepository.save(cervejariaExistente);
    }

    @CacheEvict(value = "cervejarias", allEntries = true)
    public void deleteCervejaria(Long id) {
        Cervejaria cervejaria = getCervejariaById(id);
        cervejariaRepository.delete(cervejaria);
    }
}