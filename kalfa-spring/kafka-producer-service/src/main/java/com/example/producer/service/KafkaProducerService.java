package com.example.producer.service;

import com.example.producer.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendToTopic1(Message message) {
        kafkaTemplate.send("topic1", message.getId(), message);
    }

    public void sendToTopic2(Message message) {
        kafkaTemplate.send("topic2", message.getId(), message);
    }

    public void sendToBothTopics(Message message) {
        sendToTopic1(message);
        sendToTopic2(message);
    }
}