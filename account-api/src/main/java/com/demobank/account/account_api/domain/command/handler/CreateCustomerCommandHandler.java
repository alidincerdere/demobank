package com.demobank.account.account_api.domain.command.handler;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.demobank.account.account_api.domain.command.CreateCustomer;
import com.demobank.account.account_api.domain.service.CustomerService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateCustomerCommandHandler implements CommandHandler<CreateCustomer, UUID> {

    private CustomerService customerService;

    @Override
    public UUID handle(CreateCustomer command) {

        return customerService.create(command.getName(), command.getSurName());
    }
    
}
