# Étape 1 : Build avec Maven
FROM maven:3.8.4-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Étape 2 : Exécution avec Java 17 (Temurin est disponible sur Render)
FROM eclipse-temurin:17-jdk
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]