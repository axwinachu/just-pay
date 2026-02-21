package com.just_pay.notification_service.config;

import com.just_pay.notification_service.dto.Transaction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public class KafkaListenerConfig {

    @Bean(name = "transactionKafkaListenerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, Transaction> kafkaListenerContainerFactory(ConsumerFactory<String, Transaction> consumerFactory) {

        ConcurrentKafkaListenerContainerFactory<String, Transaction> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory);

        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);

        return factory;
    }
}