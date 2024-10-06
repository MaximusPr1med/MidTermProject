# Use the latest official Maven image to build the application
FROM maven:latest AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml . 
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Use a smaller base image for the final image
FROM openjdk:20-jdk-slim

# Set the working directory in the final container
WORKDIR /app

# Copy the packaged JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# Run the application with interactive input
ENTRYPOINT ["java", "-jar", "app.jar"]
