# Finanças API

Finanças API é uma aplicação RESTful desenvolvida em **Java 21** com **Spring Boot**, destinada a gerenciar movimentações financeiras e suas categorias. A API fornece dados para um frontend construído com **Angular 20**.

## Funcionalidades

- CRUD de **movimentações financeiras**.
- CRUD de **categorias** de movimentações.
- Integração com **RabbitMQ** para mensageria.
- Documentação interativa via **Swagger** e **Scalar**.
- Carregamento inicial de dados por meio de um `DataLoader`.

## Arquitetura

O projeto segue arquitetura em camadas:

- **application**: Controllers da API.
- **domain**:
    - `entities` – Modelos do banco.
    - `dtos` – Objetos de transferência de dados (requests e responses).
    - `interfaces` – Contratos de serviço.
    - `services` – Implementações de negócios.
- **infrastructure**:
    - `repositories` – Acesso a dados via JPA.
    - `configurations` – Configurações de Swagger e RabbitMQ.
    - `components` – Componentes auxiliares (ex.: RabbitMQWorker, OpenAIComponent).
    - `runners` – Inicialização de dados.

## Tecnologias

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **RabbitMQ**
- **Swagger & Scalar**
- **Maven**
- **PostgreSQL**
- **Docker** (para aplicação e banco de dados)

## Banco de Dados

O banco de dados está executando em um **container Docker**, facilitando o ambiente isolado e reproduzível.

## Mensageria

Mensageria é feita com **RabbitMQ**, também em container Docker, permitindo comunicação assíncrona para processamento de eventos.

## Como Executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/a-devrepo/financasapi
   cd financas-api
   ```

2. Inicie os containers:

   ```bash
   docker-compose up -d
   ```

3. Execute a aplicação via Maven:

   ```bash
   ./mvnw spring-boot:run
   ```

4. Acesse a documentação da API:

    - Swagger: `http://localhost:8082/swagger-ui.html`
    - Scalar: `http://localhost:8082/scalar`