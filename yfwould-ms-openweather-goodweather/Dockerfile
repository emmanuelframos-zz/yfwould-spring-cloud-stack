FROM openjdk:8-jdk-alpine

ENV HOME=/home/openweather-goodweather

WORKDIR $HOME

ADD build/libs/openweather-goodweather.jar openweather-goodweather.jar

CMD ["java", "-jar", "openweather-goodweather.jar"]
