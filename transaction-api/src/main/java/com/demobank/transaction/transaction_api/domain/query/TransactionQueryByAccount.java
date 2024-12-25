package com.demobank.transaction.transaction_api.domain.query;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionQueryByAccount implements TransactionQuery {
    
    private UUID accountId;
}
