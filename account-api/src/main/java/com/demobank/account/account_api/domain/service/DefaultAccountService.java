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
       
        Account account = Account.builder().build();
        return accountDataPort.save(account);
    }

    @Override
    public AccountUpdateResult deposit(UUID accountId, BigDecimal amount) {
        AccountUpdateResult result;
        Account account = accountDataPort.retrieveAccount(accountId);
        if (account == null) {
            result = AccountUpdateResult.ACCOUNT_NOT_FOUND; 
        } else {
            BigDecimal currentAmount = account.getAmount();
            currentAmount.add(amount);
            account.setAmount(currentAmount);
            accountDataPort.save(account);
            result = AccountUpdateResult.SUCCESS;

        }
        return result;
    }

    @Override
    public AccountUpdateResult withdraw(UUID accountId, BigDecimal amount) {
        AccountUpdateResult result;
        Account account = accountDataPort.retrieveAccount(accountId);
        if (account == null) {
            result = AccountUpdateResult.ACCOUNT_NOT_FOUND; 
        } else {
            if(account.getAmount().compareTo(amount)<1) {
                result = AccountUpdateResult.NOT_ENOUGH_FUNDS;
            } else {
                BigDecimal currentAmount = account.getAmount();
                currentAmount.subtract(amount);
                account.setAmount(currentAmount);
                accountDataPort.save(account);
                result = AccountUpdateResult.SUCCESS;
            }
        }
     
     
        return result;
    }

    @Override
    public List<Account> retrieveAccountList(UUID customerId) {

        return accountDataPort.retrieveAccountList(customerId);
    }
    
}
