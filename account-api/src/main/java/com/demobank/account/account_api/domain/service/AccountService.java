package com.demobank.account.account_api.domain.service;

import java.math.BigDecimal;
import java.util.List;

import com.demobank.account.account_api.domain.model.Account;
import com.demobank.account.account_api.domain.model.AccountUpdateResult;

public interface AccountService {

    Long create(long customerId);

    AccountUpdateResult deposit(long accountId, BigDecimal amount);

    AccountUpdateResult withdraw(long accountId, BigDecimal amount);

    List<Account> retrieveAccountList(long customerId);


} 
