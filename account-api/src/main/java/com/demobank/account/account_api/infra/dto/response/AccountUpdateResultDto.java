package com.demobank.account.account_api.infra.dto.response;

import com.demobank.account.account_api.domain.model.AccountUpdateResult;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountUpdateResultDto {

    private AccountUpdateResult result;
    
}
