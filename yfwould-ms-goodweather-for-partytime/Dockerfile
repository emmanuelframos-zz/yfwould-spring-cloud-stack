FROM openjdk:8-jdk-alpine

ENV HOME=/home/goodweather-partytime

WORKDIR $HOME

ADD build/libs/goodweather-partytime.jar goodweather-partytime.jar

CMD ["java", "-jar", "goodweather-partytime.jar"]
