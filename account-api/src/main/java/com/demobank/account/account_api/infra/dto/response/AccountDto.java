package com.demobank.account.account_api.infra.dto.response;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {
    
    private Long id;
    private BigDecimal amount;
}
