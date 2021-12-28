FROM openjdk:11.0.12
EXPOSE 8080
ADD target/cs50-finalproject-publisher.jar cs50-finalproject-publisher.jar
ENTRYPOINT ["java", "-jar", "/cs50-finalproject-publisher.jar"]