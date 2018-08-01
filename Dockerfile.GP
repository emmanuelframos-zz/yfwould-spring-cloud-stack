FROM java:8-jdk

ENV HOME=/home/ms-goodweather-4party

WORKDIR $HOME

ADD wait-for-it.sh wait-for-it.sh

ADD yfwould-ms-goodweather-4party/build/libs/ms-goodweather-4party.jar ms-goodweather-4party.jar