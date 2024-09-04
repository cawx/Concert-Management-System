FROM amazoncorretto:22

LABEL version="1.0"

EXPOSE 8080

WORKDIR /app

COPY target/xo-0.0.1-SNAPSHOT.jar /app/xo.jar

ENTRYPOINT ["java", "-jar", "xo.jar"]