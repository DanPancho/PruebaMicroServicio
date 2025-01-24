FROM openjdk:17-jdk-slim

LABEL maintener="darcos@banred.fin.ec"
LABEL Description="Prueba BR"

WORKDIR /app


COPY target/microservicioAPITest-0.0.1-SNAPSHOT.jar app.jar


COPY src/main/resources/keystore.jks /app/keystore.jks


ENV SERVER_PORT=8443 \
    SERVER_SSL_KEYSTORE=/app/keystore.jks \
    SERVER_SSL_KEYSTORE_PASSWORD=password \
    SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/pruebabr \
    SPRING_DATASOURCE_USERNAME=root \
    SPRING_DATASOURCE_PASSWORD=root


EXPOSE 8443


ENTRYPOINT ["java", "-Dserver.port=${SERVER_PORT}", \
                 "-Dserver.ssl.key-store=${SERVER_SSL_KEYSTORE}", \
                 "-Dserver.ssl.key-store-password=${SERVER_SSL_KEYSTORE_PASSWORD}", \
                 "-Dspring.datasource.url=${SPRING_DATASOURCE_URL}", \
                 "-Dspring.datasource.username=${SPRING_DATASOURCE_USERNAME}", \
                 "-Dspring.datasource.password=${SPRING_DATASOURCE_PASSWORD}", \
                 "-jar", "app.jar"]