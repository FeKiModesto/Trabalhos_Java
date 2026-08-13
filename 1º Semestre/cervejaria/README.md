# 🍺 Beer Guide API

API para gerenciamento de cervejarias e cervejas artesanais desenvolvida em **Spring Boot** como trabalho da disciplina de Java.

---

## 📋 Sumário

- [Tecnologias](#tecnologias)
- [Como Executar](#como-executar)
- [Endpoints](#endpoints)
  - [Cervejarias (Brewery)](#cervejarias-brewery)
  - [Cervejas (Beer)](#cervejas-beer)
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
- Spring Cache
- Spring Actuator
- SpringDoc OpenAPI (Swagger)
- Lombok
- Maven

---

## 🚀 Como Executar

### Pré-requisitos
- JDK 17 instalado

### Passos

```bash
# Clone o repositório
git clone https://github.com/FeKiModesto/Trabalhos_Java.git

# Entre na pasta do projeto
cd Trabalhos_Java/cervejaria

# Execute a aplicação
./mvnw spring-boot:run
```
## 📍 Endpoints

🏭 Cervejarias (Brewery)

| Método | Endpoint | Descrição | Testar no |
|--------|----------|-----------|-----------|
| GET | `/breweries` | Lista todas as cervejarias | 🌐 Web / 📮 Postman |
| GET | `/breweries/{id}` | Busca cervejaria por ID | 🌐 Web / 📮 Postman |
| POST | `/breweries` | Cadastra nova cervejaria | 📮 Postman |
| PUT | `/breweries/{id}` | Atualiza cervejaria | 📮 Postman |
| DELETE | `/breweries/{id}` | Remove cervejaria | 📮 Postman |

**Exemplo de corpo (POST/PUT):**
```json
{
  "name": "Colorado",
  "country": "Brasil"
}
```
## 🔧 Extras

| Tipo | Endpoint | Descrição | Testar no |
|------|----------|-----------|-----------|
| 📄 Documentação | `/swagger-ui.html` | Interface Swagger UI | 🌐 Web (navegador) |
| 🗄️ Banco de dados | `/h2-console` | Console H2 | 🌐 Web (navegador) |
| 💚 Health Check | `/actuator/health` | Status da aplicação | 🌐 Web / 📮 Postman |
| ℹ️ Informações | `/actuator/info` | Metadata da aplicação | 🌐 Web / 📮 Postman |
| 🗃️ Caches | `/actuator/caches` | Gerenciamento de cache | 🌐 Web / 📮 Postman |

**Configuração H2 Console:**
- JDBC URL: `jdbc:h2:mem:beerguidedb`
- User Name: `sa`
- Password: (vazio)

---

## 📊 Dados Iniciais (MockData)

### Cervejarias (3)

| ID | Nome | País |
|----|------|------|
| 1 | Primavera IPA | Brasil |
| 2 | Rio Negro | Brasil |
| 3 | Vale Verde | Brasil |

### Cervejas (6+)

| ID | Nome | Teor | Harmonização | Cervejaria |
|----|------|------|--------------|------------|
| 1 | Primavera IPA | 6.5% | Frango grelhado, queijos | Primavera IPA |
| 2 | Serra Alta IPA | 6.8% | Carnes vermelhas | Primavera IPA |
| 3 | Noite Stout | 7.2% | Chocolate amargo | Rio Negro |
| 4 | Rio Negro Stout | 7.5% | Sobremesas | Rio Negro |
| 5 | Lager do Sol | 4.8% | Petiscos, saladas | Vale Verde |
| 6 | Vale Verde Pilsen | 5.0% | Frutos do mar | Vale Verde |

---

## 📮 Testando no Postman

### Configuração Base

| Configuração | Valor |
|--------------|-------|
| **Base URL** | `http://localhost:8080` |
| **Headers** | `Content-Type: application/json` |

## Exemplos de Requisições

Criar uma cervejaria (POST)
```bash
POST http://localhost:8080/breweries
{
  "name": "Bodebrown",
  "country": "Brasil"
}
```

Criar uma cerveja (POST)
```bash
POST http://localhost:8080/beers
{
  "name": "Cacau IPA",
  "description": "IPA com notas de cacau",
  "alcoholContent": 7.0,
  "harmonization": "Chocolate amargo",
  "breweryId": 1
}
```

Listar cervejas de uma cervejaria (GET)
```bash
GET http://localhost:8080/beers/brewery/1
```

Atualizar cervejaria (PUT)
```bash
PUT http://localhost:8080/breweries/1
{
  "name": "Colorado Atualizada",
  "country": "Brasil"
}
```

Deletar cerveja (DELETE)
```bash
DELETE http://localhost:8080/beers/7
```

---

## 📌 Resumo: O que testar em cada ferramenta

| Ferramenta | O que testar |
|------------|--------------|
| **Navegador** | Swagger UI (`/swagger-ui.html`), H2 Console (`/h2-console`), endpoints GET |
| **Postman** | Todos os endpoints (GET, POST, PUT, DELETE) |

---

## 👨‍🎓 Autor
- Nome: Felipe Kirschner Modesto
- Email: fekimodesto04@gmail.com
