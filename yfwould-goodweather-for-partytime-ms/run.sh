gradle clean build

docker stop $(docker ps -qa --filter="name=goodweather-partytime") || true

docker rm -f $(docker ps -qa --filter="name=goodweather-partytime") || true

docker build -t goodweather-partytime:latest .

docker run -d -p 9000:9000 --name goodweather-partytime -t goodweather-partytime:latest