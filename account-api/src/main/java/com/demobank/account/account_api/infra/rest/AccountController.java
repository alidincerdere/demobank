package com.demobank.account.account_api.infra.rest;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.demobank.account.account_api.domain.command.CreateAccount;
import com.demobank.account.account_api.domain.command.DepositCommand;
import com.demobank.account.account_api.domain.command.WithdrawCommand;
import com.demobank.account.account_api.domain.command.handler.CreateAccountCommandHandler;
import com.demobank.account.account_api.domain.command.handler.DepositCommandHandler;
import com.demobank.account.account_api.domain.command.handler.WithdrawCommandHandler;
import com.demobank.account.account_api.domain.model.AccountUpdateResult;
import com.demobank.account.account_api.infra.dto.request.AccountCreateRequestDto;
import com.demobank.account.account_api.infra.dto.request.AccountUpdateRequestDto;
import com.demobank.account.account_api.infra.dto.response.AccountCreateResponseDto;
import com.demobank.account.account_api.infra.dto.response.AccountUpdateResultDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AccountController implements AccountOperations {

    private DepositCommandHandler depositCommandHandler;
    private WithdrawCommandHandler withdrawCommandHandler;
    private CreateAccountCommandHandler createAccountCommandHandler;
    private ModelMapper modelMapper;

    @Override
    public String home() {

        return "hello account service";
    }

    @Override
    public ResponseEntity<AccountUpdateResultDto> deposit(AccountUpdateRequestDto request) {

        AccountUpdateResult result = depositCommandHandler.handle(modelMapper.map(request, DepositCommand.class));
        return ResponseEntity.ok().body(new AccountUpdateResultDto(result));
    }

    @Override
    public ResponseEntity<AccountUpdateResultDto> withdraw(AccountUpdateRequestDto request) {

        AccountUpdateResult result = withdrawCommandHandler.handle(modelMapper.map(request, WithdrawCommand.class));
        return ResponseEntity.ok().body(new AccountUpdateResultDto(result));

    }

    @Override
    public ResponseEntity<AccountCreateResponseDto> create(AccountCreateRequestDto request) {

        UUID accountId = createAccountCommandHandler.handle(CreateAccount.builder().customerId(request.getCustomerId())
                .initialAmount(request.getInitialCredit()).build());

        AccountCreateResponseDto accountCreateResponseDto = AccountCreateResponseDto.builder().accountId(accountId).build();

        return ResponseEntity.ok().body(accountCreateResponseDto);
    }

}
