gradle clean build

docker stop $(docker ps -qa --filter="name=goodweather-partytime-sd") || true

docker rm -f $(docker ps -qa --filter="name=goodweather-partytime-sd" || true

docker build -t goodweather-partytime-sd:latest .

docker run -d -p 9000:9000 --name goodweather-partytime-sd -t goodweather-partytime-sd:latest