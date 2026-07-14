# Sentinel - Asset Inventory

Sentinel é uma aplicação Java para gerenciamento de ativos de TI.

O projeto começou como um sistema simples de inventário de assets via terminal e está sendo evoluído gradualmente para uma plataforma mais completa de Asset Management com contexto de Segurança da Informação.

Nesta fase, o objetivo principal foi construir uma base sólida utilizando Java, Programação Orientada a Objetos, JDBC, PostgreSQL, Maven, Git e uma arquitetura simples em camadas.

---

## Sobre o projeto

O Sentinel simula um sistema utilizado por um departamento de tecnologia para controlar computadores, notebooks, servidores e outros equipamentos de uma organização.

A aplicação permite cadastrar, listar, buscar, atualizar e remover ativos de TI, armazenando os dados em um banco PostgreSQL.

Além dos dados básicos de inventário, o projeto já possui alguns campos que preparam a aplicação para futuras funcionalidades relacionadas à segurança, como status do ativo, localização, último usuário logado, data de compra e última vez em que o ativo foi visto.

---

## Objetivo de aprendizado

Este projeto faz parte da minha transição de carreira para a área de tecnologia, com foco em desenvolvimento backend Java e evolução futura para cybersecurity.

Durante o desenvolvimento, o objetivo foi praticar:

* Java
* Programação Orientada a Objetos
* Separação de responsabilidades
* Arquitetura em camadas
* JDBC
* PostgreSQL
* Maven
* SQL
* Tratamento de exceções
* Git e GitHub
* Boas práticas iniciais de organização de projeto

---

## Funcionalidades atuais

A versão atual permite:

* Cadastrar novos ativos
* Listar todos os ativos
* Buscar ativo por ID
* Atualizar informações de um ativo
* Remover ativo
* Selecionar status do ativo
* Registrar localização física/lógica
* Registrar último usuário logado
* Registrar data de compra
* Registrar última vez em que o ativo foi visto
* Persistir dados em PostgreSQL
* Configurar conexão com o banco por variáveis de ambiente

---

## Modelo atual de Asset

Cada ativo possui os seguintes campos:

* `id`
* `hostname`
* `ip`
* `operatingSystem`
* `manufacturer`
* `model`
* `responsible`
* `status`
* `location`
* `lastLoggedUser`
* `purchaseDate`
* `lastSeen`

---

## Status do ativo

O status do ativo é representado por um enum chamado `AssetStatus`.

Valores disponíveis:

* `ACTIVE`
* `INACTIVE`
* `MAINTENANCE`
* `LOST`
* `DISPOSED`

Esses status ajudam a evitar inconsistências de digitação e tornam o sistema mais próximo de um cenário real de inventário.

Exemplo:

Em vez de permitir valores livres como `ativo`, `Active`, `ATIVO` ou `em uso`, o sistema trabalha apenas com opções controladas.

---

## Campos com contexto de segurança

Alguns campos foram adicionados pensando em futuras evoluções do Sentinel para uma aplicação com contexto de Segurança da Informação.

### `lastLoggedUser`

Registra o último usuário associado ao ativo.

Esse campo pode ser útil futuramente para investigações, correlação com logs e identificação de uso indevido.

### `lastSeen`

Registra a última vez em que o ativo foi visto ou observado.

Na versão atual, esse valor é informado manualmente. Em uma versão futura, poderá ser atualizado automaticamente por um agente, scanner de rede, integração com logs ou ferramenta de monitoramento.

Exemplos de uso futuro:

* Ativo marcado como `ACTIVE`, mas não visto há mais de 30 dias
* Ativo marcado como `DISPOSED`, mas ainda aparecendo na rede
* Máquina não observada recentemente por scanner ou agente
* Inconsistência entre inventário e ambiente real

### `purchaseDate`

Registra a data de compra ou aquisição do ativo.

Esse campo é mais relacionado a ciclo de vida e gestão de ativos do que a alertas de SOC diretamente. Futuramente, poderá ajudar em relatórios de equipamentos antigos, ativos próximos de substituição e análise de risco quando combinado com outros dados, como sistema operacional sem suporte, vulnerabilidades abertas ou exposição na rede.

---

## Tecnologias utilizadas

* Java
* Maven
* JDBC
* PostgreSQL
* SQL
* Git
* GitHub
* IntelliJ IDEA

---

## Conceitos aplicados

Durante o desenvolvimento foram praticados:

* Classes e objetos
* Encapsulamento
* Construtores
* Getters e setters
* Enums
* Separação entre camadas
* Uso de repository
* Uso de service
* Uso de interface via terminal
* Conexão com banco de dados
* PreparedStatement
* ResultSet
* Try-with-resources
* Conversão entre tipos Java e tipos SQL
* Variáveis de ambiente para configuração sensível
* Tratamento de exceções
* Versionamento com Git

---

## Arquitetura atual

O projeto segue uma arquitetura simples em camadas:

```text
MainJava
   ↓
MainMenu
   ↓
AssetService
   ↓
AssetRepository
   ↓
DatabaseConnection
   ↓
PostgreSQL
```

### Responsabilidades das camadas

* `model`: representa as entidades do sistema
* `ui`: controla a interação com o usuário via terminal
* `service`: concentra regras de negócio e validações
* `repository`: executa operações SQL e comunicação com o banco
* `database`: centraliza a conexão com o PostgreSQL
* `MainJava`: inicializa a aplicação

---

## Estrutura do projeto

```text
src/main/java/br/com/marlon/inventory
├── MainJava.java
├── database
│   └── DatabaseConnection.java
├── model
│   ├── Asset.java
│   └── AssetStatus.java
├── repository
│   └── AssetRepository.java
├── service
│   └── AssetService.java
└── ui
    └── MainMenu.java
```

---

## Banco de dados

O projeto utiliza PostgreSQL.

Nome sugerido do banco:

```sql
sentinel
```

### Script da tabela `assets`

```sql
CREATE TABLE assets (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    hostname VARCHAR(50),
    ip VARCHAR(20),
    operating_system VARCHAR(50),
    manufacturer VARCHAR(50),
    model VARCHAR(50),
    responsible VARCHAR(50),
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    location VARCHAR(100),
    last_logged_user VARCHAR(100),
    purchase_date DATE,
    last_seen TIMESTAMP
);
```

---

## Variáveis de ambiente

A conexão com o banco utiliza variáveis de ambiente para evitar credenciais hardcoded no código.

Variáveis necessárias:

```text
DB_URL
DB_USER
DB_PASSWORD
```

Exemplo:

```text
DB_URL=jdbc:postgresql://localhost:5432/sentinel
DB_USER=postgres
DB_PASSWORD=your_password
```

---

## Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/marlonbrunotech/asset-inventory.git
```

### 2. Acesse a pasta do projeto

```bash
cd asset-inventory
```

### 3. Configure o PostgreSQL

Crie o banco:

```sql
CREATE DATABASE sentinel;
```

Crie a tabela `assets` usando o script disponível na seção de banco de dados.

### 4. Configure as variáveis de ambiente

Exemplo no terminal:

```bash
export DB_URL=jdbc:postgresql://localhost:5432/sentinel
export DB_USER=postgres
export DB_PASSWORD=your_password
```

### 5. Compile o projeto com Maven

```bash
mvn clean compile
```

### 6. Execute a aplicação

Execute a classe principal:

```text
MainJava
```

---

## Exemplo de menu

```text
====================================
         ASSET INVENTORY
====================================
1 - Register Asset
2 - List Assets
3 - Find Asset
4 - Update Asset
5 - Delete Asset
0 - Exit
------------------------------------
Choose an Option:
```

---

## Estado atual do projeto

A fase atual do projeto está focada em consolidar fundamentos com Java, JDBC e PostgreSQL.

Nesta etapa, o sistema já possui:

* CRUD completo
* Persistência em PostgreSQL
* Uso de Maven
* Conexão com banco por variáveis de ambiente
* Modelo de asset mais realista
* Campos com preparação para contexto futuro de segurança

Esta fase representa a base manual do sistema antes da migração para Spring Boot.

---

## Próximos passos

A próxima grande etapa será migrar o projeto para Spring Boot.

Objetivo da próxima fase:

Transformar o Sentinel de uma aplicação console em uma API REST com PostgreSQL.

## Observação sobre delete

Atualmente, a opção de delete remove o ativo fisicamente do banco de dados.

Em uma aplicação real de inventário, essa abordagem provavelmente seria substituída por uma estratégia de soft delete, desativação ou mudança de status para `DISPOSED`, preservando o histórico do ativo.

Nesta fase, o delete físico foi mantido para fins de aprendizado do CRUD completo.

---

## Demonstração

Abaixo está uma demonstração da aplicação em execução:

```text
assets/asset-inventory-demo.png
```

---

## Status

Fase atual:

```text
Java Console + JDBC + PostgreSQL concluída
```

Próxima fase:

```text
Migração para Spring Boot REST API
```

---

## Autor

Projeto desenvolvido por Marlon Bruno como parte da jornada de aprendizado em desenvolvimento de software, com foco futuro em backend Java, desenvolvimento full stack e Segurança da Informação.
