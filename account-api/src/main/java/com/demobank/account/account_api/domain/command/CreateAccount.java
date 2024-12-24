package com.demobank.account.account_api.domain.command;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateAccount implements Command{
    
    private UUID customerId;
    private BigDecimal initialAmount;
}
