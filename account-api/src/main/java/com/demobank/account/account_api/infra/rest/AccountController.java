package com.demobank.account.account_api.infra.rest;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController implements AccountOperations {

    @Override
    public String home() {
      
        return "hello account service";
    }
    
}
