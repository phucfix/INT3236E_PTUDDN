package com.example.consumer1.service;

import com.example.consumer1.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = "topic1", groupId = "consumer1-group")
    public void listenToTopic1(Object message) {
        log.info("Consumer 1 received message from topic1: {}", message.toString());
        // Process message logic goes here
    }
}