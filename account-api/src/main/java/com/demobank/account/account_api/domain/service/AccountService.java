package com.demobank.account.account_api.domain.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.demobank.account.account_api.domain.model.Account;
import com.demobank.account.account_api.domain.model.AccountUpdateResult;

public interface AccountService {

    UUID create(UUID customerId);

    AccountUpdateResult deposit(UUID accountId, BigDecimal amount);

    AccountUpdateResult withdraw(UUID accountId, BigDecimal amount);

    List<Account> retrieveAccountList(UUID customerId);


} 
