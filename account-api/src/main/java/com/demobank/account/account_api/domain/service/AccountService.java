package com.demobank.account.account_api.domain.service;

import java.math.BigDecimal;
import java.util.UUID;

public interface AccountService {

    UUID create(UUID customerId);

    void deposit(UUID accountId, BigDecimal amount);

    void withdraw(UUID accountId, BigDecimal amount);


} 
