# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven build output (JAR file) into the container
COPY target/app-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application runs on
EXPOSE 9090

# Set environment variables for Render (optional, can also be set in Render's dashboard)
ENV SPRING_PROFILES_ACTIVE=prod

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]