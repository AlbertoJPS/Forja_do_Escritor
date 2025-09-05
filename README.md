# Forja do Escritor - API

## 📝 Descrição

Esta é a API REST para o projeto "Forja do Escritor", uma plataforma para organização e compartilhamento de obras literárias. Este projeto foi desenvolvido com foco em qualidade de código, robustez, persistência de dados com um banco relacional e cobertura de testes automatizados.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA** (com Hibernate)
- **PostgreSQL** (Banco de Dados Relacional)
- **Maven** (Gerenciador de Dependências)
- **JUnit 5** (para testes de unidade e integração)
- **Lombok** (para redução de boilerplate)
- **Spring Validation** (para validação de dados de entrada)

---

## 🛠️ Como Executar

### Pré-requisitos

- **JDK 17** instalado e configurado.
- **Maven** (já incluído no projeto através do Maven Wrapper `mvnw`).
- **PostgreSQL** instalado e rodando.
- Um banco de dados criado no PostgreSQL chamado `forja_do_escritor_db`.

### Configuração da Senha

A aplicação espera a senha do banco de dados através de uma propriedade de sistema chamada `DB_PASSWORD`.

**1. Para Executar no VS Code (Recomendado):**
   - Crie/edite o arquivo `.vscode/launch.json`.
   - Na sua configuração de lançamento, adicione a propriedade `vmArgs` para passar a senha:
     ```json
     "vmArgs": "-DDB_PASSWORD=sua_senha_aqui"
     ```

**2. Para Executar Manualmente (via Terminal):**
   - Passe a senha diretamente na linha de comando:
     ```bash
     java -DDB_PASSWORD=sua_senha_aqui -jar target/api-0.0.1-SNAPSHOT.jar
     ```

### Rodando a Aplicação (Depois de Configurar a Senha)

Com a senha configurada, você pode iniciar a aplicação.

- **Pelo VS Code:** Clique no botão "Run" na classe `ApiApplication.java`.
- **Pelo Terminal:**
  ```bash
  ./mvnw spring-boot:run
  ```
A API estará disponível em `http://localhost:8080`.

### Rodando os Testes

Os testes também precisam da senha. A forma mais fácil é passar como uma variável de ambiente no terminal:

**No PowerShell (Windows):**
```powershell
$env:DB_PASSWORD="sua_senha_aqui"; ./mvnw.cmd clean test
```

**No Bash (Linux/macOS):**
```bash
DB_PASSWORD="sua_senha_aqui" ./mvnw clean test
```

---

## 📖 Endpoints da API

### 1. Criar Nova Obra

- **URL:** `/obras`
- **Método:** `POST`
- **Corpo da Requisição (JSON):**
  ```json
  {
    "titulo": "Um Título Válido",
    "autor": "Um Autor Válido",
    "pseudonimo": "Opcional",
    "descricao": "Opcional"
  }
  ```
- **Resposta de Sucesso (`201 Created`):**
  ```json
  {
    "id": "c2a9a7b9-6202-4b34-8c47-785a9d8253d5",
    "titulo": "Um Título Válido",
    "autor": "Um Autor Válido",
    "pseudonimo": "Opcional",
    "descricao": "Opcional"
  }
  ```
- **Resposta de Falha (`400 Bad Request`):** Retorna um erro se as regras de validação (ex: título em branco) não forem atendidas.

### 2. Listar Todas as Obras

- **URL:** `/obras`
- **Método:** `GET`
- **Resposta de Sucesso (`200 OK`):**
  ```json
  [
    {
      "id": "c2a9a7b9-6202-4b34-8c47-785a9d8253d5",
      "titulo": "Um Título Válido",
      "autor": "Um Autor Válido",
      "pseudonimo": "Opcional",
      "descricao": "Opcional"
    }
  ]
  ```