FROM openjdk:21-jdk

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
CMD ["./mvnw", "clean install spring-boot:run"]
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]