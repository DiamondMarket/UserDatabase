FROM java:8
VOLUME /tmp
ADD ${JAR_FILE} userdb.jar
RUN bash -c 'touch /userdb.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/userdb.jar"]