FROM openjdk:8u131-jdk-alpine
WORKDIR /spring
COPY . /spring
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "/spring/target/movieReview-0.0.1-SNAPSHOT.jar"]
