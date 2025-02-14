# Grocery Booking API

This is a simple Grocery Booking API built using **Spring Boot** and **PostgreSQL**.

## Features
- **Admin** can add, update, delete, and view grocery items.
- **User** can view grocery items and place orders.

## Tech Stack
- **Backend:** Spring Boot
- **Database:** PostgreSQL
- **Build Tool:** Maven

## Endpoints

### Grocery Endpoints
| Method | Endpoint                                  | Description                |
|--------|----------------------                     |----------------------------|
| GET    | `/api/admin/groceries`                   | Get all groceries         |
| POST   | `/api/admin/groceries`                    | Add a new grocery (Admin) |
| PUT    | `/api/admin/groceries/{id}`              | Update grocery (Admin)    |
| PUT    | `/api/admin/groceries/{id}/inventory`    | Update grocery inventory (Admin)    |
| DELETE | `/api/admin/groceries/{id}`              | Delete grocery (Admin)    |
| GET    | `/api/user/groceries`                    | Get all groceries (User)    |

### Order Endpoints
| Method | Endpoint         | Description              |
|--------|-----------------|--------------------------|
| POST   | `/api/user/orders`    | Place an order (User)   |
| GET    | `/api/user/orders`    | View all orders (Admin) |

## Setup Instructions

### Prerequisites
- Java 17+
- PostgreSQL
- Maven

### Steps to Run
1. Clone the repository:
   ```sh
   git clone https://github.com/aniket156/Grocery_Booking_App.git
   cd grocerybooking
   ```
2. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/grocerydb
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```
3. Build and run the project:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
4. The API will be available at:
   ```sh
   http://localhost:8080
   
