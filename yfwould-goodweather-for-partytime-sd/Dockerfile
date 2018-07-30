FROM openjdk:8-jdk-alpine

ENV HOME=/home/goodweather-partytime-sd

WORKDIR $HOME

ADD build/libs/goodweather-partytime-sd.jar goodweather-partytime-sd.jar

CMD ["java", "-jar", "goodweather-partytime-sd.jar"]