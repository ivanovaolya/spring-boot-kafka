package com.educational.springbootkafka.controller;

import java.util.Date;

import com.educational.springbootkafka.controller.dto.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Just a simple controller for publishing messages
 *
 * @author ivanovaolyaa
 * @version 11/13/2018
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private KafkaTemplate<String, String> defaultKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Message> messageKafkaTemplate;

    @Value("${kafka.topic-name}")
    private String topicName;

    @PostMapping("/publish/{message}")
    @ResponseStatus(value = HttpStatus.OK)
    public void sendMessage(@PathVariable final String message) {
        LOGGER.info("Publishing message: {}", message);
        defaultKafkaTemplate.send(topicName, message);
    }

    @PostMapping("/publish")
    @ResponseStatus(HttpStatus.OK)
    public void sendJsonMessage(@RequestBody final Message message) {
        LOGGER.info("Publishing a JSON object: {}", message);
        messageKafkaTemplate.send(topicName, message);
    }
}
