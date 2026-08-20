# 2º Semestre

Projetos do segundo semestre (Java Advanced - FIAP).

---

## Projetos

### MyPass
API REST Spring Boot/Gradle (H2) para gestão de senhas com JWT/RSA e Spring Security.

**Endpoints:**
- `POST /login` — Autenticação (token 10min)
- `GET /pass` — Listar senhas (autenticado)

### CarSale
API REST Spring Boot/Maven baseada no projeto do Prof. João Carlos Lima, focada em segurança, controle de acesso (Roles/`@EnableMethodSecurity`) e `BCryptPasswordEncoder`.

**Endpoints:**
- `GET /cars`, `GET /cars/**`, `GET /comments` — Público (visualização)
- `POST /login` — Autenticação e geração de JWT
- `POST /comments` — Privado (autenticado)
- `DELETE /comments/**` — Restrito (`ROLE_ADMIN`)

---

> 💡 *Consulte o `README.md` de cada projeto para detalhes.*
