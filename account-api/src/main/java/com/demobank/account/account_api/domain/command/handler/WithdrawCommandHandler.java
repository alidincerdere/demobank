package com.demobank.account.account_api.domain.command.handler;

import org.springframework.stereotype.Component;

import com.demobank.account.account_api.domain.command.WithdrawCommand;
import com.demobank.account.account_api.domain.model.AccountUpdateResult;
import com.demobank.account.account_api.domain.service.AccountService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class WithdrawCommandHandler implements CommandHandler<WithdrawCommand, AccountUpdateResult> {

    private AccountService accountService;

    @Override
    public AccountUpdateResult handle(WithdrawCommand command) {
       
        return accountService.withdraw(command.getAccountId(), command.getAmount());
    }
    
}
