package com.demobank.transaction.transaction_api.infra.adapter;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.demobank.transaction.transaction_api.domain.model.TransactionResult;
import com.demobank.transaction.transaction_api.domain.port.AccountServiceAccessPort;
import com.demobank.transaction.transaction_api.infra.adapter.dto.AccountUpdateRequestDto;
import com.demobank.transaction.transaction_api.infra.adapter.dto.AccountUpdateResultDto;

import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
public class AccountServiceAccessAdapter implements AccountServiceAccessPort{

    private WebClient webClient;

    @Override
    public TransactionResult deposit(UUID accountId, BigDecimal amount) {

        AccountUpdateRequestDto accountUpdateRequestDto = AccountUpdateRequestDto.builder().accountId(accountId).amount(amount).build();

        AccountUpdateResultDto accountUpdateResultDto = webClient.put().uri(uriBuilder -> uriBuilder
                .path("/account/deposit")
                .build()).bodyValue(accountUpdateRequestDto).retrieve().bodyToMono(AccountUpdateResultDto.class).block();

        return accountUpdateResultDto.getResult();
    }

    @Override
    public TransactionResult withdraw(UUID accountId, BigDecimal amount) {
        AccountUpdateRequestDto accountUpdateRequestDto = AccountUpdateRequestDto.builder().accountId(accountId).amount(amount).build();

        AccountUpdateResultDto accountUpdateResultDto = webClient.put().uri(uriBuilder -> uriBuilder
                .path("/account/withdraw")
                .build()).bodyValue(accountUpdateRequestDto).retrieve().bodyToMono(AccountUpdateResultDto.class).block();

        return accountUpdateResultDto.getResult();
    }
    
}
