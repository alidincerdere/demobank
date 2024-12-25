package com.demobank.transaction.transaction_api.infra.rest.dto.response;

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
public class TransactionQueryResponseDto {

    private UUID transactionId;
    private String transactionType;
    private LocalDateTime date;
    private BigDecimal amount;
    
}
