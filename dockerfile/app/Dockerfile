# syntax=docker/dockerfile:1

FROM tomcat:11-jdk17-temurin
LABEL authors="Andriy Sichniy"

COPY ./target/PortierDigital-SichniyA.war \
     /usr/local/tomcat/webapps/PortierDigital-SichniyA.war
COPY ./dockerfile/app/context.xml /usr/local/tomcat/conf/context.xml

ENTRYPOINT ["catalina.sh", "run"]