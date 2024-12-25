package com.demobank.transaction.transaction_api.infra.adapter.dto;

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
