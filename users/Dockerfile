FROM openjdk:13 as Target
COPY target/users-1.0.0.jar users.jar

ENTRYPOINT ["java","-jar","/users.jar"]

EXPOSE 9090