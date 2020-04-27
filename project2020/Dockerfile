FROM alpine/git as clone 
WORKDIR /clone_output_dir
RUN git clone https://github.com/tneumark-blue-star-software/java-sample_project.git
RUN ls -lart /clone_output_dir/java-sample_project/project2020

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /build_output
COPY --from=clone /clone_output_dir/java-sample_project/project2020 .
RUN mvn clean install
RUN ls -lart /build_output

FROM openjdk:8-jre-alpine
COPY --from=build /build_output/target/project2020-0.0.1-SNAPSHOT.jar /opt/dockertest/
RUN ls -lart /opt/dockertest
EXPOSE 8080:8080
CMD ["java", "-jar", "/opt/dockertest/project2020-0.0.1-SNAPSHOT.jar"]
