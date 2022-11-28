FROM openjdk:8
ADD target/rbc-1.0.0.jar rbc-1.0.0.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar" , "demo-docker.jar"]