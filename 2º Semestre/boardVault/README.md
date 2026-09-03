# 🎲 Board Vault

Exercício da disciplina **Java Advanced** — 2º Semestre — FIAP.

Board Vault é um catálogo de jogos de tabuleiro. A API permite listar todos os jogos
e consultar detalhes de um jogo específico, com banco de dados gerenciado pelo Flyway.

## Tecnologias

- Java 17
- Spring Boot 4.1.1
- Spring Data JPA
- Flyway
- PostgreSQL
- Docker

## Subindo o banco

```bash
docker-compose up -d
```

## Endpoints
```bash
GET /boardgames
GET /boardgames/{id}
```

### Exemplo de resposta

```json
{
  "id": 1,
  "title": "Catan",
  "minPlayers": 3,
  "maxPlayers": 4,
  "rating": 4.7,
  "imageUrl": null
}
```

## Front-end

O front-end utilizado é de autoria do professor **João Carlos Lima**.

- Fork: https://github.com/FeKiModesto/board-vault-web
- Projeto original: https://github.com/joaocarloslima/board-vault-web
