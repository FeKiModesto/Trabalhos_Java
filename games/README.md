# 🎮 Games API

API para gerenciamento de jogos desenvolvida em **Spring Boot** com **HATEOAS** como trabalho da disciplina de Java.

---

## 🔗 Links Úteis

| Link | Descrição |
|------|-----------|
| [GameFinder Web](https://github.com/joaocarloslima/gamefinder-web) | Front-end oficial do projeto |

---

## 📋 Sumário

- [Tecnologias](#tecnologias)
- [Como Executar](#como-executar)
- [Endpoints](#endpoints)
  - [Jogos (Games)](#jogos-games)
  - [Extras](#extras)
- [IDs Disponíveis](#ids-disponíveis)
  - [Gêneros (Genres)](#gêneros-genres)
  - [Plataformas (Platforms)](#plataformas-platforms)
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

### ℹ️ Como usar os endpoints de busca por gênero e plataforma

Os endpoints `/games/genres/{genreId}` e `/games/platforms/{platformId}` utilizam **IDs numéricos** para identificar cada gênero ou plataforma.

**Consulte a seção [IDs Disponíveis](#ids-disponíveis) para saber qual ID usar.**

**Exemplos:**
- Para buscar jogos de **PC**, use: `/games/platforms/4`
- Para buscar jogos de **RPG**, use: `/games/genres/3`

---

### Endpoints disponíveis

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/games` | Lista todos os jogos |
| GET | `/games/{id}` | Busca jogo por ID |
| GET | `/games/genres/{genreId}` | Busca jogos por ID do gênero |
| GET | `/games/platforms/{platformId}` | Busca jogos por ID da plataforma |

## 📋 IDs Disponíveis
Abaixo estão todos os ID's disponíveis para utilizar:

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

Exemplo de resposta (HATEOAS):
```bash
{
  "title": "The Legend of Zelda: Tears of the Kingdom",
  "rating": 9.5,
  "genre": { "id": 2, "name": "Adventure" },
  "platform": { "id": 3, "name": "Nintendo Switch" },
  "_links": {
    "self": { "href": "http://localhost:8080/games/1" },
    "all-games": { "href": "http://localhost:8080/games" },
    "games-by-genre": { "href": "http://localhost:8080/games/genres/2" },
    "games-by-platform": { "href": "http://localhost:8080/games/platforms/3" }
  }
}
```

---

## 🔧 Extras

| Tipo | Endpoint | Descrição |
|------|----------|-----------|
| 🗄️ Banco de dados | `/h2-console` | Console H2 |

### Configuração H2 Console:
- JDBC URL: `jdbc:h2:mem:gamesdb`
- User Name: `sa`
- Password: (vazio)

---

## 📊 Dados Iniciais (Jogos)

| ID | Título | Gênero | Plataforma | Nota |
|----|--------|--------|------------|------|
| 1 | The Legend of Zelda: Tears of the Kingdom | Adventure (2) | Nintendo Switch (3) | 9.5 |
| 2 | God of War Ragnarök | Action (1) | PlayStation 5 (1) | 9.4 |
| 3 | Elden Ring | RPG (3) | PC (4) | 9.3 |
| ... | ... | ... | ... | ... |

> ⚠️ A lista completa de jogos pode ser consultada diretamente no arquivo `data.sql` do repositório.

## 📮 Testando no Postman
### Configuração Base

| Configuração | Valor |
|--------------|-------|
| Base URL | http://localhost:8080 |
| Headers | Content-Type: application/json |

Exemplos de Requisições

### Listar todos os jogos (GET)
```bash
http://localhost:8080/games
```

### Buscar jogo por ID (GET)
```bash
http://localhost:8080/games/1
```

### Buscar por gênero (GET)
```bash
http://localhost:8080/games/genres/3
```

### Buscar por plataforma (GET)
```bash
http://localhost:8080/games/platforms/4
```

## 📌 Resumo: O que testar em cada ferramenta

| Ferramenta | O que testar |
|------------|--------------|
| Navegador | H2 Console (/h2-console), endpoints GET |
| Postman | Todos os endpoints (GET) |

# 👨‍🎓 Autor
- Nome: Felipe Kirschner Modesto
- Email: fekimodesto04@gmail.com
