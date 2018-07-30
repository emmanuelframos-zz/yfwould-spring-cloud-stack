FROM openjdk:8-jdk-alpine

ENV HOME=/home/spotify-partytime

WORKDIR $HOME

ADD build/libs/spotify-partytime.jar spotify-partytime.jar

CMD ["java", "-jar", "spotify-partytime.jar"]
