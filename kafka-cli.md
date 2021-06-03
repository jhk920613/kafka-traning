## windows
명령어 실행 위치는 KAFKA_HOME/bin/windows입니다.  

### start zookeeper
```shell
$ ./zookeeper-server-start.bat ../../config/zookeeper.properties[enter]
```

### start kafka
```shell
$ ./kafka-server-start.bat ../../config/server.properties[enter]
```

### create topic
```shell
$ ./kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test[enter]
```

### produce event
```shell
$ ./kafka-console-producer.bat --broker-list localhost:9092 --topic test[enter]
> first message[enter]
> second message[enter]
```

### consume event
```shell
$ ./kafka-console-producer.bat --bootstrap-server localhost:9092 --from-beginning --topic test[enter]
```

### delete topic
```shell
$ ./kafka-topics.sh --delete --bootstrap-server localhost:9092 --topic test[enter]
```
