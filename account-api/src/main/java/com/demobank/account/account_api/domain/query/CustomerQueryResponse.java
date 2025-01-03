package com.demobank.account.account_api.domain.query;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerQueryResponse implements QueryResponse {
    
    private UUID customerId;
    private String name;
    private String surName;
    private BigDecimal balance;
    private List<AccountQueryResponse> accountList;
}
