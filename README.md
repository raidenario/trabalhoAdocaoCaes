# Plataforma de Adoção de Cães 🐶

Este projeto é um trabalho acadêmico desenvolvido para a disciplina de **Programação Orientada a Objetos (POO)**. Trata-se de uma aplicação simples de linha de comando (CLI) para gerenciar a adoção de cães.

## Funcionalidades

*   **Listar cães disponíveis:** Exibe todos os cães atualmente disponíveis para adoção.
*   **Cadastrar novo cão:** Permite que um usuário (simulando um administrador) adicione novos cães ao sistema.
*   **Agendar adoção:** Registra o interesse de um usuário em adotar um cão específico, agendando a adoção.
*   **Listar adoções:** Mostra todas as adoções agendadas, concluídas ou canceladas.
*   **Cancelar adoção:** Permite o cancelamento de uma adoção agendada.
*   **Concluir adoção:** Marca uma adoção como concluída.

## Tecnologias Utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias:

*   **Java 17:** Linguagem de programação principal.
*   **Spring Boot:** Framework para facilitar a criação de aplicações Java.
    *   **Spring Data JPA:** Para interagir com o banco de dados.
    *   **Spring Shell:** Para criar a interface de linha de comando (CLI) interativa.
*   **Maven:** Ferramenta de gerenciamento de dependências e build do projeto.
*   **H2 Database:** Banco de dados em memória para desenvolvimento e testes.
*   **Flyway:** Ferramenta para controle de versão do banco de dados (migrations).
*   **Lombok:** Biblioteca para reduzir a verbosidade do código Java (ex: getters, setters, construtores).

## Como Executar

1.  **Pré-requisitos:**
    *   JDK 17 ou superior instalado.
    *   Maven instalado.
2.  **Clone o repositório:**
    ```bash
    git clone URL_DO_SEU_REPOSITORIO
    cd nome-do-repositorio
    ```
3.  **Compile e execute a aplicação:**
    ```bash
    mvn spring-boot:run
    ```
4.  **Interaja com o menu:**
    *   Após a inicialização, digite o comando `menu` no terminal para acessar as opções interativas.

## Banco de Dados (H2 Console)

Durante a execução, você pode acessar o console web do H2 para visualizar os dados:

*   **URL:** `http://localhost:8080/h2-console`
*   **JDBC URL:** `jdbc:h2:file:./adocao_db`
*   **Username:** `sa`
*   **Password:** `password`

## Próximos Passos (Sugestões)

*   Implementar uma interface gráfica (JavaFX, Swing, etc.).
*   Adicionar testes unitários e de integração.
*   Implementar autenticação e autorização (separar usuários comuns de administradores).
*   Utilizar um banco de dados mais robusto (PostgreSQL, MySQL) para produção.
*   Melhorar o tratamento de erros e validações.
