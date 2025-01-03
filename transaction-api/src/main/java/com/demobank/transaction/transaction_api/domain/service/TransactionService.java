package com.demobank.transaction.transaction_api.domain.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.demobank.transaction.transaction_api.domain.model.Transaction;
import com.demobank.transaction.transaction_api.domain.model.TransactionResult;
import com.demobank.transaction.transaction_api.domain.model.TransactionType;

public interface TransactionService {

    TransactionResult process(UUID accountId, BigDecimal amount, TransactionType type);

    UUID saveTransaction(UUID accountId, BigDecimal amount, TransactionType type);

    List<Transaction> getTransactionListByAccountId(UUID accountId);
    
}
