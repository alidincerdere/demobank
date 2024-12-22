package com.demobank.account.account_api.domain.port;

import java.util.List;
import java.util.UUID;

import com.demobank.account.account_api.domain.model.Customer;

public interface CustomerDataPort {
    
    Customer retrieveUser(UUID customerId);
    List<Customer> retrieveUserList();
 }
