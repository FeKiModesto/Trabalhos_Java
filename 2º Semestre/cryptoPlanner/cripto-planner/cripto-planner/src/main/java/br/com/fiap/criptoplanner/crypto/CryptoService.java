package br.com.fiap.criptoplanner.crypto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

// Consome a API pública da CoinGecko para buscar dados de uma criptomoeda
@HttpExchange(
        url = "https://api.coingecko.com/api/v3/coins",
        accept = "application/json"
)
public interface CryptoService {

    @GetExchange("/{id}")
    CryptoResponse getCoin(@PathVariable String id);

}