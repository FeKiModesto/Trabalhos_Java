# CarSale

Projeto baseado no exercício **CarSale** da disciplina de Java Advanced na FIAP.

> ⚠️ Este repositório contém uma versão **modificada** do projeto original desenvolvido pelo professor [João Carlos Lima](https://github.com/joaocarloslima). As alterações feitas estão descritas abaixo.

---

## Repositórios de Referência

- 🍴 [Meu Fork do carsale-api](https://github.com/FeKiModesto/carsale-api) — Repositório onde realizei o fork para as alterações do back-end
- 🔗 [carsale-api (Original)](https://github.com/joaocarloslima/carsale-api) — Back-end original do professor
- 🔗 [carsale (Original)](https://github.com/joaocarloslima/carsale) — Front-end original do professor

---

## Sobre o Projeto

Aplicação web de venda de carros com sistema de comentários. O front-end exibe os carros disponíveis e permite que usuários autenticados deixem comentários. Administradores têm permissão adicional para remover comentários.

A aplicação é composta por duas partes:

- **carsale-api** — API REST em Spring Boot com autenticação JWT via RSA (baseada no meu fork modificado)
- **carsale** — Front-end em Next.js consumindo a API

---

## Alterações Realizadas

O projeto original não possuía controle de acesso nos endpoints nem um `PasswordEncoder` configurado. As seguintes alterações foram feitas no arquivo `SecurityConfig.java`:

- Adição do `BCryptPasswordEncoder` como `PasswordEncoder`
- Aplicação das regras de negócio por endpoint:
  - `GET /cars` e `GET /cars/**` — público
  - `GET /comments` — público
  - `POST /login` — público
  - `POST /comments` — requer autenticação
  - `DELETE /comments/**` — requer perfil `ROLE_ADMIN`
- Adição da anotação `@EnableMethodSecurity`
- Atualização dos hashes de senha no `data.sql` para senhas compatíveis com BCrypt

---

## Credenciais de Teste

| Usuário | Senha | Perfil |
|---|---|---|
| alice.smith | admin123 | ADMIN |
| bob.johnson | bob456 | USER |
| charlie.brown | charlie789 | USER |

---

## Como Executar a API

### Pré-requisitos
- JDK 17
- Maven

### Passos

```bash
# Entre na pasta da api
cd carSale/carsale-api

# Execute com Maven
./mvnw spring-boot:run

# Acesse em
# http://localhost:8080
```

Para rodar o front, siga as instruções no repositório original do professor.
