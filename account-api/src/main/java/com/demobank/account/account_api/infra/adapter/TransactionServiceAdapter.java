package com.demobank.account.account_api.infra.adapter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.demobank.account.account_api.domain.model.Transaction;
import com.demobank.account.account_api.domain.port.TransactionServicePort;
import com.demobank.account.account_api.infra.adapter.dto.TransactionQueryResponseDto;
import com.demobank.account.account_api.infra.adapter.dto.TransactionRequestDto;
import com.demobank.account.account_api.infra.adapter.dto.TransactionResponseDto;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TransactionServiceAdapter implements TransactionServicePort {

    public static final String DEPOSIT = "DEPOSIT";

    private WebClient webClient;
    private ModelMapper mapper;

    @Override
    public void topUpAccount(UUID accountId, BigDecimal initialAmount) {

        TransactionRequestDto transactionRequestDto = TransactionRequestDto.builder().accountId(accountId)
                .amount(initialAmount).transactionType(DEPOSIT).build();

        webClient.post().uri(uriBuilder -> uriBuilder
                .path("/transaction/process")
                .build()).bodyValue(transactionRequestDto).retrieve().bodyToMono(TransactionResponseDto.class).block();

    }

    @Override
    public List<Transaction> retrieveTransactionsByAccount(UUID accountId) {

        List<TransactionQueryResponseDto> transactionDtoList = webClient.get().uri(uriBuilder -> uriBuilder
                .path("/transaction").queryParam("accountId", accountId).build()).retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<TransactionQueryResponseDto>>() {
                }).block();

        return transactionDtoList.stream().map(x->  mapper.map(x, Transaction.class)).toList();

    }

}
