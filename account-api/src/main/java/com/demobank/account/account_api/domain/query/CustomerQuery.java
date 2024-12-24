package com.demobank.account.account_api.domain.query;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerQuery implements Query {
    
    private UUID id;
}
