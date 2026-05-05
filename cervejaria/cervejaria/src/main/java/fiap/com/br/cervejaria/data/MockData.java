package fiap.com.br.cervejaria.data;

import fiap.com.br.cervejaria.entity.Cervejaria;
import fiap.com.br.cervejaria.entity.Estilo;
import fiap.com.br.cervejaria.service.CervejariaService;
import fiap.com.br.cervejaria.service.EstiloService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MockData {

    private final EstiloService estiloService;
    private final CervejariaService cervejariaService;

    @PostConstruct
    public void init() {
        // ========== ESTILOS ==========
        Estilo pilsen = estiloService.addEstilo(Estilo.builder()
                .nome("Pilsen")
                .descricao("Cerveja leve e refrescante, a mais consumida no Brasil")
                .build());

        Estilo lager = estiloService.addEstilo(Estilo.builder()
                .nome("Lager")
                .descricao("Cerveja de baixa fermentação, sabor suave e equilibrado")
                .build());

        // ========== CERVEJARIAS BRASILEIRAS ==========

        cervejariaService.addCervejaria(Cervejaria.builder()
                .nome("Ambev")
                .endereco("São Paulo - SP")
                .estiloPrincipal(pilsen)
                .build());

        cervejariaService.addCervejaria(Cervejaria.builder()
                .nome("Heineken Brasil")
                .endereco("Rio de Janeiro - RJ")
                .estiloPrincipal(lager)
                .build());

        cervejariaService.addCervejaria(Cervejaria.builder()
                .nome("Grupo Petrópolis")
                .endereco("Petrópolis - RJ")
                .estiloPrincipal(pilsen)
                .build());
    }
}