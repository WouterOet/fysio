FROM openjdk:10-jre
VOLUME /tmp
COPY target/fysio-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]