# Cripto Planner

Exercício da disciplina **Java Advanced** — 2º Semestre — FIAP.

O Cripto Planner é uma aplicação que ajuda o usuário a decidir se é um bom momento
para comprar, vender ou investir em uma criptomoeda, com base na variação de preço
nas últimas 24h consultada em tempo real na API pública da CoinGecko.

## Tecnologias

- Java 17
- Spring Boot 4.1.1
- Spring HTTP Interface Client (`@HttpExchange`)
- API pública da CoinGecko

## Endpoint
```
GET /api/planner?activity={activity}
```

### Atividades disponíveis

| Activity | Moeda |
|---|---|
| Comprar Bitcoin | Bitcoin |
| Vender Ethereum | Ethereum |
| Investir em Dogecoin | Dogecoin |

### Exemplo de resposta

```json
{
  "result": "Bom momento para comprar Bitcoin, o preço caiu 6.2% nas últimas 24h."
}
```

## Front-end

O front-end utilizado é de autoria do professor **João Carlos Lima**.

- Fork: https://github.com/FeKiModesto/cripto-web
- Projeto original: https://github.com/joaocarloslima/cripto-web

## Autor
- Felipe Kirschner Modesto
