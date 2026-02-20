package com.just_pay.transaction_service.mapper;

import com.just_pay.transaction_service.dto.TransferRequest;
import com.just_pay.transaction_service.dto.TransferResponse;
import com.just_pay.transaction_service.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public Transaction tranferRequestToTransaction(TransferRequest transferRequest){
        return Transaction.builder()
                .senderId(transferRequest.getSenderId())
                .receiverId(transferRequest.getReceiverId())
                .status("paid")
                .amount(transferRequest.getAmount()).build();
    }

    public TransferResponse transactionToTransferResponse(Transaction transaction){
        return TransferResponse.builder()
                .senderId(transaction.getSenderId())
                .receiverId(transaction.getReceiverId())
                .amount(transaction.getAmount()).build();
    }
}
