FROM openjdk:13 as Target
COPY target/gateway-1.0.0.jar gateway.jar

ENTRYPOINT ["java","-jar","/gateway.jar"]

EXPOSE 8080