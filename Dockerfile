FROM openjdk:21-jdk

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]