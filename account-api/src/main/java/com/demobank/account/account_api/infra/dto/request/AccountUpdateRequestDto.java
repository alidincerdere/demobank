package com.demobank.account.account_api.infra.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AccountUpdateRequestDto {
    private UUID accountId;
    private BigDecimal amount;
}
