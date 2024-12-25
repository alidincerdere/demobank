package com.demobank.transaction.transaction_api.infra.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.demobank.transaction.transaction_api.domain.command.ProcessTransaction;
import com.demobank.transaction.transaction_api.domain.command.handler.TransactionCommandHandler;
import com.demobank.transaction.transaction_api.domain.model.TransactionResponse;
import com.demobank.transaction.transaction_api.domain.model.TransactionType;
import com.demobank.transaction.transaction_api.infra.rest.dto.request.TransactionRequestDto;
import com.demobank.transaction.transaction_api.infra.rest.dto.response.TransactionResponseDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TransactionController implements TransactionOperations {

    private TransactionCommandHandler<ProcessTransaction, TransactionResponse> processHandler;

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

}
