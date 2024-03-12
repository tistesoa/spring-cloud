./gradlew clean build
docker build --build-arg JAR_FILE=build/libs/spring-cloud-*.jar -t tistesoa/springcloudapp .
docker push tistesoa/springcloudapp:latest

kubectl apply -f pod.yaml
kubectl get deployment
kubectl get service

kubectl exec -it spring-cloud-app-dep-6dd69fff44-cbx8g -- curl http://spring-cloud-app-ser:8080/greeting



kubectl apply -f zookeeper.yaml

kubectl logs zookeeper-0 --previous --tail 100



kubectl apply -f kafka.yaml  



kubectl exec -it kafka-service-5f5bd5fd6b-pwkwt -- /bin/bash

kafka-topics.sh --bootstrap-server kafka-service:9092 --create --topic toStream --replication-factor 1 --partitions 3


## Docker compose
docker-compose up -d
nc -zv localhost 22181
nc -zv localhost 29092

docker exec -it a5e0e23bb981 sh -c "kafka-topics --create --topic toStream --bootstrap-server kafka:9092"
docker-compose logs kafka  
docker exec -it a5e0e23bb981 sh -c "kafka-console-producer --topic toStream --bootstrap-server kafka:9092"

docker exec -it a5e0e23bb981 sh -c "kafka-console-consumer --topic toStream --bootstrap-server kafka:9092"

curl http://localhost:8080/greeting
### Using kafka Strimzi
Then, let’s install the Strimzi operators for the ‘kafka’ namespace:

kubectl create -f 'https://strimzi.io/install/latest?namespace=kafka' -n kafka

To create a new cluster, it does need some configuration, we can download a template from the Strimzi:

curl -o kafka.yaml https://strimzi.io/examples/latest/kafka/kafka-persistent-single.yaml