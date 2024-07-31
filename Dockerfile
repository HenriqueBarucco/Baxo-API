FROM gradle:jdk21-alpine AS build

WORKDIR /app

ADD . .
RUN ./gradlew clean bootJar
RUN ls -la build/libs

FROM eclipse-temurin:21-jdk-alpine

COPY --from=build /app/build/libs/*.jar /app.jar

ENV TZ=America/Sao_Paulo

ENTRYPOINT ["java", "-jar", "/app.jar"]