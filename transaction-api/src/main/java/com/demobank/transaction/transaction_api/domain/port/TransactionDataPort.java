package com.demobank.transaction.transaction_api.domain.port;

import java.util.List;
import java.util.UUID;

import com.demobank.transaction.transaction_api.domain.model.Transaction;

public interface TransactionDataPort {

    UUID saveTransaction(Transaction transaction);
    
    Transaction retrieveTransaction(UUID transactionId);

    List<Transaction> retrieveAccountTransactions(UUID accountId);
}
