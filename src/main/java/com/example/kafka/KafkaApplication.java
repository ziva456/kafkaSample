package com.example.kafka;

import com.example.kafka.Service.KafkaConsumer;
import com.example.kafka.Service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ScopeNotActiveException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;


@SpringBootApplication

public class KafkaApplication implements CommandLineRunner {
    private final KafkaProducer producer;

    public KafkaApplication(KafkaProducer producer) {
        this.producer = producer;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        producer.sendMessage("Hello, Kafka!");
    }
}
