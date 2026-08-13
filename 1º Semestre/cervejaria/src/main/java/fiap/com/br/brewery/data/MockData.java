package fiap.com.br.brewery.data;

import fiap.com.br.brewery.entity.Brewery;
import fiap.com.br.brewery.entity.Beer;
import fiap.com.br.brewery.service.BeerService;
import fiap.com.br.brewery.service.BreweryService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MockData {

    private final BeerService beerService;
    private final BreweryService breweryService;

    @PostConstruct
    public void init() {
        // ========== CERVEJARIAS (3) ==========

        Brewery primavera = breweryService.addBrewery(Brewery.builder()
                .name("Primavera IPA")
                .country("Brasil")
                .build());

        Brewery rioNegro = breweryService.addBrewery(Brewery.builder()
                .name("Rio Negro")
                .country("Brasil")
                .build());

        Brewery valeVerde = breweryService.addBrewery(Brewery.builder()
                .name("Vale Verde")
                .country("Brasil")
                .build());

        // ========== CERVEJAS (6) ==========

        beerService.addBeer(Beer.builder()
                .name("Primavera IPA")
                .description("Cerveja com notas cítricas e amargor marcante")
                .alcoholContent(6.5)
                .harmonization("Frango grelhado, queijos")
                .brewery(primavera)
                .build());

        beerService.addBeer(Beer.builder()
                .name("Serra Alta IPA")
                .description("IPA com alto teor de lúpulo e aroma floral")
                .alcoholContent(6.8)
                .harmonization("Carnes vermelhas, queijos fortes")
                .brewery(primavera)
                .build());

        beerService.addBeer(Beer.builder()
                .name("Noite Stout")
                .description("Cerveja escura com notas de café e chocolate")
                .alcoholContent(7.2)
                .harmonization("Chocolate amargo, carne")
                .brewery(rioNegro)
                .build());

        beerService.addBeer(Beer.builder()
                .name("Rio Negro Stout")
                .description("Stout encorpada com toques de malte torrado")
                .alcoholContent(7.5)
                .harmonization("Sobremesas, queijo gorgonzola")
                .brewery(rioNegro)
                .build());

        beerService.addBeer(Beer.builder()
                .name("Lager do Sol")
                .description("Cerveja leve e refrescante, ideal para dias quentes")
                .alcoholContent(4.8)
                .harmonization("Petiscos, saladas leves")
                .brewery(valeVerde)
                .build());

        beerService.addBeer(Beer.builder()
                .name("Vale Verde Pilsen")
                .description("Pilsen tradicional de baixa fermentação")
                .alcoholContent(5.0)
                .harmonization("Frutos do mar, queijo branco")
                .brewery(valeVerde)
                .build());
    }
}