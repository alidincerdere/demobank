package com.demobank.account.account_api.domain.command.handler;

import org.springframework.stereotype.Component;

import com.demobank.account.account_api.domain.command.DepositCommand;
import com.demobank.account.account_api.domain.model.AccountUpdateResult;
import com.demobank.account.account_api.domain.service.AccountService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DepositCommandHandler implements CommandHandler<DepositCommand, AccountUpdateResult>{

    private AccountService accountService;

    @Override
    public AccountUpdateResult handle(DepositCommand command) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }
    
}
