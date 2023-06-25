FROM openjdk:17-jdk
WORKDIR /app
COPY target/projetSpring-0.0.1-SNAPSHOT.jar /app/contractManagement.jar
EXPOSE 8080
CMD ["java","-jar","contractManagement.jar"]