package com.demobank.account.account_api.infra.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/account")
public interface AccountOperations {
    
    @GetMapping("/home")
    public String home();
}
