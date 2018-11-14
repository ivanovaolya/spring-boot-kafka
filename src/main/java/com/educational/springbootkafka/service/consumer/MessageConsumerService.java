package com.educational.springbootkafka.service.consumer;

import com.educational.springbootkafka.controller.dto.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author ivanovaolyaa
 * @version 11/14/2018
 */
@Service
public class MessageConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultConsumerService.class);

    @KafkaListener(topics = "myTopic", groupId = "test-consumer-group")
    public void listen(final Message message) {
        LOGGER.info("Recieved a JSON message: {}", message);
    }

}
