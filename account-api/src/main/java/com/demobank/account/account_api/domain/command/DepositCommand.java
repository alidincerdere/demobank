package com.demobank.account.account_api.domain.command;

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
public class DepositCommand implements Command {
    
    private BigDecimal amount;
    private UUID accountId;
}
