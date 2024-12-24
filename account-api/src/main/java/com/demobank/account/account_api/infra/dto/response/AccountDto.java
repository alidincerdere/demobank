package com.demobank.account.account_api.infra.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {
    
    private UUID id;
    private BigDecimal amount;
}
