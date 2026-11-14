# Product Stock Management System

A Java Spring Boot REST API project designed to manage product stock information and calculate category-wise and size-wise inventory details.

## About the Project

Product Stock Management is a backend application developed using Java and Spring Boot.

It allows users to add products, retrieve product details by ID, delete products, and view total stock information for Shirts and Pants.

The application uses Java Stream API to calculate stock summaries based on product categories and sizes.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- REST API
- Postman

## Features

- Add new products
- Retrieve product details by ID
- Delete products by ID
- Calculate total shirt stock
- Calculate total pant stock
- View size-wise stock details
- Category-based inventory calculation

## Project Structure

```text
src/main/java/com/example/mensware/
│
├── Controller/
│   └── ProductController.java
│
├── Entity/
│   └── Product.java
│
├── Repository/
│   └── ProductRepository.java
│
├── Service/
│   └── ProductService.java
│
└── MenswareApplication.java
```

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | /MansWare | Add a product |
| GET | /MansWare/{id} | Get product by ID |
| DELETE | /MansWare/{id} | Delete product |
| GET | /MansWare/stock | Get stock summary |
| GET | /MansWare/test | Test API status |

## Sample JSON Request

```json
{
  "category": "SHIRT",
  "brand": "Peter England",
  "price": 899,
  "size": "M",
  "stock": 25
}
```

## Database Configuration

This project uses MySQL.

1. Create a MySQL database named `mensware`.
2. Configure your database username and password in `application.properties`.
3. Use the provided `application-example.properties` as a configuration reference.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mensware
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## How to Run

1. Clone this repository.
2. Open the project in IntelliJ IDEA.
3. Configure the MySQL database.
4. Update the database credentials.
5. Run `MenswareApplication.java`.
6. Test the REST APIs using Postman.

## Developer

**Manimaran**

Java Backend Developer | B.Sc Computer Science

GitHub: https://github.com/maran2
