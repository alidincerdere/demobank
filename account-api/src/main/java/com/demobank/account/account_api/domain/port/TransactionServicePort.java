package com.demobank.account.account_api.domain.port;

import java.math.BigDecimal;
import java.util.UUID;

public interface TransactionServicePort {

    void topUpAccount(UUID accountId, BigDecimal initialAmount);
    
}
