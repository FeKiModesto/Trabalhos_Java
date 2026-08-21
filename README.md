# Trabalhos_Java

Repositório para armazenar e versionar os trabalhos desenvolvidos em aula para a disciplina de **Java Advanced** na FIAP, organizados por semestre.

---

## Estrutura do Repositório
```bash
Trabalhos_Java/
├── 1º Semestre/
│ ├── ValidacaoPersonagem/
│ ├── cervejaria/
│ ├── games/
│ └── README.md
├── 2º Semestre/
│ ├── myPass/
│ ├── carSale/
│ └── README.md
└── README.md
```

---

## Semestres

- 📁 [1º Semestre](./1º%20Semestre) — projetos desenvolvidos no primeiro semestre
- 📁 [2º Semestre](./2º%20Semestre) — projetos desenvolvidos no segundo semestre

---

## Como Executar os Projetos

### Pré-requisitos

- **JDK 17** instalado
- **Maven** ou **Gradle** (cada projeto usa o wrapper incluído na pasta)

### Projetos Gradle (myPass)

```bash
# Entre na pasta do projeto
cd "Trabalhos_Java/2º Semestre/myPass"

# Execute
./gradlew bootRun
# No Windows:
gradlew.bat bootRun
```

### Projetos Maven (carSale e 1º Semestre)

```bash
# Entre na pasta do projeto
cd "Trabalhos_Java/2º Semestre/carSale/carsale-api"

# Execute
./mvnw spring-boot:run
# No Windows:
mvnw.cmd spring-boot:run
```

### Acesse a API

```
http://localhost:8080
```

---

## Autor

- **Nome:** Felipe Kirschner Modesto
- **Email:** fekimodesto04@gmail.com
