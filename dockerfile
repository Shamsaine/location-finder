# Stage 1: Build the application
FROM maven:3.9.4-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY --from=builder /app/target/app-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9090
#ENTRYPOINT ["java", "-jar", "app.jar"]

# Use an official MySQL image as the base for the database
FROM mysql:latest AS mysql

# Use an official OpenJDK runtime as the base for the application
#FROM eclipse-temurin:21-jdk-jammy

# Set the working directory inside the container
#WORKDIR /app

# Copy the Maven build output (JAR file) into the container
#COPY target/app-0.0.1-SNAPSHOT.jar app.jar

# Copy the MySQL data directory from the MySQL stage
#COPY --from=mysql /var/lib/mysql /var/lib/mysql

# Expose the ports for the application and MySQL
EXPOSE 3306

# Start both MySQL and the Spring Boot application
CMD ["sh", "-c", "service mysql start && java -jar app.jar"]