# Cambio Service

Este é um serviço que realiza a conversão de moedas com base em fatores de conversão armazenados em um banco de dados MySQL. Ele recebe uma quantidade de uma moeda de origem e converte para uma moeda de destino, utilizando um fator de conversão predefinido.

## Funcionalidades

- Consulta e realiza conversões entre moedas (ex: USD para BRL, EUR para USD, etc.).
- Exibe o valor convertido com base no fator de conversão.
- Retorna informações sobre o ambiente em que o serviço está sendo executado.

## Tecnologias Utilizadas

- **Spring Boot** - Framework para desenvolvimento da aplicação backend.
- **JPA (Java Persistence API)** - Para interação com o banco de dados.
- **MySQL** - Banco de dados que armazena os fatores de conversão.
- **REST** - Exposição da API utilizando o padrão RESTful.

## Endpoints

### `GET /cambio-service/{amount}/{from}/{to}`

Este endpoint recebe três parâmetros na URL:

- **amount**: Quantidade a ser convertida (ex: 100).
- **from**: Moeda de origem (ex: USD).
- **to**: Moeda de destino (ex: BRL).

#### Exemplo de Requisição

```http
GET http://localhost:8000/cambio-service/100/USD/BRL

```

#### Exemplo de Resposta

```
{
  "id": 1,
  "from": "USD",
  "to": "BRL",
  "conversionFactor": 5.81,
  "convertedValue": 581.00,
  "environment": "8000"
}
```

#### Campos da Resposta
- id: Identificador único do registro de câmbio.
- from: Moeda de origem.
- to: Moeda de destino.
- conversionFactor: Fator de conversão utilizado.
- convertedValue: Valor convertido.
- environment: Porta em que o serviço está sendo executado.

### Como Rodar
- Java 17 ou superior
- MySQL 5.7 ou superior

### Passos
1. Clone o repositório:

```
git clone https://github.com/seu-usuario/cambio-service.git
cd cambio-service

```

2. Configure o banco de dados MySQL:

- Crie um banco de dados cambio_service.

- Execute as migrações para criar a tabela cambio e popular os dados:
- 
```
CREATE TABLE `cambio` (
  `id` INT(10) AUTO_INCREMENT PRIMARY KEY,
  `from_currency` CHAR(3) NOT NULL,
  `to_currency` CHAR(3) NOT NULL,
  `conversion_factor` DECIMAL(65,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `cambio` (`from_currency`, `to_currency`, `conversion_factor`) VALUES
                     ('USD', 'BRL', 5.81),
                     ('USD', 'EUR', 0.94),
                     ('USD', 'GBP', 0.84),
                     ('USD', 'ARS', 350.30),
                     ('USD', 'CLP', 877.50),
                     ('USD', 'COP', 4014.75),
                     ('USD', 'MXN', 18.43);

```

3. Configure as credenciais de conexão do MySQL no arquivo application.yml:


```
server:
  port: 8000
spring:
  application:
    name: cambio-service
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/cambio_service?useTimezone=true&serverTimezone=UTC
    username: root
    password: admin123
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    open-in-view: false
  flyway:
    url: jdbc:mysql://localhost:3306/cambio_service
    schemas: cambio_service
    user: root
    password: admin123
    baseline-on-migrate: true
```

4. Execute a aplicação:

```
./mvnw spring-boot:run
```

### Testando a Aplicação
Após iniciar o serviço, você pode testar a conversão de moedas utilizando ferramentas como o Postman ou simplesmente um navegador. Por exemplo:

``` 
GET http://localhost:8000/cambio-service/100/USD/BRL

```
Se o serviço estiver funcionando corretamente, ele retornará um JSON com o valor convertido e o fator de conversão utilizado.
