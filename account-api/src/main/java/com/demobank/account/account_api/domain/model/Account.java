package com.demobank.account.account_api.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private UUID accountId;
    private UUID customerId;
    private BigDecimal amount;
    
}
