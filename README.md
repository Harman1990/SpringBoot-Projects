
# ToDo Application - Spring Boot & Spring MVC

This is a ToDo application built using Spring Boot and Spring MVC with JSP for the user interface, allowing users to manage their tasks efficiently. The application supports functionalities such as task creation, viewing, updating, and deletion. It also includes responsive design using Bootstrap for improved UI/UX.

## Features
- Add new tasks
- Update existing tasks
- Delete tasks
- View a list of all tasks
- User authentication with Spring Security
- Responsive design using Bootstrap
- Reusable JSP fragments for consistent UI components

## Project Overview

This project follows a typical Spring Boot MVC architecture:
- **Controllers**: Manage user interactions and route requests to the appropriate services.
- **Models**: Define the structure of data (e.g., `Todo` entity for tasks).
- **Views**: JSP files render the UI for task management and navigation (e.g., `listTodos.jsp`, `todo.jsp`).

## Requirements
- Java 17+
- Maven 3.8+
- Spring Boot 3.3.3
- Spring MVC
- Spring Security
- Bootstrap 4+

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Harman1990/SpringBoot-Projects.git
   ```

2. Navigate to the project directory:
   ```bash
   cd mywebapp
   ```

3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Usage

Once the application is running, you can access it in your browser at `http://localhost:8080`. You will be prompted to log in (Spring Security configuration is applied).

### Main Pages:
- `http://localhost:8080/welcome`: The welcome page after login.
- `http://localhost:8080/todos`: View the list of to-do items.
- `http://localhost:8080/todos/add`: Add a new to-do item.

