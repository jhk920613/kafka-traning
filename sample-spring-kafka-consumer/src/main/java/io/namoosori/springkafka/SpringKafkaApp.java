package io.namoosori.springkafka;

import io.namoosori.springkafka.stream.EventStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(EventStream.class)
@SpringBootApplication
public class SpringKafkaApp {
    //
    public static void main(String[] args) {
        //
        SpringApplication.run(SpringKafkaApp.class, args);
    }
}
