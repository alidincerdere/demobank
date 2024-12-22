package com.demobank.transaction.transaction_api.infra.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/transaction")
public interface TransactionOperations {
    
    @GetMapping("/home")
    public String home();
}
