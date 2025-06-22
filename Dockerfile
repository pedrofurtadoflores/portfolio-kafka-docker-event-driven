FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app
COPY . .

ARG SERVICE
RUN mvn clean package -pl ${SERVICE} -am -DskipTests

FROM eclipse-temurin:17-jdk

WORKDIR /app

ARG SERVICE
COPY --from=build /app/${SERVICE}/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
