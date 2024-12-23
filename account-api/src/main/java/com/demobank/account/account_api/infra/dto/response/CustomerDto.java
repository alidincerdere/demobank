package com.demobank.account.account_api.infra.dto.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    
    private UUID id;
    private String name;
    private String surName;
    private BigDecimal balance;
    private List<AccountDto> accountList;
}
