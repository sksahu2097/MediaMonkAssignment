FROM maven:3.9.0-amazoncorretto-17 as build
WORKDIR .
COPY pom.xml .
COPY src src
RUN mvn clean install

FROM maven:3.9.0-amazoncorretto-17
COPY --from=build target/MediaMonkAssignment-0.0.1-SNAPSHOT.jar /usr/app/MediaMonkAssignment-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/MediaMonkAssignment-0.0.1-SNAPSHOT.jar"]