package com.just_pay.transaction_service.facade;

import com.just_pay.transaction_service.dto.TransferRequest;
import com.just_pay.transaction_service.dto.TransferResponse;
import com.just_pay.transaction_service.mapper.TransactionMapper;
import com.just_pay.transaction_service.model.Transaction;
import com.just_pay.transaction_service.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class TransactionFacade {
    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;
    private final KafkaTemplate<String, Transaction> kafkaTemplate;
    public TransferResponse create(TransferRequest transferRequest) {
        CompletableFuture<SendResult<String,Transaction>> future= kafkaTemplate.send("transaction-events",transferRequest.getSenderId(),transactionMapper.tranferRequestToTransaction(transferRequest));
        future.whenComplete((res,ex)->{
            if(ex==null){
                System.out.println("data send successfully"+res);
            }else
                throw new RuntimeException("data send failed");
        });
        return transactionMapper.transactionToTransferResponse(
                transactionService.createTransaction(
                        transactionMapper.tranferRequestToTransaction(transferRequest)));
    }

    public List<TransferResponse> getAllTransaction() {
        return transactionService.getAllTransaction()
                .stream().map(transactionMapper::transactionToTransferResponse).toList();
    }
}
