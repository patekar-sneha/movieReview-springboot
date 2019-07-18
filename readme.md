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

DELETE IMAGE FROM GCE: gcloud container images delete gcr.io/spring-kube/movie-review


Useful Docker commands
docker images
docker container ls
docker logs <container_name>
docker container rm <container_name
docker image rm <image_name

KUBERNETES:

    MYSQL:
    1. kubectl apply -f mysql-volumeclaim.yaml
    2. SET PASSWORD: kubectl create secret generic mysql --from-literal=password=password 
    3. kubectl create -f mysql-new.yaml
    4. kubectl create -f mysql-new-service.yaml
    4. ACCESS MYSQL THROUGH GKE: kubectl run -it --rm --image=mysql:5.6 --restart=Never mysql-client -- mysql -h mysql -ppassword

ENTER DB: kubectl exec -it mysql-5b9b49cf46-pl7cv -- mysql -uroot -ppassword

CREATE TABLE:
CREATE TABLE Movie.movie_review(
	`id` INT NOT NULL AUTO_INCREMENT,
	`movieName` VARCHAR(100),
	`movieSummary` VARCHAR(100),
	`rating` INT,
	`review` VARCHAR(200),
	PRIMARY KEY (`id`)
);

INSERT INTO Movie.movie_review(id,movieName,movieSummary,rating,review) VALUES (1, 'ABC', 'Good', 5, 'Great');

https://medium.com/javarevisited/kubernetes-step-by-step-with-spring-boot-docker-gke-35e9481f6d5f 
EXPOSE TO OUTSIDE WORLD:kubectl expose deployment userapi --type=LoadBalancer --port 80 --target-port 8080

CREATE NAMESPACE IN KUBERNETES:

kubectl get namespaces --show-labels

kubectl config current-context

kubectl config set-context dev --namespace=dev \
  --cluster=gke_spring-kube_us-central1-a_final-hopeso \
  --user=gke_spring-kube_us-central1-a_final-hopeso

kubectl config use-context dev

kubectl config current-context










