package com.demobank.transaction.transaction_api.domain.query.handler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.demobank.transaction.transaction_api.domain.model.Transaction;
import com.demobank.transaction.transaction_api.domain.query.TransactionQueryByAccount;
import com.demobank.transaction.transaction_api.domain.service.TransactionService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TransactionQueryByAccountHandler implements TransactionQueryHandler <TransactionQueryByAccount, List<Transaction>>{

    private TransactionService transactionService;

    @Override
    public List<Transaction> handle(TransactionQueryByAccount t) {

       return transactionService.getTransactionListByAccountId(t.getAccountId());
    }

    
}
