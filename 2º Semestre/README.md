# 2º Semestre

Projetos desenvolvidos durante o segundo semestre da disciplina de Java Advanced na FIAP.

---

## Projetos

### MyPass
API REST para gerenciamento seguro de senhas com autenticação JWT via RSA. Integra com o front-end [MyPass Web](https://github.com/joaocarloslima/mypass).

**Endpoints:**
- `POST /login` — autentica o usuário e retorna um token JWT
- `GET /pass` — retorna todas as senhas salvas (requer autenticação)
