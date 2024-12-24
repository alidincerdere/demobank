package com.demobank.account.account_api.domain.command.handler;

import org.springframework.stereotype.Component;

import com.demobank.account.account_api.domain.command.WithdrawCommand;
import com.demobank.account.account_api.domain.model.AccountUpdateResult;

@Component
public class WithdrawCommandHandler implements CommandHandler<WithdrawCommand, AccountUpdateResult> {

    @Override
    public AccountUpdateResult handle(WithdrawCommand command) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }
    
}
