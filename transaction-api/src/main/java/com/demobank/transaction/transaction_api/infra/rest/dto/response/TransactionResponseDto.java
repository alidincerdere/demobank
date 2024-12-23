package com.demobank.transaction.transaction_api.infra.rest.dto.response;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDto {
    
    private String result;
    private int resultCode;
    private UUID transactionId;
}
