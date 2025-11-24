FROM maven:3.9.5-amazoncorretto-21-debian AS build
WORKDIR /app
COPY pom.xml .
COPY src /app/src
RUN mvn package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=build /app/target/secret-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]