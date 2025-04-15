package com.example.producer.controller;

import com.example.producer.model.Message;
import com.example.producer.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class ProducerController {

    private final KafkaProducerService producerService;

    @PostMapping("/topic1")
    public ResponseEntity<String> sendToTopic1(@RequestBody Message message) {
        message.setId(UUID.randomUUID().toString());
        message.setTimestamp(LocalDateTime.now().toString());
        producerService.sendToTopic1(message);
        return ResponseEntity.ok("Message sent to topic1");
    }

    @PostMapping("/topic2")
    public ResponseEntity<String> sendToTopic2(@RequestBody Message message) {
        message.setId(UUID.randomUUID().toString());
        message.setTimestamp(LocalDateTime.now().toString());
        producerService.sendToTopic2(message);
        return ResponseEntity.ok("Message sent to topic2");
    }

    @PostMapping("/both")
    public ResponseEntity<String> sendToBoth(@RequestBody Message message) {
        message.setId(UUID.randomUUID().toString());
        message.setTimestamp(LocalDateTime.now().toString());
        producerService.sendToBothTopics(message);
        return ResponseEntity.ok("Message sent to both topics");
    }
}