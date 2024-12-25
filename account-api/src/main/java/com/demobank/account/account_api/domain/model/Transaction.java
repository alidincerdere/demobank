package com.demobank.account.account_api.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    
    private UUID transactionId;
    private BigDecimal amount;
    private String TransactionType;
    private LocalDateTime date;
}
