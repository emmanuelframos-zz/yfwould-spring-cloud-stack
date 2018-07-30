gradle clean build

docker stop $(docker ps -qa --filter="name=goodweather-partytime-gateway") || true

docker rm -f $(docker ps -qa --filter="name=goodweather-partytime-gateway" || true

docker build -t goodweather-partytime-gateway:latest .

docker run -d -p 9000:9000 --name goodweather-partytime-gateway -t goodweather-partytime-gateway:latest