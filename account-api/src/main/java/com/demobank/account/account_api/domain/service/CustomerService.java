package com.demobank.account.account_api.domain.service;


import java.util.UUID;

import com.demobank.account.account_api.domain.model.Customer;

public interface CustomerService {
   
    UUID create (String name, String surName);

    Customer retrieve(UUID customerId);
}
