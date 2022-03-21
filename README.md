<div align="center">

![](https://img.shields.io/badge/Status-Em%20Desenvolvimento-orange)
</div>

<div align="center">

# POC - Ports & Adapters Architecture ou Arquitetura Hexagonal
![](https://img.shields.io/badge/Autor-Wesley%20Oliveira%20Santos-brightgreen)
![](https://img.shields.io/badge/Language-java-brightgreen)
![](https://img.shields.io/badge/Framework-springboot-brightgreen)
![](https://img.shields.io/badge/Arquitetura-Hexagonal-brightgreen)
</div>

## Fundamentos teóricos

> DynamoDB: Amazon DynamoDB é um serviço de banco de dados NoSQL proprietário totalmente gerenciado que oferece suporte a estruturas de dados de documentos e valores-chave e é oferecido pela Amazon.com como parte do portfólio da Amazon Web Services.

> Springboot: O Spring Boot é um projeto da Spring que veio para facilitar o processo de configuração e publicação de nossas aplicações. A intenção é ter o seu projeto rodando o mais rápido possível e sem complicação.

> Java: Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90 por uma equipe de programadores chefiada por James Gosling, na empresa Sun Microsystems. Em 2008 o Java foi adquirido pela empresa Oracle Corporation.


## Tecnologias
- Java 11
- Spring Boot 2.6.4
    - spring-boot-starter-web
    - spring-boot-starter-data-jpa
    - spring-boot-devtools
- Lombok
- DynamoDB
- springdoc-openapi-ui
- Tomcat (Embedded no Spring Boot)
- Git

## Execução

- Scripts
  ### Executar docker-compose
    - 1° comando: ``` cd src/main/docker/```
    - 2° comando: ```docker-compose -f docker-compose.yml up```
  ### Executar a aplicação
    -  ```./mvnw clean compile spring-boot:run```
  ### Executar testes
    - ```./mvnw clean compile verify sonar:sonar```


- Observação: 
  - Pasta init-scripts é pasta que onde contem os scripts excutados pela imagem do aws-cli
  - Pasta resources é pasta que onde contem os json cria a tabelas e faz inserts na tabela
    - CT (Create table) - Criar tabela
    - BWI (Batch write items) - Gravar itens em lote

## Comandos utils AWS CLI - DynamoDB

### Criar tabela


### Criar tabela com arquivo json (excecutar dentro da pasta do arquivo json)
```aws dynamodb create-table --cli-input-json file://nome-arquivo.json --endpoint-url  http://localhost:8000```

### Deletar tabelas
```aws dynamodb delete-table --table-name tb_person --endpoint-url  http://localhost:8000```

### Listar tabelas
```aws dynamodb list-tables --endpoint-url http://localhost:8000```

### Listar itens de uma tabela
```aws dynamodb --table-name tb_person --endpoint-url http://localhost:8000```

### Inserir dados na tabela
``` shell
aws dynamodb put-item \
    --table-name tb_person \
    --item '{"id": {"S": "1053fdc67-b2a5-45b4-96a7-d7f23575c805"}, "cpf": {"S": "70582698820"}, "email": {"S": "isabela.arruda@geradornv.com.br"}, "name": {"S": "Isabela Mata de Arruda"}, "dateOfBirth": {"S":"1981-03-01"}}' \
--endpoint-url http://localhost:8000
```


### 

# Utilização

## OpenAPI - api-docs
http://localhost:8080/ms-person/v3/api-docs
