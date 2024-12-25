package com.demobank.transaction.transaction_api.infra.adapter.dto;

import com.demobank.transaction.transaction_api.domain.model.TransactionResult;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountUpdateResultDto {

    private TransactionResult result;
    
}
