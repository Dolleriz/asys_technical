FROM openjdk:21

COPY /target/asys_technical-0.0.1-SNAPSHOT.jar asys_technical.jar

ENTRYPOINT [ "java","-jar","asys_technical.jar" ]