FROM openjdk:13 as Target
COPY target/sales-1.0.0.jar sales.jar

ENTRYPOINT ["java","-jar","/sales.jar"]

EXPOSE 9091