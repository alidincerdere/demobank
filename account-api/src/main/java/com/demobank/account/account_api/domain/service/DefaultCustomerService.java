package com.demobank.account.account_api.domain.service;

import org.springframework.stereotype.Service;

import com.demobank.account.account_api.domain.model.Customer;
import com.demobank.account.account_api.domain.port.CustomerDataPort;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DefaultCustomerService implements CustomerService {

    private CustomerDataPort customerDataPort;

    @Override
    public long create(String name, String surName) {

        return customerDataPort.create(name, surName);
    }

    @Override
    public Customer retrieve(long customerId) {
        
        return customerDataPort.retrieveUser(customerId);
    }
    
}
