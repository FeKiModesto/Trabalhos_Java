package br.com.fiap.criptoplanner.planner;

import br.com.fiap.criptoplanner.crypto.CryptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlannerService {

    private final CryptoService cryptoService;

    public String getPlannerFromActivity(String activity) {
        return switch (activity) {
            case "Comprar Bitcoin" -> analisarCompra();
            case "Vender Ethereum" -> analisarVenda();
            case "Investir em Dogecoin" -> analisarInvestimento();
            default -> "Atividade não reconhecida";
        };
    }

    // Regra: variação > 5% = pode estar supervalorizado, < -5% = bom pra comprar
    private String analisarCompra() {
        var dados = cryptoService.getCoin("bitcoin").marketData();
        var variacao = dados.priceChangePercentage24h();

        if (variacao > 5) {
            return String.format(
                "Não recomendado comprar Bitcoin agora, o preço subiu %.1f%% nas últimas 24h. Pode estar supervalorizado.",
                variacao
            );
        }
        if (variacao < -5) {
            return String.format(
                "Bom momento para comprar Bitcoin, o preço caiu %.1f%% nas últimas 24h.",
                Math.abs(variacao)
            );
        }
        return String.format(
            "Preço do Bitcoin estável (%.1f%% nas últimas 24h), sem sinal forte para compra.",
            variacao
        );
    }

    // Regra: variação < -5% = espere recuperar, > 5% = bom pra vender
    private String analisarVenda() {
        var dados = cryptoService.getCoin("ethereum").marketData();
        var variacao = dados.priceChangePercentage24h();

        if (variacao < -5) {
            return String.format(
                "Não recomendado vender Ethereum agora, o preço caiu %.1f%% nas últimas 24h. Espere a recuperação.",
                Math.abs(variacao)
            );
        }
        if (variacao > 5) {
            return String.format(
                "Bom momento para vender Ethereum, o preço subiu %.1f%% nas últimas 24h.",
                variacao
            );
        }
        return String.format(
            "Preço do Ethereum estável (%.1f%% nas últimas 24h), sem sinal forte para venda.",
            variacao
        );
    }

    // Regra: variação > 10% = alta volatilidade, risco elevado
    private String analisarInvestimento() {
        var dados = cryptoService.getCoin("dogecoin").marketData();
        var variacao = dados.priceChangePercentage24h();

        if (Math.abs(variacao) > 10) {
            return String.format(
                "Cuidado! Dogecoin com alta volatilidade (%.1f%% nas últimas 24h). Risco elevado.",
                variacao
            );
        }
        return String.format(
            "Volatilidade normal no Dogecoin (%.1f%% nas últimas 24h), mas lembre-se: é um ativo de altíssimo risco.",
            variacao
        );
    }

}
