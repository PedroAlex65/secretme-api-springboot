From ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
WORKDIR /app
COPY . .

RUN apt-get install maven -y
RUN mvn clean install -DskipTests

FROM maven:3.8.1-openjdk-17

EXPOSE 8080
COPY --from=build /app/target/secret-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]






