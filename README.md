# Personal Finance Control API

REST API built with Java and Spring Boot to manage personal income and
expenses and calculate balance.

## 🚀 Technologies

-   Java 17
-   Spring Boot
-   Spring Web
-   Spring Data JPA
-   H2 Database
-   Maven

## 📦 Features

-   Create income and expense transactions
-   List all transactions
-   Calculate balance

## 📌 Domain Rules

-   Transaction amount must be greater than zero
-   Income adds to balance
-   Expense subtracts from balance

## ▶️ How to run

``` bash
mvn spring-boot:run
```

The API will be available at:

    http://localhost:8080

## 🔗 Endpoints

### Create transaction

**POST /transactions**

``` json
{
  "description": "Salary",
  "amount": 3000.00,
  "type": "INCOME",
  "date": "2026-02-01"
}
```

### List transactions

**GET /transactions**

### Get balance

**GET /transactions/balance**

## 🧪 Validation

Invalid requests return HTTP 400 with detailed field errors.

## 📄 License

This project is for study and portfolio purposes.
