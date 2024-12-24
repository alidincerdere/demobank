package com.demobank.account.account_api.domain.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.demobank.account.account_api.domain.model.Account;
import com.demobank.account.account_api.domain.model.AccountUpdateResult;
import com.demobank.account.account_api.domain.port.AccountDataPort;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class DefaultAccountService implements AccountService{

    private AccountDataPort accountDataPort;

    @Override
    public UUID create(UUID customerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public AccountUpdateResult deposit(UUID accountId, BigDecimal amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deposit'");
    }

    @Override
    public AccountUpdateResult withdraw(UUID accountId, BigDecimal amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'withdraw'");
    }

    @Override
    public List<Account> retrieveAccountList(UUID customerId) {

        return accountDataPort.retrieveAccountList(customerId);
    }
    
}
