Spring Boot on Docker connecting to MySQL Docker container

Use MySQL Image published by Docker Hub (https://hub.docker.com/_/mysql/) Command to run the mysql container 

docker container run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=movie -e MYSQL_USER=springboot -e MYSQL_PASSWORD=root -d mysql:5

Go in docker container and check--> docker container exec -it mysql-standalone bash
After enetering bash login via username and password
--> mysql -uroot -ppassword
gcloud auth configure-docker


In the Spring Boot Application, use the same container name of the mysql instance in the application.properties spring.datasource.url = jdbc:mysql://mysql-standalone:3306/test

DOCKER BUILD COMMAND:

docker build -t movie-review .

gcloud auth:
gcloud auth configure-docker

DOCKER GOOGLE CLOUD:
docker tag movie-review gcr.io/spring-kube/movie-review 

DOCKER PUSH TO GOOGLE CLOUD:
docker push gcr.io/spring-kube/movie-review




Useful Docker commands
docker images
docker container ls
docker logs <container_name>
docker container rm <container_name
docker image rm <image_name
