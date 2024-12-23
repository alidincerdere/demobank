package com.demobank.transaction.transaction_api.infra.rest.dto.request;

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
public class TransactionRequestDto {

    private BigDecimal amount;
    private String transactionType;
    private UUID accountId;
    
}
