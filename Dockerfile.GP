FROM java:8-jdk

ENV HOME=/home/ms-goodweather-partytime

WORKDIR $HOME

ADD wait-for-it.sh wait-for-it.sh

ADD yfwould-ms-goodweather-for-partytime/build/libs/ms-goodweather-partytime.jar ms-goodweather-partytime.jar