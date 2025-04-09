Here’s the updated README.md with the requested changes:

---

```markdown
# Location Finder

Location Finder is a web-based application designed to help users search for and view information about various locations such as restaurants, parks, stores, and more. It provides a centralized platform for users to explore location-based information, manage categories, and track search history.

## Features

- **User Management**: 
  - User registration and login with secure password hashing.
  - Role-based access control for managing users and locations.

- **Location Management**:
  - Add, update, delete, and view locations.
  - Search locations by name or category.

- **Category Management**:
  - Add, update, delete, and view categories.
  - Manage subcategories for better organization.

- **Search History**:
  - Track and view search history for logged-in users.

- **Frontend**:
  - Responsive HTML, CSS, and JavaScript-based user interface.
  - Dynamic pages for login, registration, location details, and more.

- **Backend**:
  - Built with Spring Boot for RESTful APIs.
  - MySQL database for data persistence.
  - JWT-based authentication for secure API access.

---

## Getting Started

Follow these steps to set up and run the project locally.

### Prerequisites

1. **Java Development Kit (JDK)**:
   - Ensure you have JDK 21 or later installed.
   - [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

2. **Maven**:
   - Ensure Maven is installed for dependency management.
   - [Download Maven](https://maven.apache.org/download.cgi)

3. **MySQL**:
   - Install MySQL and create a database named `locationfinder`.
   - [Download MySQL](https://dev.mysql.com/downloads/)

4. **Node.js (Optional)**:
   - If you want to use a static file server for the frontend.
   - [Download Node.js](https://nodejs.org/)

---

### Setting Up the Project

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/location-finder.git
   cd location-finder
   ```

2. **Configure the Database**:
   - The project uses an `.env` file to manage sensitive configuration details like database credentials. Update the `.env` file with your database details:
     ```properties
     SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/locationfinder
     SPRING_DATASOURCE_USERNAME=your-username
     SPRING_DATASOURCE_PASSWORD=your-password
     ```
   - Ensure the .env file is properly loaded by your environment or deployment setup.

3. **Install Dependencies**:
   - Run the following command to download all required dependencies:
     ```bash
     mvn clean install
     ```

4. **Run the Application**:
   - Start the Spring Boot application:
     ```bash
     mvn spring-boot:run
     ```
   - The application will be available at `http://localhost:9090`.

5. **Set Up the Database**:
   - The application will automatically create the required tables in the `locationfinder` database.

---

### Frontend Setup

1. **Static Files**:
   - The frontend files are located in the `src/main/resources/static` directory.
   - However, the frontend is **not fully active** and is currently under development. You can test the backend endpoints directly using tools like **Postman** or **cURL**.

2. **Contribute to the Frontend**:
   - Any updates to the frontend build and functionality are welcome! You can extend the existing HTML, CSS, and JavaScript files or rebuild the frontend using a modern framework like React or Angular.

3. **Serve Frontend Separately (Optional)**:
   - If you want to serve the current frontend files, use a static file server like `http-server`:
     ```bash
     npm install -g http-server
     cd src/main/resources/static
     http-server
     ```
   - Access the frontend at the URL provided by the server.

---

### API Endpoints

#### **User Management**
- `POST /users`: Register a new user.
- `POST /auth/login`: Authenticate a user and generate a JWT token.
- `GET /users`: Retrieve all users (Admin only).

#### **Location Management**
- `POST /locations`: Add or update a location.
- `GET /locations`: Retrieve all locations.
- `GET /locations/{id}`: Retrieve a location by ID.
- `DELETE /locations/{id}`: Delete a location by ID.

#### **Category Management**
- `POST /categories`: Add or update a category.
- `GET /categories`: Retrieve all categories.
- `GET /categories/{id}/subcategories`: Retrieve subcategories of a category.

#### **Search History**
- `GET /history?userId={userId}`: Retrieve search history for a user.

---

### Building on the Project

1. **Add New Features**:
   - Extend the backend by adding new endpoints in the controllers.
   - Add new pages to the frontend for additional functionality.

2. **Improve Security**:
   - Implement HTTPS for secure communication.
   - Add rate limiting to prevent abuse of APIs.

3. **Deploy the Application**:
   - Use a cloud platform like AWS, Azure, or Heroku to deploy the application.
   - Use Docker to containerize the application for easier deployment.

4. **Enhance the Frontend**:
   - Use a modern frontend framework like React or Angular for a more dynamic user experience.
   - Add animations and improve the UI/UX.

---

### Contributing

Contributions are welcome! If you'd like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes and push them to your fork.
4. Submit a pull request with a detailed description of your changes.

---

### License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---

### Contact

For questions or support, please contact:
- **Email**: shamsain3@gmail.com
- **GitHub**: [shamsaine](https://github.com/shamsaine)
```

---
