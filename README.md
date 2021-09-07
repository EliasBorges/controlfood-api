# ControlFood

#### FUNÇÃO
- `Gerenciador de estabelecimentos no setor alimentício.` Tem como objetivo auxiliar o empreendedor a entrar e permanecer neste mundo de deliveries, proporcionando dados do produto que permitem tomadas de decisão assertivas de forma rápida e inteligente.
- Sistema é contemplado pelas seguintes entidades:

1. USUÁRIO
    - Entidade responsável pelo gerenciamento de acessos ao sistema (Atualmente este acesso parte do pressuposto que apenas o Gerente tem acesso);

#### ESPECIFICAÇÃO DA IMPLEMENTAÇÃO

1. USUÁRIO
    - Nesta service temos um CRUD básico, sem nenhuma regra de negocio especifica.
      - **Métodos implementados:** `createUser` 
      - **Métodos previsto para implementação:** `alterUser - searchUserByEmail - deleteUser - findAllUsers`

#### ARQUITETURA DO PROJETO
![Arquitetura_ControlFood](https://user-images.githubusercontent.com/31020103/132262242-f3f547f5-d35e-45f4-a07c-1fb14b20bed4.png)

#### RELACIONAMENTOS - UML
![ControlFood](https://user-images.githubusercontent.com/31020103/132262056-45bbc93d-3b89-444a-b380-ce6395f41498.jpg)

#### PRINCIPAIS BIBLIOTECAS UTILIZADAS PARA EXECUÇÃO DO PROJETO:

* [MySQL Connector/J](https://mvnrepository.com/artifact/mysql/mysql-connector-java)
* [Spring Web](https://mvnrepository.com/artifact/org.springframework/spring-web)
* [Spring Boot Starter Data JPA](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)
* [Spring Boot DevTools](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools)
* [Hibernate Validator](https://hibernate.org/validator/)
* [Loombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)
* [Swagger](https://swagger.io/)
* [JUnit](https://mvnrepository.com/artifact/junit/junit)

#### AUTORES

- [Elias Borges](https://www.linkedin.com/in/eliasborges)
- [Ricardo](https://www.linkedin.com/in/)

