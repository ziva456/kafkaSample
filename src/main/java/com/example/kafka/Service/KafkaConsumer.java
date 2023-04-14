package com.example.kafka.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "server-rest", groupId = "personalMessage")
    public void consume(String message) throws IOException {
        System.out.println("Consumed message"+message);
    }
}
