package com.demobank.transaction.transaction_api.domain.command.handler;

import com.demobank.transaction.transaction_api.domain.command.TransactionCommand;

public interface TransactionCommandHandler<T extends TransactionCommand,R> {
    
    R handle(T t);

}
