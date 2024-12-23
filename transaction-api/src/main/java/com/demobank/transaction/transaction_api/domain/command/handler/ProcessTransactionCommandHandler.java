package com.demobank.transaction.transaction_api.domain.command.handler;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.demobank.transaction.transaction_api.domain.command.ProcessTransaction;
import com.demobank.transaction.transaction_api.domain.model.TransactionResponse;
import com.demobank.transaction.transaction_api.domain.model.TransactionResult;
import com.demobank.transaction.transaction_api.domain.service.TransactionService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProcessTransactionCommandHandler
        implements TransactionCommandHandler<ProcessTransaction, TransactionResponse> {

    private TransactionService transactionService;

    @Override
    public TransactionResponse handle(ProcessTransaction command) {

        TransactionResult transactionResult = transactionService.process(command.getAccountId(), command.getAmount(), command.getType());

        UUID transactionId = null;
        if(transactionResult == TransactionResult.SUCCESS) {
            transactionId = transactionService.saveTransaction(command.getAccountId(), command.getAmount(), command.getType());
        }

        return TransactionResponse.builder().transactionId(transactionId).transactionResult(transactionResult).build();

    }

}
