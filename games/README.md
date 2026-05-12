# 🎮 Games API

API para gerenciamento de jogos desenvolvida em **Spring Boot** com **HATEOAS** como trabalho da disciplina de Java.

---

## 📋 Sumário

- [Tecnologias](#tecnologias)
- [Como Executar](#como-executar)
- [Endpoints](#endpoints)
  - [Jogos (Games)](#jogos-games)
  - [Extras](#extras)
- [Dados Iniciais](#dados-iniciais)
- [Testando no Postman](#testando-no-postman)
- [Autor](#autor)

---

## 🛠️ Tecnologias

- Java 17
- Spring Boot 4.0.6
- Spring Data JPA
- H2 Database (em memória)
- Spring HATEOAS
- Maven

---

## 🚀 Como Executar

### Pré-requisitos
- JDK 17 instalado

### Passos

```bash
# Clone o repositório
git clone https://github.com/FeKiModesto/Trabalhos_Java.git
```

# Entre na pasta do projeto
cd Trabalhos_Java/games

# Execute a aplicação
./mvnw spring-boot:run

A aplicação estará disponível em: http://localhost:8080

## 📍 Endpoints

## 🎮 Jogos (Games)
| Método | Endpoint | Descrição | Testar no |
|--------|----------|-----------|-----------|
| GET | `/api/games` | Lista todos os jogos | 🌐 Web / 📮 Postman |
| GET | `/api/games/{id}` | Busca jogo por ID | 🌐 Web / 📮 Postman |
| GET | `/api/games/genre/{genre}` | Busca jogos por gênero | 🌐 Web / 📮 Postman |
| GET | `/api/games/platform/{platform}` | Busca jogos por plataforma | 🌐 Web / 📮 Postman |
| GET | `/api/games/developer/{developer}` | Busca jogos por desenvolvedora | 🌐 Web / 📮 Postman |

Exemplo de resposta (HATEOAS):
```bash
{
  "id": 1,
  "name": "The Legend of Zelda: Tears of the Kingdom",
  "genre": "Adventure",
  "platform": "Nintendo Switch",
  "price": 299.9,
  "developer": "Nintendo",
  "_links": {
    "self": { "href": "http://localhost:8080/api/games/1", "title": "Game details" },
    "all-games": { "href": "http://localhost:8080/api/games", "title": "All games" },
    "games-by-genre": { "href": "http://localhost:8080/api/games/genre/Adventure", "title": "Same genre games" }
  }
}
```

## 🔧 Extras

| Tipo | Endpoint | Descrição | Testar no |
|------|----------|-----------|-----------|
| 🗄️ Banco de dados | `/h2-console` | Console H2 | 🌐 Web (navegador) |

### Configuração H2 Console:
- JDBC URL: jdbc:h2:mem:gamesdb
- User Name: sa
- Password: (vazio)

## 📊 Dados Iniciais (Jogos)
| ID | Nome | Gênero | Plataforma | Preço | Desenvolvedora |
|----|------|--------|------------|-------|----------------|
| 1 | The Legend of Zelda: Tears of the Kingdom | Adventure | Nintendo Switch | R$ 299,90 | Nintendo |
| 2 | God of War Ragnarök | Action | PlayStation 5 | R$ 249,90 | Santa Monica Studio |
| 3 | Elden Ring | RPG | PC | R$ 199,90 | FromSoftware |
| 4 | Hogwarts Legacy | RPG | PlayStation 5 | R$ 249,90 | Avalanche Software |
| 5 | Stardew Valley | Simulation | PC | R$ 29,90 | ConcernedApe |
| 6 | Super Mario Odyssey | Platformer | Nintendo Switch | R$ 249,90 | Nintendo |
| 7 | Cyberpunk 2077 | RPG | PC | R$ 149,90 | CD Projekt Red |
| 8 | Red Dead Redemption 2 | Adventure | PlayStation 4 | R$ 149,90 | Rockstar Games |
| 9 | Hades | Roguelike | PC | R$ 69,90 | Supergiant Games |
| 10 | Spider-Man: Miles Morales | Action | PlayStation 5 | R$ 199,90 | Insomniac Games |
| 11 | Animal Crossing: New Horizons | Simulation | Nintendo Switch | R$ 249,90 | Nintendo |
| 12 | Horizon Forbidden West | Adventure | PlayStation 5 | R$ 249,90 | Guerrilla Games |

## 📮 Testando no Postman
### Configuração Base

| Configuração | Valor |
|--------------|-------|
| Base URL | http://localhost:8080 |
| Headers | Content-Type: application/json |

Exemplos de Requisições

### Listar todos os jogos (GET)
```bash
GET http://localhost:8080/api/games
```

### Buscar jogo por ID (GET)
```bash
GET http://localhost:8080/api/games/1
```

### Buscar por gênero (GET)
```bash
GET http://localhost:8080/api/games/genre/RPG
```

### Buscar por plataforma (GET)
```bash
GET http://localhost:8080/api/games/platform/PC
```

### Buscar por desenvolvedora (GET)
```bash
GET http://localhost:8080/api/games/developer/Nintendo
```

## 📌 Resumo: O que testar em cada ferramenta

| Ferramenta | O que testar |
|------------|--------------|
| Navegador | H2 Console (/h2-console), endpoints GET |
| Postman | Todos os endpoints (GET) |

# 👨‍🎓 Autor
- Nome: Felipe Kirschner Modesto
- Email: fekimodesto04@gmail.com
