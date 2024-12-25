package com.demobank.account.account_api.domain.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.demobank.account.account_api.domain.model.Account;
import com.demobank.account.account_api.domain.model.AccountUpdateResult;
import com.demobank.account.account_api.domain.model.Customer;
import com.demobank.account.account_api.domain.port.AccountDataPort;
import com.demobank.account.account_api.domain.port.CustomerDataPort;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@AllArgsConstructor
@Slf4j
public class DefaultAccountService implements AccountService{

    private AccountDataPort accountDataPort;
    private CustomerDataPort customerDataPort;

    @Override
    public UUID create(UUID customerId) {
       
        //retrieve user to check if customer id is valid
        Customer customer = customerDataPort.retrieveUser(customerId);
        Account account = Account.builder().amount(BigDecimal.ZERO).customerId(customerId).build();
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
            BigDecimal updatedAccount = currentAmount.add(amount);
            account.setAmount(updatedAccount);
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
            if(account.getAmount().compareTo(amount)==-1) {
                result = AccountUpdateResult.NOT_ENOUGH_FUNDS;
            } else {
                BigDecimal currentAmount = account.getAmount();
                BigDecimal updatedAccount = currentAmount.subtract(amount);
                account.setAmount(updatedAccount);
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
