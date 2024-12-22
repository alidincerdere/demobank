package com.demobank.account.account_api.domain.query.handler;

import com.demobank.account.account_api.domain.query.Query;
import com.demobank.account.account_api.domain.query.QueryResponse;

public interface QueryHandler <Q extends Query, R extends QueryResponse> {

    R handle(Q query);
    
}
