FROM tneumark/spring-boot-deploy4
COPY . /opt/dockertest
RUN mvn build
CMD /opt/dockertest/start.sh
