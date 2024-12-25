package com.demobank.account.account_api.domain.query;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.demobank.account.account_api.domain.model.Transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountQueryResponse {
    private UUID accountId;
    private UUID customerId;
    private BigDecimal amount;
    private List<Transaction> transactionList;
}
