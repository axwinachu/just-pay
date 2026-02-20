package com.just_pay.transaction_service.controller;

import com.just_pay.transaction_service.dto.TransferRequest;
import com.just_pay.transaction_service.dto.TransferResponse;
import com.just_pay.transaction_service.facade.TransactionFacade;
import com.just_pay.transaction_service.service.TransactionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transfer")
public class TransactionController {
    private final TransactionFacade transactionFacade;
    @PostMapping("/pay")
    public TransferResponse create(@RequestBody TransferRequest transferRequest){
        return transactionFacade.create(transferRequest);
    }
    @GetMapping("/history")
    public List<TransferResponse> getAllTransaction(){
        return transactionFacade.getAllTransaction();
    }
}
