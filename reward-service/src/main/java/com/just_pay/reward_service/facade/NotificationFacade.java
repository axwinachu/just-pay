package com.just_pay.reward_service.facade;

import com.just_pay.reward_service.dto.Transaction;
import com.just_pay.reward_service.model.Reward;
import com.just_pay.reward_service.service.RewardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class NotificationFacade {
    private final RewardServiceImpl rewardService;
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
        if(rewardService.rewardExistByTransactionId(transaction.getId())){
            System.out.println("reward already exist for the transaction");
            return;
        }
        Reward reward=Reward.builder().senderId(transaction.getSenderId())
                .points(transaction.getAmount()%5)
                .sendAt(LocalDateTime.now())
                .transactionId(transaction.getId()).build();
        rewardService.save(reward);
        System.out.println("reward added successfully");
    }
}
