# Use an official MySQL image as the base for the database
FROM mysql:latest AS mysql

# Use an official OpenJDK runtime as the base for the application
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven build output (JAR file) into the container
COPY target/app-0.0.1-SNAPSHOT.jar app.jar

# Copy the MySQL data directory from the MySQL stage
COPY --from=mysql /var/lib/mysql /var/lib/mysql

# Expose the ports for the application and MySQL
EXPOSE 9090 3306

# Start both MySQL and the Spring Boot application
CMD ["sh", "-c", "service mysql start && java -jar app.jar"]