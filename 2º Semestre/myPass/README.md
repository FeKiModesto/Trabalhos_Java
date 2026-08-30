# MyPass

Exercício da disciplina **Java Advanced** — 2º Semestre — FIAP.

O MyPass é uma API REST para gerenciamento de senhas. O usuário faz login com suas credenciais e recebe um token JWT que dá acesso à listagem de senhas cadastradas no sistema. A autenticação usa criptografia assimétrica RSA — o token é assinado com a chave privada e validado com a chave pública.

## Tecnologias

- Java 17
- Spring Boot 4.1.0 + Gradle
- Spring Security + OAuth2 Resource Server (JWT/RSA)
- Spring Data JPA
- H2 (banco em memória)
- Lombok

## Como rodar

```bash
./gradlew bootRun
```

A API sobe em `http://localhost:8080`.

O banco H2 já vem com 5 senhas de exemplo carregadas automaticamente via `data.sql`.

## Endpoints

### `POST /login`
Autentica o usuário e retorna um token JWT válido por **10 minutos**.

**Body:**
```json
{
  "username": "joao",
  "password": "123456"
}
```

**Resposta:**
```json
{
  "token": "eyJhbGciOiJSUzI1NiJ9...",
  "type": "Bearer",
  "username": "joao"
}
```

---

### `GET /pass`
Retorna todas as senhas cadastradas. Requer autenticação.

**Header:**
```
Authorization: Bearer SEU_TOKEN_AQUI
```

**Resposta:**
```json
[
  {
    "id": 1,
    "url": "https://example.com",
    "username": "johndoe",
    "password": "password123"
  }
]
```

## Usuários disponíveis

O sistema usa `InMemoryUserDetailsManager` — os usuários estão fixos no código, sem banco.

| Username | Password |
|----------|----------|
| `joao`   | `123456` |
| `maria`  | `123456` |

## Segurança

- `POST /login` — público
- Todo o resto — requer token JWT válido no header `Authorization: Bearer`
- Sessão stateless (sem cookies)
- As chaves RSA ficam em `src/main/resources/keys/` (`private_key.pem` e `public_key.pem`)
- Token expira em 10 minutos

## Estrutura do projeto

```
src/main/java/fiap/com/br/mypass/
├── auth/
│   ├── AuthController.java      # POST /login
│   ├── SecurityConfig.java      # configuração do Spring Security + RSA
│   └── TokenService.java        # geração do JWT
└── password/
    ├── Password.java            # entidade JPA
    ├── PasswordController.java  # GET /pass
    └── PasswordRepository.java  # acesso ao banco
```

## Autor
- Felipe Kirschner Modesto
