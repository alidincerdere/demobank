package com.demobank.transaction.transaction_api.infra.rest;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController implements TransactionOperations {

    @Override
    public String home() {
        return "hello transaction service";
    }
    
}
