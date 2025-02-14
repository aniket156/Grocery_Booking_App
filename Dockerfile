FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/grocerybooking-0.0.1-SNAPSHOT.jar grocerybooking.jar
EXPOSE 8080
CMD ["java", "-jar", "grocerybooking.jar"]
