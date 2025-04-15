package com.example.consumer2.service;

import com.example.consumer2.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = "topic2", groupId = "consumer2-group")
    public void listenToTopic2(Object message) {
        log.info("Consumer 2 received message from topic2: {}", message.toString());
        // Process message logic goes here
    }
}