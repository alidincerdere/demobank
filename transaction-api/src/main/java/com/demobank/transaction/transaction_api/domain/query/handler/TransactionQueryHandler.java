package com.demobank.transaction.transaction_api.domain.query.handler;

import com.demobank.transaction.transaction_api.domain.query.TransactionQuery;

public interface TransactionQueryHandler<T extends TransactionQuery, R> {

    R handle(T t);
    
}
