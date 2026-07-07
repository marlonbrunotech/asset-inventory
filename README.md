# Asset Inventory

Sistema de gerenciamento de assets de TI desenvolvido em Java.

## Sobre o projeto

O Asset Inventory é uma aplicação desenvolvida para simular um sistema utilizado por um departamento de tecnologia para controle de computadores e equipamentos de uma organização.

O objetivo do projeto é aplicar conceitos de desenvolvimento de software, criando uma base que futuramente poderá evoluir para uma solução corporativa envolvendo banco de dados, API REST, autenticação, autorização e funcionalidades relacionadas à segurança da informação.

## Funcionalidades atuais

* Cadastro de assets
* Listagem de assets
* Busca de assets por ID
* Atualização de informações
* Remoção de assets
* Menu interativo via terminal

## Modelo de asset

Cada equipamento possui informações como:

* ID
* Hostname
* IP
* Operating System
* Manufacturer
* Model
* Responsible

## Tecnologias utilizadas

* Java
* Programação Orientada a Objetos (POO)
* Collections
* Tratamento de exceções
* Git

## Conceitos aplicados

Durante o desenvolvimento foram praticados:

* Classes e objetos
* Encapsulamento
* Separação de responsabilidades entre camadas
* Manipulação de listas
* Controle de fluxo
* Versionamento utilizando Git

## Estrutura do projeto

O projeto foi organizado seguindo uma separação de responsabilidades:

* Model: entidades do sistema
* Service: regras de negócio
* Repository: gerenciamento dos dados
* UI: interação com o usuário

## Como executar

1. Clone o repositório:

```bash
git clone URL_DO_REPOSITORIO
```

2. Abra o projeto em uma IDE Java.

3. Execute a classe principal da aplicação.

## Roadmap de evolução

### Versão atual

* Aplicação Java via terminal
* CRUD de assets
* Armazenamento em memória

### Próximas versões

* Persistência em banco de dados
* API REST utilizando Spring Boot
* Interface web utilizando Angular
* Autenticação e autorização com controle de permissões
* Logs de auditoria
* Gestão de vulnerabilidades dos assets
* Funcionalidades voltadas para segurança da informação

## Objetivo

Este projeto faz parte da minha jornada de aprendizado em desenvolvimento de software, com foco futuro em cybersecurity.
