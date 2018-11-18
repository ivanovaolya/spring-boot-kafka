# spring-boot-kafka
Pet project for publishing / subscribing  messages 

### Quickstart for Apache Kafka (Mac)
1. Install the latest version of [Apache Kafka](https://kafka.apache.org/downloads) using Brew package manager
```sh
brew install kafka
```
2. Start Apache ZooKeeper server
```sh
brew services start zookeeper
```
3. Start the Kafka server
```sh
brew services start kafka
```
4. Create a topic
```sh
cd usr/local/Cellar/kafka/2.0.0/bin/
sh kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic myTopic
```
5. Start a command line consumer
```sh
sh kafka-console-consumer --bootstrap-server localhost:9092 --topic myTopic --from-beginning
```
### Quickstart for Apache Kafka (Windows)
1. Download the latest version of [Apache Kafka](https://kafka.apache.org/downloads) 
2. Start Apache ZooKeeper server
```sh
$ bin/windows/zookeeper-server-start.bat config/zookeeper.properties
```
3. Start the Kafka server
```sh
$ bin/windows/kafka-server-start.bat config/server.properties
```
4. Create a topic
```sh
$ bin/windows/kafka-topics.bat --create --zookeeper localhost:2181 \ 
  --replication-factor 1 --partitions 1 --topic myTopic
```
5. Start a command line consumer
```sh
$ bin/windows/kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic myTopic --from-beginning
```
### Run the app
```sh
$ gradlew bootRun
> ./gradlew bootRun
```
