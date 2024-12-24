package com.demobank.account.account_api.domain.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.demobank.account.account_api.domain.model.Customer;
import com.demobank.account.account_api.domain.port.CustomerDataPort;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DefaultCustomerService implements CustomerService {

    private CustomerDataPort customerDataPort;

    @Override
    public UUID create(String name, String surName) {

        return customerDataPort.create(name, surName);
    }

    @Override
    public Customer retrieve(UUID customerId) {
        
        return customerDataPort.retrieveUser(customerId);
    }
    
}
