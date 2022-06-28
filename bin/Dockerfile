FROM openjdk:11.0.15-jdk-buster
WORKDIR app
COPY target/backend_billi-0.0.1-SNAPSHOT.jar /app/backend_billi-0.0.1-SNAPSHOT.jar
COPY ./.env /app/.env
EXPOSE 8090
CMD ["java", "-jar", "/app/backend_billi-0.0.1-SNAPSHOT.jar"]