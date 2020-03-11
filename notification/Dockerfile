FROM openjdk:13 as Target
COPY target/notification-1.0.0.jar notification.jar

ENTRYPOINT ["java","-jar","/notification.jar"]

EXPOSE 9093