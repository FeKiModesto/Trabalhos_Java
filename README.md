# 📚 Trabalhos_Java

Este repositório tem como finalidade armazenar e versionar os trabalhos desenvolvidos em aula para a disciplina de **Java**, facilitando o acompanhamento do progresso, a organização dos códigos e o compartilhamento com colegas e professores.

---

## 🗂️ Estrutura do Projeto 
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
│   └── (API de Jogos - Spring Boot com HATEOAS)
│
└── README.md
```

---

## 🚀 Como Executar os Projetos (Spring Boot)

1. Certifique-se de ter o **JDK 17** instalado.
2. Clone o repositório:
   ```bash
   git clone https://github.com/FeKiModesto/Trabalhos_Java.git
   ```

3. Navegue até a pasta do projeto desejado.
	```bash
 	cd ValidacaoPersonagem
 	# ou
 	cd cervejaria
 	# ou
 	cd games
 	```
 
4. Execute com Maven:
  ```bash
	./mvnw spring-boot:run
  ```
| No Windows: mvnw.cmd spring-boot:run

5. Acesse a API:
```bash
http://localhost:8080
```

## 📌 Projetos Disponíveis
1. ValidacaoPersonagem
API para criação e validação de personagens de jogo (CRUD completo).

2. Cervejaria
API para gerenciamento de estilos e cervejarias (CRUD completo com cache, documentação e observabilidade).

3. Games
API para gerenciamento de jogos com HATEOAS (Hypermedia as the Engine of Application State).

## 📌 Próximos Passos
- Adicionar novos trabalhos realizados em aula.
- Incluir testes automatizados para os códigos.
- Refatorar e documentar melhor as classes conforme os conceitos forem avançando (POO, herança, interfaces, etc.).

## 👨‍🎓 Autor
- Nome: Felipe Kirschner Modesto  
- Email: fekimodesto04@gmail.com  
