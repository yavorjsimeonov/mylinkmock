FROM amazoncorretto:17-alpine-jdk
#FROM tomcat:9.0-alpine
MAINTAINER yavor
ENV LANG en_GB.UTF-8
RUN apk add --update ttf-dejavu && rm -rf /var/cache/apk/*

ADD ./src/main/resources/application.properties /app/application.properties
ADD ./src/main/resources/log4j.properties /logs/log4j.properties


EXPOSE 81:81
COPY ./build/libs/mylinkmock-1.0.0.jar mylinkmock-1.0.0.jar
ENTRYPOINT ["java","-jar","mylinkmock-1.0.0.jar","-Dapp.home=classpath:file:/app/", "-Dlog4j.configurationFile=classpath:file:/logs/log4j2.properties","--spring.profiles.active=default","--server.port=81"]
