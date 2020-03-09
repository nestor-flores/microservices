FROM openjdk:13 as Target
COPY target/registry-1.0.0.jar registry.jar

ENTRYPOINT ["java","-jar","/registry.jar"]

EXPOSE 8176