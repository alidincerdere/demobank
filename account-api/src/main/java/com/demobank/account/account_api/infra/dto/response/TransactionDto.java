package com.demobank.account.account_api.infra.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    
    private UUID transactionId;
    private String transactionType;
    private LocalDateTime date;
    private BigDecimal amount;
    
}
