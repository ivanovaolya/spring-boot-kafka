package com.educational.springbootkafka.service.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author ivanovaolyaa
 * @version 11/14/2018
 */
@Service
public class DefaultConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultConsumerService.class);

    @KafkaListener(topics = "myTopic", groupId = "test-consumer-group")
    public void listen(final String message) {
        LOGGER.info("Recieved message: payload = {}", message);
    }

}
