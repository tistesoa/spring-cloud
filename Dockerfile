FROM openjdk:21
VOLUME /tmp
COPY build/libs/spring-cloud-*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]