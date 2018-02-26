FROM java:8
VOLUME /tmp
ADD  swagger-spring-1.0.0.jar swagger-spring-1.0.0.jar
RUN bash -c 'touch /swagger-spring-1.0.0.jar'
EXPOSE 8080
ENTRYPOINT ["java","-jar","/swagger-spring-1.0.0.jar"]
CMD []