package com.just_pay.reward_service.facade;

import com.just_pay.reward_service.dto.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class NotificationFacade {
    @KafkaListener(topics = "transaction-events",groupId = "notification-group",containerFactory = "notification-bean",concurrency ="3" )
    public void consume(Transaction transaction, Acknowledgment acknowledgment){
        try{
           processData(transaction);
            System.out.println("data received"+transaction);
            acknowledgment.acknowledge();
        }catch (Exception ex){
           throw new RuntimeException("kafka exception"+ex.getMessage());
        }

    }
    private void processData(Transaction transaction){

    }
}
