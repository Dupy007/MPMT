# Utiliser une image Maven officielle pour builder l'application
FROM maven:3.8.5-openjdk-11 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Utiliser une image JDK pour exécuter l'application
FROM openjdk:11-jre-slim

COPY --from=build /app/target/MPMT-0.0.1-SNAPSHOT.jar /MPMT.jar

EXPOSE 8080

CMD ["java", "-jar", "/MPMT.jar"]
