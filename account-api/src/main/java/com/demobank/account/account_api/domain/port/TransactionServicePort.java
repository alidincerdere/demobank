package com.demobank.account.account_api.domain.port;

import java.math.BigDecimal;

public interface TransactionServicePort {

    void topUpAccount(long accountId, BigDecimal initialAmount);
    
}
