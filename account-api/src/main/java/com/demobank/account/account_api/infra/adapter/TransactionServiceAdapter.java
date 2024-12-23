package com.demobank.account.account_api.infra.adapter;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.demobank.account.account_api.domain.port.TransactionServicePort;

@Component
public class TransactionServiceAdapter implements TransactionServicePort {

    @Override
    public void topUpAccount(long accountId, BigDecimal initialAmount) {
       

        
    }
    
}
