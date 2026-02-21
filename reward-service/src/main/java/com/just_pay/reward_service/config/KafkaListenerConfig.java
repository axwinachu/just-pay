package com.just_pay.reward_service.config;

import com.just_pay.reward_service.dto.Transaction;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;

@Configuration
public class KafkaListenerConfig {
    @Bean(name="notification-bean")
    ConcurrentKafkaListenerContainerFactory<String, Transaction> concurrentKafkaListenerContainerFactory(ConsumerFactory<String,Transaction> consumerFactory){
        ConcurrentKafkaListenerContainerFactory<String,Transaction> factory=new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        return factory;
    }
}
