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

### Cripto Planner
Aplicação que analisa a variação de preço de criptomoedas nas últimas 24h (via API pública da CoinGecko) e devolve uma recomendação sobre comprar, vender ou investir.

### Board Vault
Catálogo de jogos de tabuleiro com API REST em Spring Boot, banco PostgreSQL via Docker e versionamento de schema com Flyway. O front-end consome dois endpoints para listar e detalhar jogos.

O projeto é dividido em duas partes:

- **`cripto-planner/`** — API REST em Spring Boot 4 com Gradle e Java 17. Usa Spring HTTP Interface (`@HttpExchange`) para consumir a CoinGecko sem precisar de RestTemplate ou WebClient na mão.
- **`cripto-web/`** — Front-end React + Vite (fork do projeto do Prof. João Carlos Lima). Exibe cards clicáveis para cada ação disponível e mostra a resposta da API na tela.

**Endpoint da API:**
- `GET /api/planner?activity={activity}`

**Atividades disponíveis:**

| Activity | Moeda | Lógica |
|---|---|---|
| `Comprar Bitcoin` | Bitcoin | Variação > 5% → não recomendado; < -5% → bom momento |
| `Vender Ethereum` | Ethereum | Variação < -5% → espere recuperação; > 5% → bom momento |
| `Investir em Dogecoin` | Dogecoin | \|variação\| > 10% → risco elevado |

**Exemplo de resposta:**
```json
{
  "result": "Bom momento para comprar Bitcoin, o preço caiu 6.2% nas últimas 24h."
}
```

---

> 💡 *Consulte o `README.md` de cada projeto para detalhes.*
