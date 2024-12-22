package com.demobank.account.account_api.domain.port;

import java.util.List;

import com.demobank.account.account_api.domain.model.Customer;

public interface CustomerDataPort {
    
    Customer retrieveUser(long customerId);
    List<Customer> retrieveUserList();
    long create(String name, String surName);
 }
