package com.demobank.account.account_api.infra.adapter.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionQueryResponseDto {

    private UUID transactionId;
    private String transactionType;
    private LocalDateTime date;
    private BigDecimal amount;
    
}
