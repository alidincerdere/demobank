package com.demobank.account.account_api.domain.service;

import java.math.BigDecimal;
import java.util.List;

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
    public Long create(long customerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public AccountUpdateResult deposit(long accountId, BigDecimal amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deposit'");
    }

    @Override
    public AccountUpdateResult withdraw(long accountId, BigDecimal amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'withdraw'");
    }

    @Override
    public List<Account> retrieveAccountList(long customerId) {

        return accountDataPort.retrieveAccountList(customerId);
    }
    
}
