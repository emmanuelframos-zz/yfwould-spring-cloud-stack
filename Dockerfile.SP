FROM java:8-jdk

ENV HOME=/home/ms-spotify-partytime

WORKDIR $HOME

ADD wait-for-it.sh wait-for-it.sh

ADD yfwould-ms-spotify-partytime/build/libs/ms-spotify-partytime.jar ms-spotify-partytime.jar