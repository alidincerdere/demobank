package com.demobank.transaction.transaction_api.domain.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.demobank.transaction.transaction_api.domain.model.Transaction;
import com.demobank.transaction.transaction_api.domain.model.TransactionResponse;
import com.demobank.transaction.transaction_api.domain.model.TransactionResult;
import com.demobank.transaction.transaction_api.domain.model.TransactionType;
import com.demobank.transaction.transaction_api.domain.port.TransactionDataPort;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DefaultTransactionService implements TransactionService {

    private TransactionDataPort transactionDataPort;

    @Override
    public TransactionResult process(UUID accountId, BigDecimal amount, TransactionType type) {

        // update account balance
        // request to account service

        return TransactionResult.SUCCESS;

    }

    @Override
    public UUID saveTransaction(UUID accountId, BigDecimal amount, TransactionType type) {
        Transaction transaction = Transaction.builder().accountId(accountId).amount(amount)
                .dateTime(LocalDateTime.now()).type(type).build();

        return transactionDataPort.saveTransaction(transaction);

    
    }

}
