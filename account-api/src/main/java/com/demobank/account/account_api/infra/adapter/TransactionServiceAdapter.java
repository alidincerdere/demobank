package com.demobank.account.account_api.infra.adapter;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.demobank.account.account_api.domain.port.TransactionServicePort;
import com.demobank.account.account_api.infra.adapter.dto.TransactionRequestDto;
import com.demobank.account.account_api.infra.adapter.dto.TransactionResponseDto;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TransactionServiceAdapter implements TransactionServicePort {

    public static final String DEPOSIT = "DEPOSIT";

    private WebClient webClient;

    @Override
    public void topUpAccount(UUID accountId, BigDecimal initialAmount) {

        TransactionRequestDto transactionRequestDto = TransactionRequestDto.builder().accountId(accountId)
                .amount(initialAmount).transactionType(DEPOSIT).build();

        webClient.post().uri(uriBuilder -> uriBuilder
                .path("/transaction/process")
                .build()).bodyValue(transactionRequestDto).retrieve().bodyToMono(TransactionResponseDto.class).block();

    }

}
