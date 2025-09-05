# Forja do Escritor - API

## 📝 Descrição

Esta é a API REST para o projeto "Forja do Escritor", uma plataforma para organização e compartilhamento de obras literárias. Este projeto foi desenvolvido com foco em qualidade de código, robustez e cobertura de testes automatizados.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Maven**
- **JUnit 5** (para testes de unidade e integração)
- **Lombok**
- **Spring Validation**

---

## 🛠️ Como Executar

### Pré-requisitos

- JDK 17
- Maven

### Rodando a Aplicação

No terminal, na pasta raiz do projeto, execute o seguinte comando:

```bash
./mvnw spring-boot:run
```
A API estará disponível em http://localhost:8080.

Rodando os Testes
Para executar a suíte completa de testes automatizados, use o comando:

```bash
./mvnw test
```

Endpoints da API
1. Criar Nova Obra
URL: /obras

Método: POST

Corpo da Requisição (JSON):

```json
{
  "titulo": "Um Título Válido",
  "autor": "Um Autor Válido",
  "pseudonimo": "Opcional",
  "descricao": "Opcional"
}
```

Resposta de Sucesso (201 Created):

```json
{
  "id": "c2a9a7b9-6202-4b34-8c47-785a9d8253d5",
  "titulo": "Um Título Válido",
  "autor": "Um Autor Válido",
  "pseudonimo": "Opcional",
  "descricao": "Opcional"
}
```

Resposta de Falha (400 Bad Request): Retorna um erro se as regras de validação (ex: título em branco) não forem atendidas.

2. Listar Todas as Obras
URL: /obras

Método: GET

Resposta de Sucesso (200 OK):

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

