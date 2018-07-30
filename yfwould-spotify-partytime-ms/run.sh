gradle clean build

docker stop $(docker ps -qa --filter="name=spotify-partytime") || true

docker rm -f $(docker ps -qa --filter="name=spotify-partytime") || true

docker build -t spotify-partytime:latest .

docker run -d -p 8081:8081 --name spotify-partytime -t spotify-partytime:latest