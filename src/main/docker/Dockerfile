FROM maven:3.8.3-openjdk-11
COPY ./ /var/project
WORKDIR /var/project
ENTRYPOINT mvn clean verify -Dexec.skip=false
