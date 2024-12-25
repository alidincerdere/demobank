package com.demobank.transaction.transaction_api.domain.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.demobank.transaction.transaction_api.domain.model.Transaction;
import com.demobank.transaction.transaction_api.domain.model.TransactionResult;
import com.demobank.transaction.transaction_api.domain.model.TransactionType;
import com.demobank.transaction.transaction_api.domain.port.AccountServiceAccessPort;
import com.demobank.transaction.transaction_api.domain.port.TransactionDataPort;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DefaultTransactionService implements TransactionService {

    private TransactionDataPort transactionDataPort;
    private AccountServiceAccessPort accountServiceAccessPort;

    @Override
    public TransactionResult process(UUID accountId, BigDecimal amount, TransactionType type) {

        // update account balance
        // request to account service
        TransactionResult result;
        if(type.equals(TransactionType.DEPOSIT)) {
            result = accountServiceAccessPort.deposit(accountId, amount);
        } else {
            result = accountServiceAccessPort.withdraw(accountId, amount);
        }

        return result;

    }

    @Override
    public UUID saveTransaction(UUID accountId, BigDecimal amount, TransactionType type) {
        Transaction transaction = Transaction.builder().accountId(accountId).amount(amount)
                .dateTime(LocalDateTime.now()).type(type).build();

        return transactionDataPort.saveTransaction(transaction);

    
    }

    @Override
    public List<Transaction> getTransactionListByAccountId(UUID accountId) {

        return transactionDataPort.retrieveAccountTransactions(accountId);
    }

}
