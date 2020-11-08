FROM java:8-jdk-alpine

COPY ./target/p2key-service-api-1.0.0-SNAPSHOT-jar-with-dependencies.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch p2key-service-api-1.0.0-SNAPSHOT-jar-with-dependencies.jar'

ARG JAR_FILE=target/p2key-service-api-1.0.0-SNAPSHOT-jar-with-dependencies.jar

ENTRYPOINT ["java","-jar","p2key-service-api-1.0.0-SNAPSHOT-jar-with-dependencies.jar"]