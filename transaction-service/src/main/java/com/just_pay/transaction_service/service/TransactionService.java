package com.just_pay.transaction_service.service;

import com.just_pay.transaction_service.model.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction createTransaction(Transaction transaction);

    public List<Transaction> getAllTransaction();
}
