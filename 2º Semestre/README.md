# 2º Semestre

Projetos desenvolvidos durante o segundo semestre da disciplina de Java Advanced na FIAP.

---

## Projetos

### MyPass
API REST desenvolvida em Spring Boot com Gradle e banco de dados H2 em memória. O projeto consiste em um gerenciador seguro de senhas com autenticação via JWT utilizando par de chaves RSA, sessão stateless e Spring Security. Possui integração com o front-end [MyPass Web](https://github.com/joaocarloslima/mypass).

**Endpoints:**
- `POST /login` — recebe as credenciais do usuário em JSON, valida e retorna um token JWT com validade de 10 minutos
- `GET /pass` — retorna todas as senhas armazenadas no banco, acessível apenas por usuários autenticados via Bearer token
