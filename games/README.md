# 🎮 Games API

API REST para gerenciamento de jogos desenvolvida em **Spring Boot** com **Spring HATEOAS**, como trabalho da disciplina de Java. Integrada ao front-end [GameFinder Web](https://github.com/joaocarloslima/gamefinder-web).

---

## 🔗 Links Úteis

| Link | Descrição |
|------|-----------|
| [GameFinder Web](https://github.com/joaocarloslima/gamefinder-web) | Front-end oficial do projeto |
| [H2 Console](http://localhost:8080/h2-console) | Console do banco de dados em memória |

---

## 📋 Sumário

- [Tecnologias](#tecnologias)
- [Como Executar](#como-executar)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Endpoints](#endpoints)
- [IDs Disponíveis](#ids-disponíveis)
- [Exemplo de Resposta](#exemplo-de-resposta-hateoas)
- [H2 Console](#h2-console)
- [Testando no Postman](#testando-no-postman)
- [Autor](#autor)

---

## Tecnologias

| Tecnologia | Versão |
|------------|--------|
| Java | 17 |
| Spring Boot | 3.x |
| Spring Data JPA | — |
| Spring HATEOAS | — |
| H2 Database | em memória |
| Maven | — |

---

## Como Executar

### Pré-requisitos
- JDK 17 instalado

### Passos

```bash
# Clone o repositório
git clone https://github.com/FeKiModesto/Trabalhos_Java.git

# Entre na pasta do projeto
cd Trabalhos_Java/games

# Execute a aplicação
./mvnw spring-boot:run
# No Windows:
mvnw.cmd spring-boot:run
```

A aplicação estará disponível em: **http://localhost:8080**

---

## Estrutura do Projeto

```
games/
├── src/main/java/fiap/com/br/games/
│   ├── config/
│   │   └── WebConfig.java          # Configuração de CORS
│   ├── controllers/
│   │   └── GameController.java     # Endpoints REST
│   ├── model/
│   │   ├── Game.java               # Entidade principal
│   │   ├── GameResponse.java       # DTO com _links HATEOAS
│   │   ├── Genre.java              # Entidade de gênero
│   │   └── Platform.java           # Entidade de plataforma
│   ├── repository/
│   │   ├── GameRepository.java
│   │   ├── GenreRepository.java
│   │   └── PlatformRepository.java
│   ├── service/
│   │   └── GameService.java
│   └── GamesApplication.java
├── src/main/resources/
│   ├── application.properties      # Configurações da aplicação
│   └── data.sql                    # Dados iniciais (20 jogos)
└── pom.xml
```

---

## Endpoints

### 🎮 Jogos (Games)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/games` | Lista todos os jogos (paginado) |
| GET | `/games/{id}` | Busca jogo por ID |
| GET | `/games/genres/{genreId}` | Filtra jogos por gênero |
| GET | `/games/platforms/{platformId}` | Filtra jogos por plataforma |

### Parâmetros de Paginação

| Parâmetro | Padrão | Descrição |
|-----------|--------|-----------|
| `page` | `0` | Número da página |
| `size` | `6` | Quantidade de itens por página |

**Exemplo com paginação:**
```
GET /games?page=1&size=6
```

---

## IDs Disponíveis

### Gêneros (Genres)

| ID | Nome |
|----|------|
| 1 | Action |
| 2 | Adventure |
| 3 | RPG |
| 4 | Strategy |
| 5 | Sports |
| 6 | Racing |
| 7 | Puzzle |
| 8 | Shooter |
| 9 | Fighting |
| 10 | Platformer |

### Plataformas (Platforms)

| ID | Nome |
|----|------|
| 1 | PlayStation 5 |
| 2 | Xbox Series X |
| 3 | Nintendo Switch |
| 4 | PC |
| 5 | PlayStation 4 |
| 6 | Xbox One |

---

## 📊 Dados Iniciais (Jogos)

| ID | Título | Gênero | Plataforma | Nota |
|----|--------|--------|------------|------|
| 1 | The Legend of Zelda: Tears of the Kingdom | Adventure (2) | Nintendo Switch (3) | 9.5 |
| 2 | Elden Ring | RPG (3) | PlayStation 5 (1) | 9.3 |
| 3 | God of War Ragnarök | Action (1) | PlayStation 4 (5) | 9.4 |
| 4 | Baldur's Gate 3 | RPG (3) | PC (4) | 9.6 |
| 5 | Call of Duty: Modern Warfare III | Shooter (8) | Xbox Series X (2) | 7.8 |
| 6 | FIFA 24 | Sports (5) | PlayStation 5 (1) | 7.5 |
| 7 | Super Mario Bros. Wonder | Platformer (10) | Nintendo Switch (3) | 9.1 |
| 8 | Starfield | RPG (3) | Xbox Series X (2) | 8.2 |
| 9 | Street Fighter 6 | Fighting (9) | PC (4) | 8.9 |
| 10 | Hogwarts Legacy | RPG (3) | PlayStation 5 (1) | 8.5 |
| 11 | Forza Motorsport | Racing (6) | Xbox Series X (2) | 8.4 |
| 12 | Resident Evil 4 Remake | Action (1) | PlayStation 4 (5) | 9.2 |
| 13 | Civilization VI | Strategy (4) | PC (4) | 9.0 |
| 14 | Portal 2 | Puzzle (7) | PC (4) | 9.7 |
| 15 | Assassin's Creed Mirage | Action (1) | PlayStation 5 (1) | 8.0 |
| 16 | Spider-Man 2 | Action (1) | PlayStation 5 (1) | 9.3 |
| 17 | Diablo IV | RPG (3) | PC (4) | 8.6 |
| 18 | Cyberpunk 2077 | RPG (3) | PlayStation 5 (1) | 8.3 |
| 19 | The Last of Us Part II | Action (1) | PlayStation 4 (5) | 9.4 |
| 20 | Age of Empires IV | Strategy (4) | PC (4) | 8.3 |

---

## Exemplo de Resposta HATEOAS

```json
{
  "_embedded": {
    "gameList": [
      {
        "id": 1,
        "title": "The Legend of Zelda: Tears of the Kingdom",
        "description": "An epic adventure through the skies...",
        "releaseDate": "2023-05-12",
        "rating": 9.5,
        "genre": { "id": 2, "name": "Adventure" },
        "platform": { "id": 3, "name": "Nintendo Switch" },
        "coverUrl": "https://...",
        "backdropUrl": "https://...",
        "inWishlist": true,
        "_links": {
          "self": { "href": "http://localhost:8080/games/1", "title": "Game details" },
          "all-games": { "href": "http://localhost:8080/games?page=0&size=6", "title": "All games" },
          "same-genre": { "href": "http://localhost:8080/games/genres/2?page=0&size=6", "title": "Games in Adventure genre" },
          "same-platform": { "href": "http://localhost:8080/games/platforms/3?page=0&size=6", "title": "Games on Nintendo Switch" }
        }
      }
    ]
  },
  "_links": {
    "self": { "href": "http://localhost:8080/games?page=0&size=6" },
    "next": { "href": "http://localhost:8080/games?page=1&size=6" },
    "last": { "href": "http://localhost:8080/games?page=3&size=6" },
    "first": { "href": "http://localhost:8080/games?page=0&size=6" }
  },
  "page": {
    "size": 6,
    "totalElements": 20,
    "totalPages": 4,
    "number": 0
  }
}
```

---

## H2 Console

Acesse o banco de dados em memória pelo navegador:

- **URL:** http://localhost:8080/h2-console
- **JDBC URL:** `jdbc:h2:mem:gamesdb`
- **User Name:** `sa`
- **Password:** *(vazio)*

---

## Testando no Postman

### Configuração Base

| Campo | Valor |
|-------|-------|
| Base URL | `http://localhost:8080` |
| Headers | `Content-Type: application/json` |

### Exemplos de Requisições

```bash
# Listar todos os jogos
GET http://localhost:8080/games

# Listar com paginação
GET http://localhost:8080/games?page=0&size=6

# Buscar jogo por ID
GET http://localhost:8080/games/1

# Filtrar por gênero (RPG)
GET http://localhost:8080/games/genres/3

# Filtrar por plataforma (PC)
GET http://localhost:8080/games/platforms/4
```

### O que testar em cada ferramenta

| Ferramenta | O que testar |
|------------|--------------|
| Navegador | H2 Console (`/h2-console`), endpoints GET |
| Postman | Todos os endpoints GET com diferentes parâmetros |
| GameFinder Web | Interface visual com filtros por gênero e plataforma |

---

## Autor
- **Nome:** Felipe Kirschner Modesto
- **Email:** fekimodesto04@gmail.com
