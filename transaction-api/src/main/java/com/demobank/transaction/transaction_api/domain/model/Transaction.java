package com.demobank.transaction.transaction_api.domain.model;

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
    private UUID accountId;
    private BigDecimal amount;
    private TransactionType type;
    private LocalDateTime dateTime;
    
}
