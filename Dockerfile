FROM openjdk:8-jdk-alpine
EXPOSE 8081
VOLUME /tmp
ADD  /target/swagger-spring-1.0.0.jar /users-1.0.0.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo/DiamondMarket","-Djava.security.egd=file:/dev/./urandom","-jar","/users-1.0.0.jar"]
 