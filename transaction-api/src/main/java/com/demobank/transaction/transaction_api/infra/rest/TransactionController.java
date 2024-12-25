package com.demobank.transaction.transaction_api.infra.rest;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.demobank.transaction.transaction_api.domain.command.ProcessTransaction;
import com.demobank.transaction.transaction_api.domain.command.handler.TransactionCommandHandler;
import com.demobank.transaction.transaction_api.domain.model.Transaction;
import com.demobank.transaction.transaction_api.domain.model.TransactionResponse;
import com.demobank.transaction.transaction_api.domain.model.TransactionType;
import com.demobank.transaction.transaction_api.domain.query.TransactionQueryByAccount;
import com.demobank.transaction.transaction_api.domain.query.handler.TransactionQueryHandler;
import com.demobank.transaction.transaction_api.infra.rest.dto.request.TransactionRequestDto;
import com.demobank.transaction.transaction_api.infra.rest.dto.response.TransactionQueryResponseDto;
import com.demobank.transaction.transaction_api.infra.rest.dto.response.TransactionResponseDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TransactionController implements TransactionOperations {

    private TransactionCommandHandler<ProcessTransaction, TransactionResponse> processHandler;
    private TransactionQueryHandler<TransactionQueryByAccount, List<Transaction>> transactionQueryHandler;
    private ModelMapper mapper;

    @Override
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("hello transaction service");
    }

    @Override
    public ResponseEntity<TransactionResponseDto> processTransaction(TransactionRequestDto requestDto) {

        TransactionResponse transactionResponse = processHandler
                .handle(ProcessTransaction.builder().accountId(requestDto.getAccountId())
                        .amount(requestDto.getAmount()).type(TransactionType.valueOf(requestDto.getTransactionType()))
                        .build());

        TransactionResponseDto responseDto = TransactionResponseDto.builder()
                .transactionId(transactionResponse.getTransactionId())
                .result(transactionResponse.getTransactionResult().name())
                .resultCode(transactionResponse.getTransactionResult().ordinal()).build();

        return ResponseEntity.ok().body(responseDto);
    }

    @Override
    public ResponseEntity<List<TransactionQueryResponseDto>> retrieveTransactionForAccountId(UUID accountId) {

        List<Transaction> transactions = transactionQueryHandler
                .handle(TransactionQueryByAccount.builder().accountId(accountId).build());
        return ResponseEntity.ok()
                .body(transactions.stream().map(x -> mapper.map(x, TransactionQueryResponseDto.class)).toList());
    }

}
