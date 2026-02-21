package com.just_pay.notification_service.facade;

import com.just_pay.notification_service.dto.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class TransactionConsumer {

    @KafkaListener(
            topics = "transaction-events",
            groupId = "transaction-group",
            containerFactory = "transactionKafkaListenerFactory",
            concurrency = "3"
    )
    public void consume(Transaction event, Acknowledgment acknowledgment) {

        try {
            System.out.println("Received: " + event);
            processTransaction(event);
            acknowledgment.acknowledge();

        } catch (Exception e) {

            System.out.println("Processing failed");
        }
    }

    private void processTransaction(Transaction event) {

     }
}