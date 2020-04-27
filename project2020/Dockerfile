FROM alpine/git as clone 
WORKDIR /app
RUN git clone https://github.com/tneumark-blue-star-software/java-sample_project.git

FROM maven:3.5-jdk-8-alpine as build
COPY --from=clone /app/java-sample_project/project2020 /source
WORKDIR /source
RUN mvn clean install

FROM tneumark/spring-boot-deploy4:latest
COPY --from=build /source/start.sh /opt/dockertest/start.sh
COPY --from=build /source/target/project2020-0.0.1-SNAPSHOT.jar /opt/dockertest/
EXPOSE 8080:8080
CMD ["/opt/dockertest/start.sh"]
