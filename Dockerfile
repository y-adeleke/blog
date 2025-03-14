# Use an official OpenJDK runtime as a parent image
FROM openjdk:8-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/blog-0.0.1-SNAPSHOT.jar.original app.jar

# Expose the port on which your app runs
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
