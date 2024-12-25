package com.demobank.transaction.transaction_api.infra.adapter;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.demobank.transaction.transaction_api.domain.model.Transaction;
import com.demobank.transaction.transaction_api.domain.model.TransactionType;
import com.demobank.transaction.transaction_api.domain.port.TransactionDataPort;
import com.demobank.transaction.transaction_api.infra.persistence.entity.TransactionEntity;
import com.demobank.transaction.transaction_api.infra.persistence.repository.TransactionRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TransactionDataAdapter implements TransactionDataPort {

    private TransactionRepository transactionRepository;
    private ModelMapper mapper;

    @Override
    public UUID saveTransaction(Transaction transaction) {

        TransactionEntity transactionEntity = TransactionEntity.builder()
                .accountId(transaction.getAccountId())
                .amount(transaction.getAmount())
                .transactionType(transaction.getType().name())
                .transactionTypeCode(transaction.getType().ordinal())
                .date(transaction.getDateTime())
                .build();
        transactionEntity = transactionRepository.save(transactionEntity);
        return transactionEntity.getTransactionId();
    }

    @Override
    public Transaction retrieveTransaction(UUID transactionId) {

        TransactionEntity transactionEntity = transactionRepository.getReferenceById(transactionId);
        Transaction transaction = Transaction.builder()
                .accountId(transactionEntity.getAccountId())
                .amount(transactionEntity.getAmount())
                .type(TransactionType.valueOf(transactionEntity.getTransactionType()))
                .dateTime(transactionEntity.getDate())
                .build();
        return transaction;
    }

    @Override
    public List<Transaction> retrieveAccountTransactions(UUID accountId) {

        List<TransactionEntity> transactionEntityList = transactionRepository.findAllByAccountId(accountId);

        return transactionEntityList.stream().map(x -> mapper.map(x, Transaction.class)).toList();
    }

}
