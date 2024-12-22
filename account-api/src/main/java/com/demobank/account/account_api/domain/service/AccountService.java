package com.demobank.account.account_api.domain.service;

import java.math.BigDecimal;
import java.util.List;

import com.demobank.account.account_api.domain.model.Account;

public interface AccountService {

    Long create(long customerId);

    void deposit(long accountId, BigDecimal amount);

    void withdraw(long accountId, BigDecimal amount);

    List<Account> retrieveAccountList(long customerId);


} 
