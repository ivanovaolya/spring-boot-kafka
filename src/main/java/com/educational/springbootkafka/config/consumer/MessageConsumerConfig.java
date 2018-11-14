package com.educational.springbootkafka.config.consumer;

import java.util.HashMap;
import java.util.Map;

import com.educational.springbootkafka.controller.dto.Message;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

/**
 * @author ivanovaolyaa
 * @version 11/14/2018
 */
@Configuration
@EnableKafka
public class MessageConsumerConfig {

    @Value("${kafka.bootstrap-server}")
    private String bootstrapServer;

    @Value("${kafka.consumer.group.id}")
    private String groupId;

    @Bean
    public ConsumerFactory<String, Message> messageConsumerFactory() {
        final Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        return new DefaultKafkaConsumerFactory<>(props,
                new StringDeserializer(), new JsonDeserializer<>(Message.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Message> messageKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Message> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(messageConsumerFactory());
        return factory;
    }
}
