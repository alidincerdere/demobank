package com.demobank.account.account_api.domain.port;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.demobank.account.account_api.domain.model.Transaction;

public interface TransactionServicePort {

    void topUpAccount(UUID accountId, BigDecimal initialAmount);

    List<Transaction> retrieveTransactionsByAccount(UUID accountId);
    
}
