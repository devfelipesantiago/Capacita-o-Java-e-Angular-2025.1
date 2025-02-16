# Capacita-o-Java-e-Angular-2025

# `Projeto contato de usuários`

Boas-vindas ao repositório do projeto `Projeto contato de usuários`

Este é um projeto desenvolvido com **Spring Boot** utilizando **MySQL** como banco de dados. O objetivo do projeto é fornecer uma API RESTful com documentação OpenAPI para fácil acesso aos recursos.

## Tecnologias Utilizadas

- **Backend**: Spring Boot
- **Banco de Dados**: MySQL
- **Documentação**: Swagger/OpenAPI

<details>
  <summary>O que deverá ser desenvolvido</summary><br />

O desafio consiste em criar uma aplicação API Rest para gerenciar um sistema de
cadastro de Pessoas e seus respectivos Contatos, onde cada Pessoa pode ter vários Contatos. O
principal objetivo é permitir que operações CRUD (Criar, Ler, Atualizar, Deletar) sejam realizadas
na estrutura de Pessoas e Contatos.

</details>

## Orientações

<details>

   <summary><strong>Para iniciar a aplicação </strong></summary>

1. Clone o repositório

- Use o comando: `git clone git@github.com:devfelipesantiago/Capacita-o-Java-e-Angular-2025.1.git`
- Entre na pasta do repositório que você acabou de clonar:
  - `cd mainsait`
- Instale as dependências:
  - `mvn clean install -DskipTests`
- Inicie o projeto com o comando:
  - `mvn spring-boot:run`

</details>

<details>

  <summary><strong>Para rodar os testes </strong></summary>

- Use o comando:
  - `mvn test`

</details>

<details>

  <summary><strong>Acessando a Documentação da API (Swagger/OpenAPI) </strong></summary>

- A documentação da API estará disponível através do Swagger. Após rodar a aplicação, você pode acessá-la diretamente pelo navegador em:

  - `http://localhost:8080/swagger-ui.html`

  ![alt text](<Captura de tela 2025-02-16 194900.png>)

</details>

<details>

  <summary><strong>Estrutura do Projeto </strong></summary>

- A estrutura do projeto segue o padrão de organização utilizando as camadas Model, Service, Controller, entre outras. Aqui está um resumo das pastas e arquivos mais importantes:

- **/src/main/java/com/exemplo/model**: Diretório que contém as `entidades JPA`, `repositórios`.
- **/src/main/java/com/exemplo/service**: Aqui ficam as classes de serviço, incluindo `exceções personalizadas`.
- **/src/main/java/com/exemplo/controller**: Diretório para os controladores `REST`, incluindo o tratamento global de exceções via `@ControllerAdvice` e os `DTOs`.
- **/src/main/resources**: Contém arquivos de configuração como `application.properties` e arquivos estáticos, se houver.
- **/src/test**: Diretório para os `testes` unitários e de integração.
- **/pom.xml**: Arquivo de configuração do Maven que gerencia dependências e configurações do projeto.

</details>
