gradle clean build

docker stop $(docker ps -qa --filter="name=openweather-goodweather") || true

docker rm -f $(docker ps -qa --filter="name=openweather-goodweather") || true

docker build -t openweather-goodweather:latest .

docker run -d -p 8080:8080 --name openweather-goodweather -t openweather-goodweather:latest