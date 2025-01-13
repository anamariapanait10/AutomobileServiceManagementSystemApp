# Automobile Service Management System 🚘

The **Automobile Service Management System** is designed to streamline
the management of automobile service centers. It provides
functionalities to manage orders, clients, car models, car parts and employees,
ensuring efficient operations and seamless customer experiences.

## 10 Business Requirements
    1. Employees can create service orders using client information.
    2. Orders can include one or more car parts.
    3. Each order is assigned to an employee responsible for its completion.
    4. Car parts are associated with specific car models.
    5. Clients’ data can be added, modified, or deleted.
    6. Orders can be added or deleted and their status can be updated.
    7. Employees’ data can be added, modified, or deleted.
    8. Car models and car parts can be added or deleted.
    9. The system calculates order prices automatically based on required car parts and services.
    10. Reports can be generated to monitor service center performance.

## MVP Features
1. **Orders Management**

    - Add, delete, and update orders.
    - Assign employees and calculate order prices.

2. **Clients Management**

    - Add, modify, and delete client records.
    - Search clients based on various criteria.

3. **Car Models Management**

    - Add and delete car models.
    - Link car parts to respective models.

4. **Car Parts Management**

    - Add and delete car parts.
    - Manage inventory and stock details.

5. **Employee Management**

    - Add, modify, and delete employee details.
    - Assign employees to service orders.


## Spring Boot Application

### 1. REST Endpoints

The system includes the following endpoints:

| Endpoint         | Method              | Description          |
|------------------|---------------------|----------------------|
| `/api/orders`    | GET/POST/DELETE/PUT | Manage orders.       |
| `/api/clients`   | GET/POST/DELETE/PUT | Manage clients.      |
| `/api/car-models`| GET/POST/DELETE     | Manage car models.   |
| `/api/car-parts` | GET/POST/DELETE     | Manage car parts.    |
| `/api/employees` | GET/POST/DELETE/PUT | Manage employees.    |


### 2. Services

Each feature has a dedicated service to handle business logic:

- **OrderService**: Implements logic for managing orders.
- **ClientService**: Handles operations for clients.
- **CarModelService**: Manages car models.
- **CarPartService**: Manages car parts inventory.
- **EmployeeService**: Manages employee data.


### 3. Repositories
Repositories are created for each entity, e.g., OrderRepository, ClientRepository. These interact with the database to perform CRUD operations.

### 4. Unit Tests
Unit tests ensure each REST endpoint and service operates as expected. **JUnit** framework was used for testing.

### 5. Database Persistence
The application uses a relational database (**MySql**) to store data. Entities include:

- **Order**: Represents a service order. Relations: Linked to Employee, Client and CarPart.
- **Client**: Represents client details. Relations: Linked to Order.
- **CarModel**: Represents car models. Relations: Linked to CarPart.
- **CarPart**: Represents car parts. Relations: Linked to CarModel and Order.
- **Employee**: Represents employees. Relations: Linked to Order.
- **OrderStatus**: Tracks the status of an order.

![db_schema](https://github.com/anamariapanait10/AutomobileServiceManagementSystemApp/blob/main/db_schema.png)

### 6. Validation
POJO classes include validation constraints such as:

`@NotNull`, `@Size` for fields like name and description.
Custom annotations for unique fields (e.g., email validation for clients).

### Swagger Documentation

The Swagger Documentation can be accessed on the following path: http://localhost:8080/swagger-ui/index.html

![db_schema](https://github.com/anamariapanait10/AutomobileServiceManagementSystemApp/blob/main/swagger.png)