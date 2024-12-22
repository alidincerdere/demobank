package com.demobank.account.account_api.domain.service;


import com.demobank.account.account_api.domain.model.Customer;

public interface CustomerService {
   
    long create (String name, String surName);

    Customer retrieve(long customerId);
}
