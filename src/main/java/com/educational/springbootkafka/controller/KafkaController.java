package com.educational.springbootkafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);
    private static final String MY_TOPIC = "myTopic";

    @PostMapping("/publish/{message}")
    @ResponseStatus(value = HttpStatus.OK)
    public void sendMessage(@PathVariable final String message) {
        LOGGER.info("Publishing message: " + message);
        kafkaTemplate.send(MY_TOPIC, message);
    }
}
