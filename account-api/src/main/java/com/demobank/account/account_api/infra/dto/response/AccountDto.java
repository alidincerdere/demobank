package com.demobank.account.account_api.infra.dto.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    
    private UUID accountId;
    private BigDecimal amount;
    private List<TransactionDto> transactionList;
}
