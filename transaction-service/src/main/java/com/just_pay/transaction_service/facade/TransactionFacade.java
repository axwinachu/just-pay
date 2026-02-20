package com.just_pay.transaction_service.facade;

import com.just_pay.transaction_service.dto.TransferRequest;
import com.just_pay.transaction_service.dto.TransferResponse;
import com.just_pay.transaction_service.mapper.TransactionMapper;
import com.just_pay.transaction_service.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TransactionFacade {
    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;
    public TransferResponse create(TransferRequest transferRequest) {
        return transactionMapper.transactionToTransferResponse(
                transactionService.createTransaction(
                        transactionMapper.tranferRequestToTransaction(transferRequest)));
    }

    public List<TransferResponse> getAllTransaction() {
        return transactionService.getAllTransaction()
                .stream().map(transactionMapper::transactionToTransferResponse).toList();
    }
}
