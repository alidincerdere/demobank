package com.demobank.transaction.transaction_api.domain.command;

import java.math.BigDecimal;
import java.util.UUID;

import com.demobank.transaction.transaction_api.domain.model.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessTransaction implements TransactionCommand {
    
    private BigDecimal amount;
    private UUID accountId;
    private TransactionType type;
}
