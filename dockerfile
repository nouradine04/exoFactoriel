# Utiliser une image de base avec Maven et Java 22
FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /app
COPY src /app/src
COPY pom.xml /app
RUN mvn clean package

# Utiliser une image légère pour l'exécution
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/exoFactoriel-1.0-SNAPSHOT.jar /app/exoFactoriel.jar
EXPOSE 8080
CMD ["java", "-cp", "exoFactoriel.jar", "com.groupeisi.Main"]