package br.com.fiap.criptoplanner.crypto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// Mapeia só os campos que precisamos da resposta da CoinGecko
@JsonIgnoreProperties(ignoreUnknown = true)
public record CryptoResponse(
        String id,
        String name,
        @JsonProperty("market_data")
        MarketData marketData
) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record MarketData(
            @JsonProperty("current_price")
            CurrentPrice currentPrice,
            @JsonProperty("price_change_percentage_24h")
            double priceChangePercentage24h
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record CurrentPrice(
            double usd
    ) {}

}
