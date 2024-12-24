package com.demobank.account.account_api.domain.command.handler;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.demobank.account.account_api.domain.command.CreateAccount;
import com.demobank.account.account_api.domain.port.TransactionServicePort;
import com.demobank.account.account_api.domain.service.AccountService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateAccountCommandHandler implements CommandHandler<CreateAccount, UUID> {

    private AccountService accountService;
    private TransactionServicePort transactionServicePort;

    @Override
    public UUID handle(CreateAccount command) {

        UUID accountId = accountService.create(command.getCustomerId());
        if(command.getInitialAmount().compareTo(BigDecimal.ZERO)==1) {
            transactionServicePort.topUpAccount(accountId, command.getInitialAmount());
        }

        return accountId;
 
    }
    
}
