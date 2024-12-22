package com.demobank.account.account_api.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {

    private UUID accountId;
    private UUID customerId;
    private BigDecimal amount;
    
}
