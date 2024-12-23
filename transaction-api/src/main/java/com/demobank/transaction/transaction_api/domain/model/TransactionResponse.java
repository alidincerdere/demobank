package com.demobank.transaction.transaction_api.domain.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

    private TransactionResult transactionResult;
    private UUID transactionId;
    
}
