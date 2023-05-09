# kafkaSample
kafka

# kafka Docker 설정
version: '3'

services:
  zookeeper:
    image: wurstmeister/zookeeper
    container_name: zookeeper
    ports:
      - 2181:2181

  kafka:
    image: wurstmeister/kafka
    container_name: kafka
    depends_on:
      - zookeeper
    ports:
      - 9092:9092
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://192.168.0.4:9092
      #KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://127.0.0.1:9092
      KAFKA_LISTENERS: PLAINTEXT://0.0.0.0:9092
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      #KAFKA_CREATE_TOPICS: "test:1:1"
      KAFKA_AUTO_CREAT_TOPICS_ENABLE:'true'
      KAFKA_CONSUMER_GROUP:msgsvr
  kafdrop:
    image: obsidiandynamics/kafdrop
    container_name: kafdrop
    ports:
      - 9000:9000
    environment:
      KAFKA_BROKERCONNECT: 192.168.0.4:9092
      #KAFKA_BROKERCONNECT: 127.0.0.1:9092
