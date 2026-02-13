# E-Commerce

## Sobre o projeto

## Status: em desenvolvimento

Este é um projeto ecommerce desenvolvido em Java com o foco em estruturar um sistema completo de loja online.

O projeto inclui backend configurado para servir funcionalidades comuns de ecommerce como produtos, usuários e carrinho de compras.

## Funcionalidades

- Listagem de produtos
- Carrinho de comppras
- CRUD de usuários
- Endpoints REST para interação

## Tecnologias utilizadas

- Java
- Spring Boot
- Docker
- PostgreSQL

## Como rodar o projeto
### Pré-requisitos

- Java JDK 21+
- Docker & Docker compose
- Configurar .env na pasta raíz do projeto

```bash
# Estrutura do .env

SPRING_DATASOURCE_URL=
SPRING_DATASOURCE_USERNAME=
SPRING_DATASOURCE_PASSWORD=
SPRING_JPA_HIBERNATE_DDL_AUTO=

POSTGRES_DB=
POSTGRES_USER=
POSTGRES_PASSWORD=
```

```bash
# Copiar o repositório
git clone https://github.com/0xCsr/e-commerce.git

# Entrar no diretório da pasta copiada
cd e-commerce

# Subir o SQL via docker
docker-compose up --build
```

Depois do docker subir o SQL, basta rodar a aplicação.
