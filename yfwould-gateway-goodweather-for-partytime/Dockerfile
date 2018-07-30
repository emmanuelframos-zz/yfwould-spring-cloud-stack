FROM openjdk:8-jdk-alpine

ENV HOME=/home/goodweather-partytime-gateway

WORKDIR $HOME

ADD build/libs/goodweather-partytime-gateway.jar goodweather-partytime-gateway.jar

CMD ["java", "-jar", "goodweather-partytime-gateway.jar"]