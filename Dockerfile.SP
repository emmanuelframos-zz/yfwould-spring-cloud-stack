FROM java:8-jdk

ENV HOME=/home/ms-spotify-4party

WORKDIR $HOME

ADD wait-for-it.sh wait-for-it.sh

ADD yfwould-ms-spotify-4party/build/libs/ms-spotify-4party.jar ms-spotify-4party.jar