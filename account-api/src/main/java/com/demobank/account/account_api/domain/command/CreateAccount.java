package com.demobank.account.account_api.domain.command;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateAccount implements Command{
    
    private long customerId;
    private BigDecimal initialAmount;
}
