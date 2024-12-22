package com.demobank.account.account_api.domain.command.handler;

import java.util.UUID;

import com.demobank.account.account_api.domain.command.CreateCustomer;

public class CreateCustomerCommandHandler implements CommandHandler<CreateCustomer, UUID> {

    @Override
    public UUID handle(CreateCustomer command) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }
    
}
