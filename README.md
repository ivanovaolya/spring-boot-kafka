# spring-boot-kafka
Pet project for publishing / subscribing  messages 

### Quickstart for Apache Kafka
1. Download the latest version of [Apache Kafka](https://kafka.apache.org/downloads) 
2. Start Apache ZooKeeper server
```sh
$ bin/windows/zookeeper-server-start.bat config/zookeeper.properties
> bin/zookeeper-server-start.sh config/zookeeper.properties
```
3. Start the Kafka server
```sh
$ bin/windows/kafka-server-start.bat config/server.properties
> bin/kafka-server-start.sh config/server.properties
```
4. Create a topic
```sh
$ bin/windows/kafka-topics.bat --create --zookeeper localhost:2181 \ 
  --replication-factor 1 --partitions 1 --topic myTopic
> bin/kafka-topics.sh --create --zookeeper localhost:2181 \ 
  --replication-factor 1 --partitions 1 --topic myTopic
```
5. Start a command line consumer
```sh
$ bin/windows/kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic myTopic --from-beginning
> bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic myTopic --from-beginning
```
### Run the app
```sh
$ gradlew bootRun
> ./gradlew bootRun
```
