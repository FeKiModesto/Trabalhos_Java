# 📚 Trabalhos_Java

Este repositório armazena e versiona os trabalhos desenvolvidos em aula para a disciplina de **Java**, facilitando o acompanhamento do progresso, a organização dos códigos e o compartilhamento com colegas e professores.

---

## 🗂️ Estrutura do Repositório

```
Trabalhos_Java/
│
├── ValidacaoPersonagem/
│   └── (API de Validação de Personagens - Spring Boot)
│
├── cervejaria/
│   └── (API de Cervejaria - Spring Boot com Cache e Swagger)
│
├── games/
│   └── (API de Jogos - Spring Boot com HATEOAS + integração com front-end)
│
└── README.md
```

---

## 📌 Projetos Disponíveis

### 1. ValidacaoPersonagem
API para criação e validação de personagens de jogo com CRUD completo.

### 2. Cervejaria
API para gerenciamento de estilos e cervejarias com CRUD completo, cache, documentação Swagger e observabilidade.

### 3. Games
API REST para gerenciamento de jogos com **Spring HATEOAS**, paginação e integração com o front-end [GameFinder Web](https://github.com/joaocarloslima/gamefinder-web). Permite listar, filtrar por gênero e filtrar por plataforma, retornando hypermedia links em cada resposta.

---

## 🚀 Como Executar os Projetos

### Pré-requisitos
- **JDK 17** instalado
- **Maven** (ou usar o wrapper `mvnw` incluído em cada projeto)

### Passos

```bash
# 1. Clone o repositório
git clone https://github.com/FeKiModesto/Trabalhos_Java.git

# 2. Entre na pasta do projeto desejado
cd Trabalhos_Java/games
# ou: cd Trabalhos_Java/cervejaria
# ou: cd Trabalhos_Java/ValidacaoPersonagem

# 3. Execute com Maven
./mvnw spring-boot:run
# No Windows:
mvnw.cmd spring-boot:run

# 4. Acesse a API
# http://localhost:8080
```

---

## 📌 Próximos Passos
- Adicionar novos trabalhos realizados em aula.
- Incluir testes automatizados.
- Refatorar e documentar as classes conforme os conceitos avançam (POO, herança, interfaces, etc.).

---

## 👨‍🎓 Autor
- **Nome:** Felipe Kirschner Modesto
- **Email:** fekimodesto04@gmail.com
