# Inventory Management System

This project is a simple Inventory Management System developed using Spring Boot. It provides a RESTful API to manage inventory items including the ability to create, read, update, and delete (CRUD) items. The application uses MySQL as the primary database and H2 for testing purposes.

## Project Features

- RESTful endpoints to manage inventory items
- Integration with MySQL database for production
- H2 in-memory database configured for unit tests
- Automatic table creation via Hibernate
- Structured project with clear separation of concerns (Controller, Service, Repository, Model)

## Setup Instructions

### Prerequisites

Ensure the following tools are installed:

- Java Development Kit 21
- Apache Maven 3.9+
- MySQL Server

### Database Setup

1. Start your MySQL server.
2. Create the database using the following SQL command:

   ```sql
   CREATE DATABASE inventory_db;

### API Endpoints:

HTTP Method	    Endpoint	            Description	                        Request Body
GET	            /items	                Retrieve all inventory items	    None
GET	            /items/{id}	            Retrieve a specific item	        None
POST	        /items	                Add a new item	                    JSON
PUT	            /items/{id}/quantity	Update quantity of an item	        Query param
DELETE	        /items/{id}	            Delete an item by ID	            None

### Usage:

1. Create a New Item
--------------------
POST /items
Content-Type: application/json

Request Body:
{
  "name": "Monitor",
  "quantity": 5,
  "price": 150.00
}

Response:
{
  "id": 1,
  "name": "Monitor",
  "quantity": 5,
  "price": 150.0
}

------------------------------------------------------------------------------------

2. Get All Items
-----------------
GET /items

Response:
[
  {
    "id": 1,
    "name": "Monitor",
    "quantity": 5,
    "price": 150.0
  },
  {
    "id": 2,
    "name": "Keyboard",
    "quantity": 10,
    "price": 30.0
  }
]

------------------------------------------------------------------------------------

3. Get Item by ID
------------------
GET /items/1

Response:
{
  "id": 1,
  "name": "Monitor",
  "quantity": 5,
  "price": 150.0
}

------------------------------------------------------------------------------------

4. Update Item Quantity
------------------------
PUT /items/1/quantity?quantity=8

Response:
{
  "id": 1,
  "name": "Monitor",
  "quantity": 8,
  "price": 150.0
}

------------------------------------------------------------------------------------

5. Delete an Item
------------------
DELETE /items/1

Response:
HTTP 200 OK (No body)

------------------------------------------------------------------------------------
