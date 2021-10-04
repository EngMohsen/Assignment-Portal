FROM adoptopenjdk/maven-openjdk11

EXPOSE 8080

WORKDIR /apps

COPY . .

#RUN mvn clean install

#CMD mvn spring-boot:run



COPY ./target/portal-0.0.1-SNAPSHOT.jar /apps/portal-0.0.1-SNAPSHOT.jar
CMD "java" "-jar" "portal-0.0.1-SNAPSHOT.jar"