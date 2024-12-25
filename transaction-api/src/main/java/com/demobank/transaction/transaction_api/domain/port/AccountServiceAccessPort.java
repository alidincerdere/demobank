package com.demobank.transaction.transaction_api.domain.port;

import java.math.BigDecimal;
import java.util.UUID;

import com.demobank.transaction.transaction_api.domain.model.TransactionResult;

public interface AccountServiceAccessPort {

    TransactionResult deposit(UUID accountId, BigDecimal amount);

    TransactionResult withdraw(UUID accountId, BigDecimal amount);
    
}
