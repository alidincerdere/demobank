package com.demobank.account.account_api.domain.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerQuery implements Query {
    
    private long id;
}
