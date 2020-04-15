FROM openjdk:11-jdk-alpine
COPY build/libs/gs-spring-boot-docker-0.1.0.jar my_app.jar
ENTRYPOINT ["java","-jar","my_app.jar"]


















#FROM adoptopenjdk/openjdk11-openj9:x86_64-alpine-jdk-11.0.5_10_openj9-0.17.0-slim AS base
#ENV LANG C.UTF-8
#WORKDIR /app
#FROM adoptopenjdk/maven-openjdk11 AS build
#WORKDIR /src
#COPY . /src
#RUN ./gradlew build && java -jar build/libs/gs-spring-boot-docker-0.1.0.jar
#RUN mvn -f ./pom.xml clean install -U -DskipTests -Piti -DexcludedGroups="integration"
#RUN rm -f ../src/target/*sources.jar
#RUN ls -lah ../src/target
#RUN cp -a ../src/target/growdiary*.jar /app.jar
#FROM base AS final
#COPY --from=build /app.jar .
#CMD java -jar -Dspring.profiles.active=production /app/app.jar
